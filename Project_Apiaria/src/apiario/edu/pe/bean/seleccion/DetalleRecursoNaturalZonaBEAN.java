package apiario.edu.pe.bean.seleccion;

public class DetalleRecursoNaturalZonaBEAN {

	private ZonaBEAN beanZona;
	private RecursoNaturalBEAN beanRecursoNatural;
	private double porcentajeRecursos;
	
	public DetalleRecursoNaturalZonaBEAN(ZonaBEAN beanZona,
			RecursoNaturalBEAN beanRecursoNatural, double porcentajeRecursos) {
		super();
		this.beanZona = beanZona;
		this.beanRecursoNatural = beanRecursoNatural;
		this.porcentajeRecursos = porcentajeRecursos;
	}

	public ZonaBEAN getBeanZona() {
		return beanZona;
	}

	public void setBeanZona(ZonaBEAN beanZona) {
		this.beanZona = beanZona;
	}

	public RecursoNaturalBEAN getBeanRecursoNatural() {
		return beanRecursoNatural;
	}

	public void setBeanRecursoNatural(RecursoNaturalBEAN beanRecursoNatural) {
		this.beanRecursoNatural = beanRecursoNatural;
	}

	public double getPorcentajeRecursos() {
		return porcentajeRecursos;
	}

	public void setPorcentajeRecursos(double porcentajeRecursos) {
		this.porcentajeRecursos = porcentajeRecursos;
	}
	
	
}
