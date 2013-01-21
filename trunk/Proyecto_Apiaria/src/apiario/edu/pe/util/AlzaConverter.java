package apiario.edu.pe.util;

import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;

import apiario.edu.pe.bean.Alza;
import apiario.edu.pe.bean.NormaSeguridad;
import apiario.edu.pe.bean.PlanillaCosechaAlza;
import apiario.edu.pe.service.SeleccionService;


public class AlzaConverter implements Converter{

	SeleccionService service= new SeleccionService();
	
	@Override
	public Object getAsObject(FacesContext arg0, UIComponent arg1, String id) {
		// TODO Auto-generated method stub
		Alza obj= new Alza();
		try {
			obj=service.obtenerPorIdAlza(Integer.parseInt(id));
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return obj;
	}

	@Override
	public String getAsString(FacesContext arg0, UIComponent arg1, Object obj) {
		// TODO Auto-generated method stub
		return ((Alza) obj).getIdAlza() + "";
	}

}
