package apiario.edu.pe.managedBeans;



import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;


import apiario.edu.pe.bean.Apiario;
import apiario.edu.pe.bean.PlanillaSeguimiento;
import apiario.edu.pe.bean.Temporada;
import apiario.edu.pe.bean.UsuarioApiario;
import apiario.edu.pe.service.SeleccionService;

@SuppressWarnings("serial")
public class MBApiario implements Serializable{

	public MBApiario() {
		// TODO Auto-generated constructor stub
	}
	
	public String abrirUbicacionApiario(){
		System.out.println("entrando a ubicacion apiario");

		return "successUbicacion";
	}
	
	public String abrirMainCosecha(){
		System.out.println("Entrando a cosecha");

		return "successMainCosecha";
	}
	
	public String abrirNuevaAsignacionCosecha(){
		System.out.println("Entro a nueva asignacion cosecha");

		return "successNuevaAsignacionCosecha";
	}
	


	
}
