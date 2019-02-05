package com.ipartek.formacion.taller.service.impl;

import java.sql.SQLException;
import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ipartek.formacion.taller.modelo.dao.CombustibleDAO;
import com.ipartek.formacion.taller.modelo.pojo.Combustible;
import com.ipartek.formacion.taller.service.CombustibleService;
import com.ipartek.formacion.taller.service.exception.CombustibleException;

@Service
public class CombustibleServiceImpl implements CombustibleService {
	@Autowired
	CombustibleDAO combustibleDAO;

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
		boolean eliminado=false;
		try {
			eliminado = combustibleDAO.delete(idCombustible);
		} catch (Exception e) {
			throw new CombustibleException(CombustibleException.EXCEPTION_COSTRAINT);
		}
		return eliminado;

		
	}

	@Override
	public boolean crear(Combustible combustible) throws CombustibleException {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean modificar(int idCombustible) throws CombustibleException {
		// TODO Auto-generated method stub
		return false;
	}

}
