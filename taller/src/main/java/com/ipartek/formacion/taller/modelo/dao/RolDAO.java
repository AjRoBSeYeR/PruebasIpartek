package com.ipartek.formacion.taller.modelo.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import org.springframework.stereotype.Repository;

import com.ipartek.formacion.taller.modelo.config.ConnectionManager;
import com.ipartek.formacion.taller.modelo.pojo.Rol;
import com.mysql.jdbc.Connection;

@Repository
public class RolDAO implements IDAO<Rol> {
	private static final String SQL_GET_ALL = "SELECT id ,nombre FROM rol  ORDER BY id DESC LIMIT 1000;";
	private static final String SQL_GET_BY_ID = "SELECT id ,nombre FROM rol WHERE id=?;";
	private static final String SQL_DELETE = "DELETE FROM rol WHERE id=?;";
	private static final String SQL_INSERT = "INSERT INTO rol (nombre) VALUES (?);";
	private static final String SQL_UPDATE = "UPDATE rol SET nombre=? WHERE id=?;";

	@Override
	public ArrayList<Rol> getAll() {
		ArrayList<Rol> roles = new ArrayList<Rol>();

		try (Connection con = (Connection) ConnectionManager.getConnection();
				PreparedStatement pst = con.prepareStatement(SQL_GET_ALL);
				ResultSet rs = pst.executeQuery();) {
			while (rs.next()) {
				roles.add(RowMapper(rs));
			}

		} catch (Exception e) {
			e.printStackTrace();
		}

		return roles;
	}

	@Override
	public Rol getById(int idRol) {
		Rol rol = null;

		try (Connection con = (Connection) ConnectionManager.getConnection();
				PreparedStatement pst = con.prepareStatement(SQL_GET_BY_ID);) {

			pst.setInt(1, idRol);

			ResultSet rs = pst.executeQuery();

			while (rs.next()) {
				rol = RowMapper(rs);
			}

		} catch (Exception e) {
			e.printStackTrace();
		}

		return rol;
	}

	@Override
	public boolean delete(int idRol) throws SQLException {
		boolean eliminado = false;

		try (Connection con = (Connection) ConnectionManager.getConnection();
				PreparedStatement pst = con.prepareStatement(SQL_DELETE);) {

			pst.setInt(1, idRol);

			if (pst.executeUpdate() == 1) {
				eliminado = true;
			}

		}
		return eliminado;
	}

	@Override
	public boolean insert(Rol rol) throws SQLException {

		boolean creado = false;
		try (Connection con = (Connection) ConnectionManager.getConnection();
				PreparedStatement pst = con.prepareStatement(SQL_INSERT, Statement.RETURN_GENERATED_KEYS);) {

			pst.setString(1, rol.getNombre());

			if (pst.executeUpdate() == 1) {
				try (ResultSet idGenerado = pst.getGeneratedKeys();) {
					idGenerado.next();
					rol.setId((int) idGenerado.getLong(1));
					creado = true;
				} 

			}

		}
		return creado;
	}

	@Override
	public boolean modificar(Rol rol) throws SQLException {

		boolean modificado = false;
		try (Connection con = (Connection) ConnectionManager.getConnection();
				PreparedStatement pst = con.prepareStatement(SQL_UPDATE);) {

			pst.setString(1, rol.getNombre());
			pst.setInt(2, rol.getId());

			if (pst.executeUpdate() == 1) {
				modificado = true;
			}

		}
		return modificado;
	}

	private Rol RowMapper(ResultSet rs) throws SQLException {
		Rol rol = new Rol();
		rol.setId(rs.getInt("id"));
		rol.setNombre(rs.getString("nombre"));
		return rol;
	}

}
