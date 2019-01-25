package com.ipartek.formacion.dgt.api;

import java.util.ArrayList;

import org.apache.log4j.Logger;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.ipartek.formacion.modelo.daos.CocheDAO;
import com.ipartek.formacion.modelo.pojo.Coche;

@RestController
public class VehiculoController {
	private static CocheDAO cocheDAO;
	private final static Logger LOG = Logger.getLogger(VehiculoController.class);

	public VehiculoController() {
		super();
		cocheDAO = CocheDAO.getInstance();
	}

	@RequestMapping(value = { "/api/vehiculo" }, method = RequestMethod.GET)
	public ArrayList<Coche> listar() {

		return cocheDAO.getAll();
	}
	
	@RequestMapping(value = { "/api/vehiculo" }, method = RequestMethod.POST)
	public void insertar() {
		Coche c= new Coche();
		c.setMatricula("FFF5555");
		c.setModelo("coche palo");
		c.setKm(90);
		cocheDAO.insert(c);
	}
}
