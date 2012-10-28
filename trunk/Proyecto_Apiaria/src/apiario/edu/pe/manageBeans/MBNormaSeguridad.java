package apiario.edu.pe.manageBeans;

import java.util.ArrayList;
import java.util.List;

import apiario.edu.pe.bean.NormaSeguridad;
import apiario.edu.pe.service.SeleccionService;

public class MBNormaSeguridad {
	SeleccionService service=new SeleccionService();
    private NormaSeguridad normaSeguridad;
    private List<NormaSeguridad>  listaNormaSeguridad=new ArrayList<NormaSeguridad>();
    
    public List<NormaSeguridad> load(){
    	List<NormaSeguridad> lista=null;
    	lista=service.listaNormaSeguridad(); 
    	return lista;
    }
    
    
}
