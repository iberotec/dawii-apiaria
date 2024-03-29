package apiario.edu.pe.bean;

import java.io.Serializable;
import javax.persistence.*;
import java.util.Set;


/**
 * The persistent class for the piso database table.
 * 
 */
@Entity
@Table(name="piso")
public class Piso implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	private int idpiso;

	//bi-directional many-to-one association to Alza
	@OneToMany(mappedBy="piso")
	private Set<Alza> alzas;

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
	
}