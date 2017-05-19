package prArrayAsociativo;

//Beatriz Correa Lopera
//2ºA Ingeniería del Software

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
	
	//Test 1
	@Test
	public void tamañoArrayVacio() {
		assertEquals(new Integer(0), new Integer(array.size()));
	}
	
	//Test 2
	@Test
	public void tamañoArrayNoVacio() {
		array = new ArrayAsociativo (claves,valores);
		assertEquals(new Integer(4), new Integer(array.size()));
	}
	
	//Test 3
	@Test(expected = NoSuchElementException.class)
	public void buscarValorArrayVacio() {
		array.get("ciudad");
	}
	
	//Test 4
	@Test
	public void buscarValorArrayEsta() {
		array = new ArrayAsociativo (claves,valores);
		assertEquals("martin", array.get("apellido"));
	}
	
	//Test 5
	@Test (expected = NoSuchElementException.class)
	public void buscarValorArrayNoEsta() {
		array = new ArrayAsociativo (claves,valores);
		array.get("ciudad");
	}
	
	//Test 6
	@Test
	public void insertarArrayVacio() {
		array.put("ciudad", "Málaga");
		assertEquals(new Integer(1), new Integer(array.size()));
	}
	
	//Test 7
	@Test
	public void insertarArrayNoVacio() {
		array = new ArrayAsociativo (claves,valores);
		array.put("ciudad", "Málaga");
		assertEquals(array.get("ciudad"),"Málaga");
	}
	
	//Test 8
	@Test
	public void insertarArrayNoVacioYaEsta() {
		array = new ArrayAsociativo (claves,valores);
		array.put("apellido", "lópez");
		assertEquals(array.get("apellido"),"lópez");
	}
	
	//Test 9
	@Test
	public void getOrElseArrayVacio() {
		assertEquals("Desconocido", array.getOrElse("nombre", "Desconocido"));
	}
	
	//Test 10
	@Test
	public void getOrElseClaveExiste() {
		array = new ArrayAsociativo (claves,valores);
		assertEquals(valores[2], array.getOrElse(claves[2], "Desconocido"));
	}
	
	//Test 11
	@Test
	public void getOrElseClaveNoExiste() {
		array = new ArrayAsociativo (claves,valores);
		assertEquals("Desconocido", array.getOrElse("ciudad", "Desconocido"));
	}
	
	//Test 12
	@Test
	public void ClaveExisteArrayVacio() {
		assertEquals(false, array.containsKey("nombre"));
	}
	
	//Test 13
	@Test
	public void ClaveExisteArrayNoContiene() {
		array = new ArrayAsociativo (claves,valores);
		assertEquals(false, array.containsKey("ciudad"));
	}
	
	//Test 14
	@Test
	public void ClaveExisteArrayContiene() {
		array = new ArrayAsociativo (claves,valores);
		assertEquals(true, array.containsKey("nombre"));
	}
	
	//Test 15
	@Test
	public void borrarArrayVacio(){
		assertEquals(false, array.remove("nombre"));
	}
	
	//Test 16
	@Test
	public void borrarContieneClave(){
		array = new ArrayAsociativo(claves,valores);
		assertEquals(true, array.remove("pais"));
	}
	
	//Test 17
	@Test
	public void borrarNoContieneClave(){
		array = new ArrayAsociativo(claves,valores);
		assertEquals(false, array.remove("ciudad"));
	}
	
}

