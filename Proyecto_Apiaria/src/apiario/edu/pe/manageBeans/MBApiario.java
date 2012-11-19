package apiario.edu.pe.manageBeans;



import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import apiario.edu.pe.bean.Apiario;

@SuppressWarnings("serial")
public class MBApiario implements Serializable{
	Apiario apiario;
	List<Apiario> lista = new ArrayList<Apiario>();
	
	public void ubicacionApiario(){
		System.out.println("entrega ubicacion");
	}
	
}
