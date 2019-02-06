package com.ipartek.formacion.taller.modelo.dao;

import java.sql.SQLException;
import java.util.ArrayList;

public interface IDAO<P> {

	ArrayList<P> getAll();

	P getById(int id);

	boolean delete(int id) throws SQLException;

	boolean insert(P pojo) throws SQLException;

	boolean modificar(P pojo) throws SQLException;


}
