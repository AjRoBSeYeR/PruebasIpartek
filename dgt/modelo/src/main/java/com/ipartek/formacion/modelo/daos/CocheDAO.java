package com.ipartek.formacion.modelo.daos;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Types;
import java.util.ArrayList;

import org.apache.log4j.Logger;

import com.ipartek.formacion.modelo.cm.ConnectionManager;
import com.ipartek.formacion.modelo.pojo.Coche;

public class CocheDAO {

	private final static Logger LOG = Logger.getLogger(CocheDAO.class);
	private static CocheDAO INSTANCE = null;
	private static final String SQL_INSERT = "{call pa_coche_insert(?,?,?,?)}";
	private static final String SQL_GETALL = "SELECT * FROM coche ORDER BY id DESC LIMIT 100";
	private static final String SQL_GETMATRICULA = "{call pa_coche_getByMatricula(?)}";
	private static final String SQL_GETBYID = "SELECT * FROM COCHE WHERE ID=?";
	private static final String SQL_DELETEBYID = "DELETE FROM COCHE WHERE ID=?";
	private static final String SQL_UPDATE = "{call pa_coche_update(?,?,?)}";

	// constructor privado, solo acceso por getInstance()
	private CocheDAO() {
		super();
	}

	public synchronized static CocheDAO getInstance() {

		if (INSTANCE == null) {
			INSTANCE = new CocheDAO();
		}
		return INSTANCE;
	}

	private Coche rowMapper(ResultSet rs) throws SQLException {
		Coche c = new Coche();
		c.setId(rs.getLong("id"));
		c.setMatricula(rs.getString("matricula"));
		c.setModelo(rs.getString("modelo"));
		c.setKm(rs.getInt("km"));
		return c;
	}
	
	public boolean update(Coche c) throws SQLException {

		boolean resul = false;
		try (Connection conn = ConnectionManager.getConnection();
				CallableStatement cs = conn.prepareCall(SQL_UPDATE);) {

			cs.setString(1, c.getModelo());
			cs.setInt(2, c.getKm());
			cs.setLong(3, c.getId());
			int affectedRows = cs.executeUpdate();
			if (affectedRows == 1) {
				resul = true;
			}
		}
		return resul;

	}

	public Coche getByMatricula(String mat) {
		Coche c = null;
		try (Connection conn = ConnectionManager.getConnection();
				CallableStatement cs = conn.prepareCall(SQL_GETMATRICULA);) {

			cs.setString(1, mat);

			try (ResultSet rs = cs.executeQuery()) {
				try {
					while (rs.next()) {
						c = rowMapper(rs);
					}
				} catch (Exception e) {
					LOG.warn(e);
				}
			}

		} catch (Exception e) {
			LOG.error(e);
		}
		return c;
	}

	public ArrayList<Coche> getAll() {

		ArrayList<Coche> coches = new ArrayList<Coche>();
	

		try (Connection conn = ConnectionManager.getConnection();
				PreparedStatement pst = conn.prepareStatement(SQL_GETALL);
				ResultSet rs = pst.executeQuery()) {

			while (rs.next()) {
				try {
					Coche coche = new Coche();
					coche.setId(rs.getLong("id"));
					coche.setMatricula(rs.getString("matricula"));
					coche.setKm(rs.getInt("km"));
					coche.setModelo(rs.getString("modelo"));
					coches.add(coche);
				} catch (Exception e) {
					System.out.println("usuario no valido");
					e.printStackTrace();
				}
			} // while

		} catch (Exception e) {
			e.printStackTrace();
		}
		return coches;
	}

	public Coche getById(long id) {

		Coche c = null;
		try (Connection conn = ConnectionManager.getConnection();
				PreparedStatement cs = conn.prepareStatement(SQL_GETBYID);) {

			cs.setLong(1, id);

			try (ResultSet rs = cs.executeQuery()) {

				while (rs.next()) {
					c = rowMapper(rs);
				}
			}

		} catch (Exception e) {
			LOG.error("El agente que buscas no existe", e);
		}
		return c;
	}
	
	public boolean delete(long id) throws SQLException {

		boolean resul = false;
		try (Connection conn = ConnectionManager.getConnection();
				CallableStatement cs = conn.prepareCall(SQL_DELETEBYID);) {

			cs.setLong(1,id);
			int affectedRows = cs.executeUpdate();
			if (affectedRows == 1) {
				resul = true;
			}
		}
		return resul;
	}

	public Coche insert(Coche c) throws SQLException {

		try (Connection conn = ConnectionManager.getConnection();
				CallableStatement cs = conn.prepareCall(SQL_INSERT);) {
			cs.setString(1, c.getMatricula());
			cs.setString(2, c.getModelo());
			cs.setInt(3, c.getKm());
			cs.registerOutParameter(4, Types.INTEGER);
			int affectedRows = cs.executeUpdate();
			if (affectedRows == 1) {
				c.setId(cs.getLong(4));
			}else {
				c=null;
			}
		}
		return c;
	}
}