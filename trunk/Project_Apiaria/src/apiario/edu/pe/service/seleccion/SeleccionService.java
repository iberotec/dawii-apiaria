package apiario.edu.pe.service.seleccion;

import java.util.List;


import apiario.edu.pe.bean.Apiario;
import apiario.edu.pe.dao.seleccion.AlzaDAO;
import apiario.edu.pe.dao.seleccion.ApiarioDAO;
import apiario.edu.pe.dao.seleccion.CentrifugadoraDAO;
import apiario.edu.pe.dao.seleccion.ColmenaDAO;
import apiario.edu.pe.dao.seleccion.PisoDAO;
import apiario.edu.pe.factoria.DAOFactory;
import apiario.edu.pe.factoria.DAOFactory.TipoFabrica;

public class SeleccionService implements ApiarioDAO,AlzaDAO,CentrifugadoraDAO,ColmenaDAO,PisoDAO{
	DAOFactory objDAOFactory= DAOFactory.getDAOFactory(TipoFabrica.MYSQL);
	ApiarioDAO objApiarioDAO = objDAOFactory.getApiarioDAO();
	@Override
	public List<Apiario> listarApiarios() throws Exception {
		objApiarioDAO.actualizarApiario(null);
		return null;
	}

	@Override
	public Apiario buscarApiarioporId(Integer codigo) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void actualizarApiario(Apiario entidad) throws Exception {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void registrarApiario(Apiario entidad) throws Exception {
		// TODO Auto-generated method stub
		
	}

}
