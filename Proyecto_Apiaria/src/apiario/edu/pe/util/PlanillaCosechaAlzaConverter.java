package apiario.edu.pe.util;

import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;

import apiario.edu.pe.bean.NormaSeguridad;
import apiario.edu.pe.bean.PlanillaCosechaAlza;
import apiario.edu.pe.service.SeleccionService;


public class PlanillaCosechaAlzaConverter implements Converter{

	SeleccionService service= new SeleccionService();
	
	@Override
	public Object getAsObject(FacesContext arg0, UIComponent arg1, String id) {
		// TODO Auto-generated method stub
		PlanillaCosechaAlza obj= new PlanillaCosechaAlza();
		try {
			obj=service.obtenerPorIdPlanillaCosechaAlza(Integer.parseInt(id));
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return obj;
	}

	@Override
	public String getAsString(FacesContext arg0, UIComponent arg1, Object obj) {
		// TODO Auto-generated method stub
		return ((PlanillaCosechaAlza) obj).getIdPlanillaCosechaAlza() + "";
	}

}
