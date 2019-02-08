package com.ipartek.formacion.taller.service.impl;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import javax.validation.ConstraintViolation;
import javax.validation.Validator;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ipartek.formacion.taller.modelo.dao.CombustibleDAO;
import com.ipartek.formacion.taller.modelo.dao.ModeloDAO;
import com.ipartek.formacion.taller.modelo.dao.PersonaDAO;
import com.ipartek.formacion.taller.modelo.dao.VehiculoDAO;
import com.ipartek.formacion.taller.modelo.pojo.Vehiculo;
import com.ipartek.formacion.taller.modelo.pojo.validactions.VehiculosPostCheck;
import com.ipartek.formacion.taller.service.VehiculoService;
import com.ipartek.formacion.taller.service.exception.VehiculoException;
import com.mysql.jdbc.exceptions.jdbc4.MySQLIntegrityConstraintViolationException;

@Service
public class VehiculoServiceImpl implements VehiculoService {

	@Autowired
	VehiculoDAO vehiculoDAO;
	@Autowired
	CombustibleDAO combustibleDAO;
	@Autowired
	ModeloDAO modeloDAO;
	@Autowired
	PersonaDAO personaDAO;

	@Autowired
	Validator validator;

	@Override
	public List<Vehiculo> listar() {
		ArrayList<Vehiculo> vehiculos = new ArrayList<Vehiculo>();
		vehiculos = (ArrayList<Vehiculo>) vehiculoDAO.getAll();

//		for ( Vehiculo v : vehiculos ) {
//			
//			v.setCombustible( (combustibleDAO).getByVehiculoId( v.getId() ) );
//			v.setModelo( (modeloDAO).getByVehiculoId( v.getId() ) );
//			
//		}

		return vehiculos;
	}

	@Override
	public Vehiculo detalle(int idVehiculo) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean eliminar(int idVehiculo) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean crear(Vehiculo vehiculo) throws VehiculoException {

		boolean creado = false;
		try {
			Set<ConstraintViolation<Vehiculo>> violations = validator.validate(vehiculo, VehiculosPostCheck.class);
			if (violations.isEmpty()) {
				creado = vehiculoDAO.insert(vehiculo);
				if (creado) {
					vehiculo.setModelo(modeloDAO.getById(vehiculo.getModelo().getId()));
					vehiculo.setCombustible(combustibleDAO.getById(vehiculo.getCombustible().getId()));
					vehiculo.setPropietario(personaDAO.getById(vehiculo.getPropietario().getId()));
				}
			} else {
				throw new VehiculoException(VehiculoException.EXCEPTION_VIOLATIONS);
			}
		} catch (SQLException e) {
			if (e.getErrorCode() == 1452) {
				throw new VehiculoException(VehiculoException.EXCEPTION_FK_CONSTRAINT);
			} else {
				throw new VehiculoException(VehiculoException.EXCEPTION_CONSTRAINT);
			}
		} catch (Exception e) {
			throw new VehiculoException(VehiculoException.EXCEPTION_GENERIC);
		}
		return creado;
	}

	@Override
	public boolean modificar(Vehiculo vehiculo) {
		// TODO Auto-generated method stub
		return false;
	}

}
