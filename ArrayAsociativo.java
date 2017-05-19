package prArrayAsociativo;

import java.util.NoSuchElementException;

public class ArrayAsociativo {
	//Clases internas
	private class Nodo{
		private String clave;
		private String valor;
		private Nodo sig; //siguiente nodo
		
		public Nodo(String c, String v, Nodo s){
			clave = c;
			valor = v;
			sig = s;
		}
	}
	
	//Variables de instancia
	private Nodo primero;
	
	
	//Constructores
	public ArrayAsociativo(){
		primero = null;
	}
	
	public ArrayAsociativo(String[] claves, String[] valores){
		this();
		if (claves.length > 0){
			primero = new Nodo(claves[0], valores[0],null);
			for (int i = 1; i< claves.length; i++){
				Nodo nuevo = new Nodo(claves[i], valores[i],primero);
				primero = nuevo;
			}
		}
	}
	
	//Métodos de instancia
	public int size(){
		int cont = 0;
		Nodo aux = primero;
		while(aux!=null){
			cont++;
			aux=aux.sig;	
		}
		return cont;
	}
	
	public String get(String clave){
		Nodo aux = primero;
		String val = null;
		boolean encontrado = false;
		
		while(aux!=null && !encontrado){
			if(aux.clave.equals(clave)){
				encontrado = true;
				val = aux.valor;
			}else{
				aux = aux.sig;
			}	
		}
		if(val == null){
			throw new NoSuchElementException("No existe la clave");
		}
		return val;
	}
	
	public void put(String clave, String valor){
		boolean encontrado = false;
		Nodo aux = primero;
		
		while(aux!=null && !encontrado){
			if(aux.clave == clave){
				encontrado = true;
				aux.valor = valor;
			}else{
				aux = aux.sig;
			}	
		}
		
		if(encontrado == false){
			Nodo nuevo = new Nodo(clave,valor,primero);
			primero = nuevo;
		}
		
		
	}
}
