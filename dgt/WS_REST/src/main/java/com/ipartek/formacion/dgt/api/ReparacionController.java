package com.ipartek.formacion.dgt.api;
import java.util.ArrayList;

import org.apache.log4j.Logger;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.ipartek.formacion.modelo.daos.ReparacionDAO;
import com.ipartek.formacion.modelo.pojo.Reparacion;

import io.swagger.annotations.Api;

@CrossOrigin
@RestController
/*
 * @RequestMapping ("/api/reparacion") /* para no repetir esta URI en los demas
 * request
 */
@Api(tags = { "REPARACIONES" }, produces = "application/json", description="Gestión de Reparaciones")

public class ReparacionController {
	private static ReparacionDAO reparacionDAO;
	private final static Logger LOG = Logger.getLogger(ReparacionController.class);

	public ReparacionController() {
		super();
		reparacionDAO = ReparacionDAO.getInstance();
	}

	@RequestMapping(value = { "/api/reparacion" }, method = RequestMethod.GET)
	public ArrayList<Reparacion> listar() {
		
		return reparacionDAO.getAll();

		
	}

//	@RequestMapping(value = { "/api/reparacion{id}" }, method = RequestMethod.GET)
//	public ResponseEntity<Coche> detalle(@PathVariable String id) {
//		ResponseEntity<Coche> response = new ResponseEntity<Coche>(HttpStatus.NOT_FOUND);
//		try {
//			int idint = Integer.parseInt(id);
//			Coche c = cocheDAO.getById(idint);
//			if (c != null) {
//				response = new ResponseEntity<Coche>(c, HttpStatus.OK);
//			}
//		} catch (Exception e) {
//			response = new ResponseEntity<Coche>(HttpStatus.NOT_FOUND);
//		}
//		return response;
//	}
//
//	@RequestMapping(value = { "/api/reparacion{id}" }, method = RequestMethod.DELETE)
//	public ResponseEntity<Coche> eliminar(@PathVariable String id) throws SQLException {
//		ResponseEntity<Coche> response = new ResponseEntity<Coche>(HttpStatus.NOT_FOUND);
//		try {
//			int idint = Integer.parseInt(id);
//			if (idint > 0) {
//				try {
//					if (cocheDAO.delete(idint)) {
//						response = new ResponseEntity<Coche>(HttpStatus.OK);
//					} else {
//						response = new ResponseEntity<Coche>(HttpStatus.NOT_FOUND);
//					}
//				} catch (Exception e) {
//					response = new ResponseEntity<Coche>(HttpStatus.CONFLICT);
//				}
//			}
//		} catch (Exception e) {
//			response = new ResponseEntity<Coche>(HttpStatus.NOT_FOUND);
//		}
//		return response;
//	}
//
//	@RequestMapping(value = { "/api/reparacion{id}" }, method = RequestMethod.PATCH)
//	public ResponseEntity<Coche> darDeBaja(@PathVariable String id, @RequestBody Coche coche) throws SQLException {
//		ResponseEntity<Coche> response = new ResponseEntity<Coche>(HttpStatus.NOT_FOUND);
//		try {
//			int idint = Integer.parseInt(id);
//			Coche c = cocheDAO.getById(idint);
//			if (c != null) {
//				c.setFechabaja(coche.getFechabaja());
//				if (cocheDAO.update(c,"PATCH")) {
//					response = new ResponseEntity<Coche>(c, HttpStatus.OK);
//				}
//			}
//		} catch (SQLException e) {
//			LOG.debug("no se ha podido actualizar los datos");
//			response = new ResponseEntity<Coche>(HttpStatus.CONFLICT);
//		} catch (Exception e) {
//			LOG.error(e);
//			response = new ResponseEntity<Coche>(HttpStatus.BAD_REQUEST);
//		}
//		return response;
//	}
//
//	@RequestMapping(value = { "/api/reparacion{id}" }, method = RequestMethod.PUT)
//	public ResponseEntity<Coche> modificar(@RequestBody Coche coche, @PathVariable String id) throws SQLException {
//		ResponseEntity<Coche> response = new ResponseEntity<Coche>(HttpStatus.NOT_FOUND);
//		try {
//			if (cocheDAO.update(coche,"PUT")) {
//				response = new ResponseEntity<Coche>(coche, HttpStatus.OK);
//			}
//		} catch (SQLException e) {
//			LOG.debug("No se ha podido actualizar los datos");
//			response = new ResponseEntity<Coche>(HttpStatus.BAD_REQUEST);
//		} catch (Exception e) {
//			LOG.error(e);
//			response = new ResponseEntity<Coche>(HttpStatus.INTERNAL_SERVER_ERROR);
//		}
//		return response;
//	}
//
//	@RequestMapping(value = { "/api/reparacion" }, method = RequestMethod.POST)
//	public  ResponseEntity<Coche> crear(@RequestBody Coche coche) throws SQLException {
//		ResponseEntity<Coche> response = new ResponseEntity<Coche>(HttpStatus.NOT_FOUND);
//		Coche c = cocheDAO.insert(coche);
//		if (c != null) {
//			response = new ResponseEntity<Coche>(c, HttpStatus.CREATED);
//		}
//		return response;
//	}

}
