package cibertec.edu.pe;

import java.io.Serializable;

public class JMensajes implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;


	public static final void pinta(String Titulo, Object mensaje){
		System.out.println("[MONKAR] > "+Titulo+" : "+mensaje);
	}
	
	public static final void pinta(Object mensaje){
		System.out.println("[MONKAR] > MSG : "+mensaje);
	}

}
