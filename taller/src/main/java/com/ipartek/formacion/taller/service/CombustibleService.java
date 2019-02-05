package com.ipartek.formacion.taller.service;

import java.sql.SQLException;
import java.util.ArrayList;

import com.ipartek.formacion.taller.modelo.pojo.Combustible;
import com.ipartek.formacion.taller.service.exception.CombustibleException;

public interface CombustibleService {
	
	
	/**
	 * listado combustible ordenado por id descendente
	 * @return ArrayList<Combustible>, vacio si no hay datos
	 */
	ArrayList<Combustible> listar();
	
	/**
	 * obtener detalle combustible
	 * @param idCombustible identificador de combustible
	 * @return Combustible si encuentra, sino <b>null</b>
	 */
	
	Combustible detalle(int idCombustible);
	/**
	 * elimina registro de conbustibles por identificador
	 * @param idCombustible identificador combustible
	 * @return true si elimina, false si no lo encuentra
	 * @throws CombustibleException  si tiene vehiculos asociados o no existe identificador
	 * @see CombustibleException
	 */
	boolean eliminar (int idCombustible) throws CombustibleException;
	/**
	 * crear registro de combustible
	 * @param combustible datos de combustible
	 * @return true si lo crea, false si no lo hace (no vacio, min 1 max 45)
	 * @throws CombustibleException si ya existe
	 */
	
	boolean crear (Combustible combustible) throws CombustibleException;
	/**
	 * modifica datos de combustible
	 * @param idCombustible identificador de combustible
	 * @return true si se hizo la modificacion, false si no se hizo (no vacio, min 1 max 45)
	 * @throws CombustibleException si no existe
	 */
	
	boolean modificar (int idCombustible) throws CombustibleException;
	

	
	
	

}
