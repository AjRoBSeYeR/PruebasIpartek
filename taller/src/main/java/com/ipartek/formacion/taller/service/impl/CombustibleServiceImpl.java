package com.ipartek.formacion.taller.service.impl;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Set;

import javax.validation.ConstraintViolation;
import javax.validation.Validator;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ipartek.formacion.taller.modelo.dao.CombustibleDAO;
import com.ipartek.formacion.taller.modelo.pojo.Combustible;
import com.ipartek.formacion.taller.service.CombustibleService;
import com.ipartek.formacion.taller.service.exception.CombustibleException;

@Service
public class CombustibleServiceImpl implements CombustibleService {
	@Autowired
	private CombustibleDAO combustibleDAO;

	@Autowired
	private Validator validator;

	@Override
	public ArrayList<Combustible> listar() {

		ArrayList<Combustible> combustibles = combustibleDAO.getAll();

		return combustibles;

	}

	@Override
	public Combustible detalle(int idCombustible) {
		Combustible combustible = combustibleDAO.getById(idCombustible);
		return combustible;
	}

	@Override
	public boolean eliminar(int idCombustible) throws CombustibleException {
		boolean eliminado = false;
		try {
			eliminado = combustibleDAO.delete(idCombustible);
		} catch (Exception e) {
			throw new CombustibleException(CombustibleException.EXCEPTION_COSTRAINT);
		}
		return eliminado;

	}

	@Override
	public boolean crear(Combustible combustible) throws CombustibleException {
		boolean creado = false;
		try {

			creado = combustibleDAO.insert(combustible);

		} catch (SQLException e) {
			throw new CombustibleException(CombustibleException.EXCEPTION_EXISTS);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return creado;
	}

	@Override
	public boolean modificar(Combustible combustible) throws CombustibleException {
		boolean modificado = false;
		try {
			Set<ConstraintViolation<Combustible>> violations = validator.validate(combustible);
			if(violations.size()!=0) {
				throw new CombustibleException("Tus datos son mierda pura");
			}
			modificado = combustibleDAO.modificar(combustible);

		} catch (SQLException e) {
			throw new CombustibleException(CombustibleException.EXCEPTION_EXISTS);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return modificado;
	}

}
