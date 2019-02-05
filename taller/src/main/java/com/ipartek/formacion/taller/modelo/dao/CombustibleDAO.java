package com.ipartek.formacion.taller.modelo.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import org.springframework.stereotype.Repository;

import com.ipartek.formacion.taller.modelo.config.ConnectionManager;
import com.ipartek.formacion.taller.modelo.pojo.Combustible;
import com.mysql.jdbc.Connection;

@Repository
public class CombustibleDAO {
	private static final String SQL_GET_ALL = "SELECT id ,nombre FROM combustible  ORDER BY id DESC LIMIT 1000;";
	private static final String SQL_GET_BY_ID = "SELECT id ,nombre FROM combustible WHERE id=?;";
	private static final String SQL_DELETE = "DELETE FROM combustible WHERE id=?;";
	private static final String SQL_INSERT = "INSERT INTO combustible (nombre) VALUES (?);";
	private static final String SQL_UPDATE = "UPDATE combustible SET nombre=? WHERE id=?;";

	public ArrayList<Combustible> getAll() {
		ArrayList<Combustible> combustibles = new ArrayList<Combustible>();

		try (Connection con = (Connection) ConnectionManager.getConnection();
				PreparedStatement pst = con.prepareStatement(SQL_GET_ALL);
				ResultSet rs = pst.executeQuery();) {
			while (rs.next()) {
				combustibles.add(RowMapper(rs));
			}

		} catch (Exception e) {
			e.printStackTrace();
		}

		return combustibles;
	}

	public Combustible getById(int idCombustible) {
		Combustible combustible = null;

		try (Connection con = (Connection) ConnectionManager.getConnection();
				PreparedStatement pst = con.prepareStatement(SQL_GET_BY_ID);) {

			pst.setInt(1, idCombustible);

			ResultSet rs = pst.executeQuery();

			while (rs.next()) {
				combustible = RowMapper(rs);
			}

		} catch (Exception e) {
			e.printStackTrace();
		}

		return combustible;
	}

	public boolean delete(int idCombustible) throws SQLException {
		boolean eliminado = false;

		try (Connection con = (Connection) ConnectionManager.getConnection();
				PreparedStatement pst = con.prepareStatement(SQL_DELETE);) {

			pst.setInt(1, idCombustible);

			if (pst.executeUpdate() == 1) {
				eliminado = true;
			}

		}
		return eliminado;
	}

	public boolean insert(Combustible combustible) throws SQLException {

		boolean creado = false;
		try (Connection con = (Connection) ConnectionManager.getConnection();
				PreparedStatement pst = con.prepareStatement(SQL_INSERT, Statement.RETURN_GENERATED_KEYS);) {

			pst.setString(1, combustible.getNombre());

			if (pst.executeUpdate() == 1) {
				ResultSet idGenerado = pst.getGeneratedKeys();
				idGenerado.next();
				combustible.setId((int) idGenerado.getLong(1));
				creado = true;
			}

		}
		return creado;
	}
	
	public boolean modificar(Combustible combustible) throws SQLException {

		boolean modificado = false;
		try (Connection con = (Connection) ConnectionManager.getConnection();
				PreparedStatement pst = con.prepareStatement(SQL_UPDATE);) {

			pst.setString(1, combustible.getNombre());
			pst.setInt(2, combustible.getId());

			if (pst.executeUpdate() == 1) {
				modificado=true;
			}

		}
		return modificado;
	}

	private Combustible RowMapper(ResultSet rs) throws SQLException {
		Combustible combustible = new Combustible();
		combustible.setId(rs.getInt("id"));
		combustible.setNombre(rs.getString("nombre"));
		return combustible;
	}

}
