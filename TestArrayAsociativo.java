package prArrayAsociativo;

import static org.junit.Assert.*;

import java.util.NoSuchElementException;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class TestArrayAsociativo {
	
	static String[] claves = {"nombre","apellido","dni","pais"};
	static String [] valores ={"luis","martin","12345567P","España"};
	private ArrayAsociativo array;
	
	@Before
	public void inicializar() {
		array = new ArrayAsociativo();
	}
	
	@After
	public void finalizar() {
		array = null;
	}
	
	@Test
	public void tamañoArrayVacio() {
		assertEquals(new Integer(0), new Integer(array.size()));
	}
	
	@Test
	public void tamañoArrayNoVacio() {
		array = new ArrayAsociativo (claves,valores);
		assertEquals(new Integer(4), new Integer(array.size()));
	}
	
	@Test(expected = NoSuchElementException.class)
	public void buscarValorArrayVacio() {
		array.get("ciudad");
	}
	
	@Test
	public void buscarValorArrayEsta() {
		array = new ArrayAsociativo (claves,valores);
		assertEquals("martin", array.get("apellido"));
	}
	
	@Test (expected = NoSuchElementException.class)
	public void buscarValorArrayNoEsta() {
		array = new ArrayAsociativo (claves,valores);
		array.get("ciudad");
	}
	
	@Test
	public void insertarArrayVacio() {
		array.put("ciudad", "Málaga");
		assertEquals(new Integer(1), new Integer(array.size()));
	}
	
	@Test
	public void insertarArrayNoVacio() {
		array = new ArrayAsociativo (claves,valores);
		array.put("ciudad", "Málaga");
		assertEquals(array.get("ciudad"),"Málaga");
	}
	
	@Test
	public void insertarArrayNoVacioYaEsta() {
		array = new ArrayAsociativo (claves,valores);
		array.put("apellido", "lópez");
		assertEquals(array.get("apellido"),"lópez");
	}
}

