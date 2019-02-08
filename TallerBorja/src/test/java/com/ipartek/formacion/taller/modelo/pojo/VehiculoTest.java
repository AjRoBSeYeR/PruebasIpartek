package com.ipartek.formacion.taller.modelo.pojo;

import static org.junit.Assert.assertEquals;

import java.util.Set;

import javax.validation.ConstraintViolation;
import javax.validation.Validation;
import javax.validation.Validator;
import javax.validation.ValidatorFactory;

import org.junit.Test;

import com.ipartek.formacion.taller.modelo.pojo.validactions.VehiculoCompleteCheck;
import com.ipartek.formacion.taller.modelo.pojo.validactions.VehiculosPostCheck;

public class VehiculoTest {

	@Test
	public void test() {
		
		ValidatorFactory factory = Validation.buildDefaultValidatorFactory();
		Validator validator = factory.getValidator();
		
		Vehiculo vCompleteCheck = new Vehiculo();
		Vehiculo vPostCheck = new Vehiculo();
				
		Set<ConstraintViolation<Vehiculo>> vComplete = validator.validate(vCompleteCheck, VehiculoCompleteCheck.class );
		Set<ConstraintViolation<Vehiculo>> vPost = validator.validate(vPostCheck, VehiculosPostCheck.class );
		
		assertEquals("Deberia haber 16 violaciones", 16 , vComplete.size() );
		assertEquals("Deberia haber 4 violaciones", 4 , vPost.size() );
		
		vPostCheck.setMatricula("12");
		vPost = validator.validate(vPostCheck, VehiculosPostCheck.class );
		assertEquals("quitamos viloacion NotEmpty", 3 , vPost.size() );
		
		
		vPostCheck.setMatricula("12345678");
		vPost = validator.validate(vPostCheck, VehiculosPostCheck.class );
		assertEquals("quitamos violacion NotEmpty", 2 , vPost.size() );
		
		
		
	}

}
