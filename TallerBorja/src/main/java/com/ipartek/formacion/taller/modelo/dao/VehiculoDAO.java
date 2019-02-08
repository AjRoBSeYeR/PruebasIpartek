package com.ipartek.formacion.taller.modelo.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Repository;

import com.ipartek.formacion.taller.modelo.config.ConnectionManager;
import com.ipartek.formacion.taller.modelo.pojo.Combustible;
import com.ipartek.formacion.taller.modelo.pojo.Modelo;
import com.ipartek.formacion.taller.modelo.pojo.Persona;
import com.ipartek.formacion.taller.modelo.pojo.Vehiculo;

@Repository
public class VehiculoDAO implements IDAO<Vehiculo> {

	private static final String SQL_GET_ALL = "SELECT c.id as 'id_combustible', c.nombre as 'combustible_nombre', m.id as 'id_modelo', m.nombre as 'nombre_modelo', v.id as 'id_vehiculo', v.numero_bastidor,v.matricula,p.id as 'id_propietario',p.nombre as 'nombre_propietario',p.apellidos,p.dni,p.telefono from vehiculo as v, modelo as m, combustible as c,persona as p where v.id_propietario=p.id and v.id_combustible=c.id and v.id_modelo=m.id;";
	private static final String SQL_GET_BY_ID = "SELECT id, numero_bastidor,matricula FROM vehiculo WHERE id=?;";
	private static final String SQL_DELETE = "DELETE FROM vehiculo WHERE id=?;";
	private static final String SQL_CREATE = "INSERT INTO vehiculo (numero_bastidor,matricula,id_propietario,id_combustible,id_modelo) VALUES(?,?,?,?,?)";
	private static final String SQL_UPDATE = "UPDATE combustible SET  numero_bastidor=?, matricula=? WHERE id=?;";

	@Override
	public Vehiculo getById(int id) {

		Vehiculo v = null;
		try (Connection conn = ConnectionManager.getConnection();
				PreparedStatement pst = conn.prepareStatement(SQL_GET_BY_ID);) {
			pst.setInt(1, id);
			try (ResultSet rs = pst.executeQuery();) {
				while (rs.next()) {
					v = rowMapper(rs);
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return v;
	}

	@Override
	public List<Vehiculo> getAll() {

		ArrayList<Vehiculo> vehiculos = new ArrayList<Vehiculo>();

		try (Connection conn = ConnectionManager.getConnection();
				PreparedStatement pst = conn.prepareStatement(SQL_GET_ALL);
				ResultSet rs = pst.executeQuery();) {
			while (rs.next()) {
				vehiculos.add(rowMapper(rs));
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return vehiculos;
	}

	@Override
	public boolean delete(int id) throws SQLException {

		boolean isDelete = false;
		try (Connection conn = ConnectionManager.getConnection();
				PreparedStatement pst = conn.prepareStatement(SQL_DELETE);) {
			pst.setInt(1, id);
			int affectedRows = pst.executeUpdate();
			if (affectedRows == 1) {
				isDelete = true;
				conn.commit();
			}else {
				conn.rollback();
			}
		}
		return isDelete;
	}

	@Override
	public boolean insert(Vehiculo vehiculo) throws SQLException {
		boolean isCreate = false;
		try (Connection conn = ConnectionManager.getConnection();
				PreparedStatement pst = conn.prepareStatement(SQL_CREATE, Statement.RETURN_GENERATED_KEYS);) {
			pst.setString(1, vehiculo.getNumeroBastidor());
			pst.setString(2, vehiculo.getMatricula());
			pst.setInt(3, vehiculo.getPropietario().getId());
			pst.setInt(4, vehiculo.getCombustible().getId());
			pst.setInt(5, vehiculo.getModelo().getId());

			int affectedRows = pst.executeUpdate();
			if (affectedRows == 1) {
				try (ResultSet generatedKeys = pst.getGeneratedKeys()) {
					if (generatedKeys.next()) {
						vehiculo.setId(generatedKeys.getInt(1));
						isCreate = true;
						conn.commit();
					}else {
						conn.rollback();
					}
				}
			}
		}
		return isCreate;
	}

	@Override
	public boolean update(Vehiculo vehiculo) throws SQLException {
		boolean isUpdate = false;
		try (Connection conn = ConnectionManager.getConnection();
				PreparedStatement pst = conn.prepareStatement(SQL_UPDATE);) {

			pst.setString(1, vehiculo.getNumeroBastidor());
			pst.setString(2, vehiculo.getMatricula());
			pst.setInt(3, vehiculo.getId());

			int affectedRows = pst.executeUpdate();
			if (affectedRows == 1) {
				isUpdate = true;
				conn.commit();
			}else {
				conn.rollback();
			}

		}
		return isUpdate;
	}

	private Vehiculo rowMapper(ResultSet rs) throws SQLException {

		Vehiculo v = new Vehiculo();
		v.setId(rs.getInt("id_vehiculo"));
		v.setNumeroBastidor(rs.getString("numero_bastidor"));
		v.setMatricula(rs.getString("matricula"));
		v.setModelo(new Modelo(rs.getInt("id_modelo"), rs.getString("nombre_modelo")));
		v.setCombustible(new Combustible(rs.getInt("id_combustible"), rs.getString("combustible_nombre")));
		v.setPropietario(new Persona(rs.getInt("id_propietario"), rs.getString("nombre_propietario"),
				rs.getString("apellidos"), rs.getString("dni"), rs.getString("telefono")));

		return v;
	}

}
