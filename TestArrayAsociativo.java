package prArrayAsociativo;

import static org.junit.Assert.*;

import org.junit.Test;

public class TestArrayAsociativo {
	
	static String[] claves = {"nombre","apellido","dni","pais"};
	static String [] valores ={"luis","martin","12345567P","España"};
	private static final ArrayAsociativo arrayVacio = new ArrayAsociativo();
	private static final ArrayAsociativo arrayNoVacio = new ArrayAsociativo (claves,valores);
	
	@Test
	public void tamañoArrayVacio() {
		assertEquals(new Integer(0), new Integer(arrayVacio.size()));
	}
	
	@Test
	public void tamañoArrayNoVacio() {
		assertEquals(new Integer(4), new Integer(arrayNoVacio.size()));
	}

}

