package apiario.edu.pe.managedBeans;

import java.io.Serializable;
import java.util.List;

import javax.faces.model.DataModel;
import javax.faces.model.ListDataModel;

import apiario.edu.pe.bean.EquipamientoTrabajo;
import apiario.edu.pe.bean.EstadoRevision;
import apiario.edu.pe.bean.EstadoRevisionEquipamientoTrabajo;
import apiario.edu.pe.service.*;

public class MBDetalleEquipamientoTrabajo implements Serializable{

	private static final long serialVersionUID = 1L;
	private Integer idEstadoRevisionEquipamientoTrabajo;
	private EquipamientoTrabajo equipamientoTrabajo;
	private EstadoRevision estadoRevision;
	private Integer idEstadoRevision;
	private Integer cantidad;
	private DataModel<EstadoRevisionEquipamientoTrabajo> listaestadorevisionequiptrabajomodel;
	private List<EstadoRevisionEquipamientoTrabajo> listarEquipoTrabajo;
	
	public Integer getIdEstadoRevisionEquipamientoTrabajo() {
		return idEstadoRevisionEquipamientoTrabajo;
	}
	public void setIdEstadoRevisionEquipamientoTrabajo(
			Integer idEstadoRevisionEquipamientoTrabajo) {
		this.idEstadoRevisionEquipamientoTrabajo = idEstadoRevisionEquipamientoTrabajo;
	}
	public EquipamientoTrabajo getEquipamientoTrabajo() {
		return equipamientoTrabajo;
	}
	public void setEquipamientoTrabajo(EquipamientoTrabajo equipamientoTrabajo) {
		this.equipamientoTrabajo = equipamientoTrabajo;
	}
	public EstadoRevision getEstadoRevision() {
		return estadoRevision;
	}
	public void setEstadoRevision(EstadoRevision estadoRevision) {
		this.estadoRevision = estadoRevision;
	}
	public Integer getCantidad() {
		return cantidad;
	}
	public void setCantidad(Integer cantidad) {
		this.cantidad = cantidad;
	}
	public void setIdEstadoRevision(Integer idEstadoRevision) {
		this.idEstadoRevision = idEstadoRevision;
	}
	public Integer getIdEstadoRevision() {
		return idEstadoRevision;
	}
	public void setListarEquipoTrabajo(List<EstadoRevisionEquipamientoTrabajo> listarEquipoTrabajo) {
		this.listarEquipoTrabajo = listarEquipoTrabajo;
	}
	public List<EstadoRevisionEquipamientoTrabajo> getListarEquipoTrabajo() {
		return listarEquipoTrabajo;
	}
	public void setListaestadorevisionequiptrabajomodel(
			DataModel<EstadoRevisionEquipamientoTrabajo> listaestadorevisionequiptrabajomodel) {
		this.listaestadorevisionequiptrabajomodel = listaestadorevisionequiptrabajomodel;
	}
	public DataModel<EstadoRevisionEquipamientoTrabajo> getListaestadorevisionequiptrabajomodel() {

		SeleccionService service = new SeleccionService();
		
		listaestadorevisionequiptrabajomodel = new ListDataModel<EstadoRevisionEquipamientoTrabajo>(service.listarDetalleEquipoTrabajo(idEstadoRevisionEquipamientoTrabajo));
		return listaestadorevisionequiptrabajomodel;
	}
	
	public void listarEquiposTrabajo(){
		
		SeleccionService service = new SeleccionService();
		
		listarEquipoTrabajo = service.listarDetalleEquipoTrabajo(idEstadoRevisionEquipamientoTrabajo);
		
	}
	
}
