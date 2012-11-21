package apiario.edu.pe.bean;

import java.io.Serializable;
import javax.persistence.*;

import apiario.edu.pe.bean.base.BaseEntidades;

import java.util.List;


/**
 * The persistent class for the piso database table.
 * 
 */
@Entity
@Table(name="piso")
public class Piso extends BaseEntidades implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	private int idpiso;

	//bi-directional many-to-one association to Alza
	@OneToMany(mappedBy="piso")
	private List<Alza> alzas;

	//bi-directional many-to-one association to Colmena
    @ManyToOne
	@JoinColumn(name="idcolmena")
	private Colmena colmena;

    public Piso() {
    }

	public int getIdpiso() {
		return this.idpiso;
	}

	public void setIdpiso(int idpiso) {
		this.idpiso = idpiso;
	}

	public List<Alza> getAlzas() {
		return this.alzas;
	}

	public void setAlzas(List<Alza> alzas) {
		this.alzas = alzas;
	}
	
	public Colmena getColmena() {
		return this.colmena;
	}

	public void setColmena(Colmena colmena) {
		this.colmena = colmena;
	}
	
}