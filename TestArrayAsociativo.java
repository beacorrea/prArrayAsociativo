package prArrayAsociativo;

import static org.junit.Assert.*;

import java.util.NoSuchElementException;

import org.junit.Test;

public class TestArrayAsociativo {
	
	static String[] claves = {"nombre","apellido","dni","pais"};
	static String [] valores ={"luis","martin","12345567P","Espa�a"};
	private static final ArrayAsociativo arrayVacio = new ArrayAsociativo();
	private static final ArrayAsociativo arrayNoVacio = new ArrayAsociativo (claves,valores);
	
	@Test
	public void tama�oArrayVacio() {
		assertEquals(new Integer(0), new Integer(arrayVacio.size()));
	}
	
	@Test
	public void tama�oArrayNoVacio() {
		assertEquals(new Integer(4), new Integer(arrayNoVacio.size()));
	}
	
	@Test (expected = NoSuchElementException.class)
	public void buscarValorArrayVacio() {
		arrayVacio.get("ciudad");
	}
	
	@Test
	public void buscarValorArrayEsta() {
		assertEquals("martin", arrayNoVacio.get("apellido"));
	}
	
	@Test (expected = NoSuchElementException.class)
	public void buscarValorArrayNoEsta() {
		arrayNoVacio.get("ciudad");
	}
	

}

