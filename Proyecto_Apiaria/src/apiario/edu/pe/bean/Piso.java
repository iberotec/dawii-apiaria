package apiario.edu.pe.bean;

import java.io.Serializable;
import javax.persistence.*;

import apiario.edu.pe.bean.base.BaseEntidades;

import java.util.Set;


/**
 * The persistent class for the piso database table.
 * 
 */
@Entity
@Table(name="piso")
public class Piso extends BaseEntidades implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="id_piso")
	private Integer idPiso;

	private Integer capacidad;
	
	//bi-directional many-to-one association to Alza
	@OneToMany(mappedBy="piso")
	private Set<Alza> alzas;

	//bi-directional many-to-one association to Colmena
    @ManyToOne
	@JoinColumn(name="id_colmena")
	private Colmena colmena;

    public Piso() {
    }

	public Integer getIdPiso() {
		return this.idPiso;
	}

	public void setIdPiso(Integer idPiso) {
		this.idPiso = idPiso;
	}

	public Set<Alza> getAlzas() {
		return this.alzas;
	}

	public void setAlzas(Set<Alza> alzas) {
		this.alzas = alzas;
	}
	
	public Colmena getColmena() {
		return this.colmena;
	}

	public void setColmena(Colmena colmena) {
		this.colmena = colmena;
	}

	public Integer getCapacidad() {
		return capacidad;
	}

	public void setCapacidad(Integer capacidad) {
		this.capacidad = capacidad;
	}
	
}