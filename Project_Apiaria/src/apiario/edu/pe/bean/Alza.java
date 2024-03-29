package apiario.edu.pe.bean;

import java.io.Serializable;
import javax.persistence.*;
import java.util.Set;


/**
 * The persistent class for the alza database table.
 * 
 */
@Entity
@Table(name="alza")
public class Alza implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	private int idalza;

	//bi-directional many-to-one association to Piso
    @ManyToOne
	@JoinColumn(name="idpiso")
	private Piso piso;

	//bi-directional many-to-one association to TipoAlza
    @ManyToOne
	@JoinColumn(name="idtipo_alza")
	private TipoAlza tipoAlza;

	//bi-directional many-to-one association to DetallePlanillaRevisionAlza
	@OneToMany(mappedBy="alza")
	private Set<DetallePlanillaRevisionAlza> detallePlanillaRevisionAlzas;

    public Alza() {
    }

	public int getIdalza() {
		return this.idalza;
	}

	public void setIdalza(int idalza) {
		this.idalza = idalza;
	}

	public Piso getPiso() {
		return this.piso;
	}

	public void setPiso(Piso piso) {
		this.piso = piso;
	}
	
	public TipoAlza getTipoAlza() {
		return this.tipoAlza;
	}

	public void setTipoAlza(TipoAlza tipoAlza) {
		this.tipoAlza = tipoAlza;
	}
	
	public Set<DetallePlanillaRevisionAlza> getDetallePlanillaRevisionAlzas() {
		return this.detallePlanillaRevisionAlzas;
	}

	public void setDetallePlanillaRevisionAlzas(Set<DetallePlanillaRevisionAlza> detallePlanillaRevisionAlzas) {
		this.detallePlanillaRevisionAlzas = detallePlanillaRevisionAlzas;
	}
	
}