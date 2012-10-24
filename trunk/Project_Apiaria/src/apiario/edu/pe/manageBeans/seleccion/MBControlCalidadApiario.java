package apiario.edu.pe.manageBeans.seleccion;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.event.ActionEvent;

@ManagedBean(name = "jMBControlCalidadApiario")
@SessionScoped
public class MBControlCalidadApiario implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	List<String> oList1=new ArrayList<String>();
	
	public MBControlCalidadApiario() {
	
	}
	public void load(){
		
		
		oList1.add("Tarma");
		oList1.add("Tambo");
		oList1.add("La merced");
	}
	
	public void init(ActionEvent event)throws Exception{
		load();
		
		
	}
	public List<String> getoList2() {
		return oList1;
	}

	public void setoList2(List<String> oList2) {
		this.oList1 = oList2;
	}
	public List<String> getoList1() {
		return oList1;
	}
	public void setoList1(List<String> oList1) {
		this.oList1 = oList1;
	}

}
