package com.ipartek.formacion.taller.modelo.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import org.springframework.stereotype.Repository;

import com.ipartek.formacion.taller.modelo.config.ConnectionManager;
import com.ipartek.formacion.taller.modelo.pojo.Vehiculo;
import com.mysql.jdbc.Connection;

@Repository
public class VehiculoDAO {
	private static final String SQL_GET_ALL_BY_PERSONA_ID = "SELECT id,numero_bastidor as 'bastidor',matricula FROM vehiculo where id_propietario=? ORDER BY id DESC LIMIT 1000;";

	public ArrayList<Vehiculo> getAllByPersonaId(int idPersona) {

		ArrayList<Vehiculo> hmPersonas = new ArrayList<Vehiculo>();
		try (Connection con = (Connection) ConnectionManager.getConnection();
				PreparedStatement pst = con.prepareStatement(SQL_GET_ALL_BY_PERSONA_ID);) {
			pst.setLong(1, idPersona);
			try {
				ResultSet rs = pst.executeQuery();
				while (rs.next()) {
					Vehiculo vehiculo = new Vehiculo();
					vehiculo.setId(rs.getInt("id"));
					vehiculo.setMatricula(rs.getString("matricula"));
					vehiculo.setNumeroBastidor(rs.getString("bastidor"));
				}

			} catch (Exception e) {
				// TODO: handle exception
			}

		} catch (Exception e) {
			// TODO: handle exception
		}
		return hmPersonas;
	}

}
