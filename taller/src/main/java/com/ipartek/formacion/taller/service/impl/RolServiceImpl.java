package com.ipartek.formacion.taller.service.impl;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Set;

import javax.validation.ConstraintViolation;
import javax.validation.Validator;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ipartek.formacion.taller.modelo.dao.RolDAO;
import com.ipartek.formacion.taller.modelo.pojo.Rol;
import com.ipartek.formacion.taller.service.RolService;
import com.ipartek.formacion.taller.service.exception.RolException;

@Service
public class RolServiceImpl implements RolService {
	@Autowired
	private RolDAO rolDAO;

	@Autowired
	private Validator validator;

	@Override
	public ArrayList<Rol> listar() {

		ArrayList<Rol> roles = rolDAO.getAll();

		return roles;

	}

	@Override
	public Rol detalle(int idrol) {
		Rol rol = rolDAO.getById(idrol);
		return rol;
	}

	@Override
	public boolean eliminar(int idrol) throws RolException {
		boolean eliminado = false;
		try {
			eliminado = rolDAO.delete(idrol);
		} catch (Exception e) {
			throw new RolException(RolException.EXCEPTION_COSTRAINT);
		}
		return eliminado;

	}

	@Override
	public boolean crear(Rol rol) throws RolException {
		boolean creado = false;
		try {

			creado = rolDAO.insert(rol);

		} catch (SQLException e) {
			throw new RolException(RolException.EXCEPTION_EXISTS);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return creado;
	}

	@Override
	public boolean modificar(Rol rol) throws RolException {
		boolean modificado = false;
		try {
			Set<ConstraintViolation<Rol>> violations = validator.validate(rol);
			if(violations.size()!=0) {
				throw new RolException("Tus datos son mierda pura");
			}
			modificado = rolDAO.modificar(rol);

		} catch (SQLException e) {
			throw new RolException(RolException.EXCEPTION_EXISTS);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return modificado;
	}

}
