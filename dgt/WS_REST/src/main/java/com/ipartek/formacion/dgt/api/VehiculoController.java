package com.ipartek.formacion.dgt.api;

import java.sql.SQLException;
import java.util.ArrayList;

import org.apache.log4j.Logger;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
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

	@RequestMapping(value = { "/api/vehiculo/{id}" }, method = RequestMethod.GET)
	public ResponseEntity<Coche> detalle(@PathVariable long id) {
		ResponseEntity<Coche> response = new ResponseEntity<Coche>(HttpStatus.NOT_FOUND);
		if (id > 0) {
			Coche c = cocheDAO.getById(id);
			if (c != null) {
				response = new ResponseEntity<Coche>(c, HttpStatus.OK);
			}
		}
		return response;
	}

	@RequestMapping(value = { "/api/vehiculo/{id}" }, method = RequestMethod.DELETE)
	public ResponseEntity<Coche> eliminar(@PathVariable long id) throws SQLException {
		ResponseEntity<Coche> response = new ResponseEntity<Coche>(HttpStatus.NOT_FOUND);
		if (id > 0) {
			if (cocheDAO.delete(id)) {
				response = new ResponseEntity<Coche>(HttpStatus.OK);
			} else {
				response = new ResponseEntity<Coche>(HttpStatus.NOT_FOUND);
			}
		}
		return response;
	}

	@RequestMapping(value = { "/api/vehiculo/{id}" }, method = RequestMethod.PATCH)
	public ResponseEntity<Coche> darDeBaja(@PathVariable long id, @RequestBody Coche coche) throws SQLException {
		ResponseEntity<Coche> response = new ResponseEntity<Coche>(HttpStatus.NOT_FOUND);
		if (id > 0) {
			Coche c = cocheDAO.getById(id);
			if (c != null) {
				c.setModelo(coche.getModelo());
				c.setKm(coche.getKm());
				if (cocheDAO.update(c)) {
					response = new ResponseEntity<Coche>(c,HttpStatus.OK);
				}
			}
		}
		return response;
	}

	@RequestMapping(value = { "/api/vehiculo/{id}" }, method = RequestMethod.PUT)
	public ResponseEntity<Coche> modificar(@RequestBody Coche coche, @PathVariable long id) throws SQLException {
		ResponseEntity<Coche> response = new ResponseEntity<Coche>(HttpStatus.NOT_FOUND);
		if (id > 0) {
			if (cocheDAO.update(coche)) {
				response = new ResponseEntity<Coche>(coche,HttpStatus.OK);
			}
		}
		return response;
	}

	@RequestMapping(value = { "/api/vehiculo" }, method = RequestMethod.POST)
	public void crear(@RequestBody Coche coche) throws SQLException {
		ResponseEntity<Coche> response = new ResponseEntity<Coche>(HttpStatus.I_AM_A_TEAPOT);
		Coche c =cocheDAO.insert(coche);
		if (c!=null) {
			response = new ResponseEntity<Coche>(c,HttpStatus.OK);
		}
	}
}
