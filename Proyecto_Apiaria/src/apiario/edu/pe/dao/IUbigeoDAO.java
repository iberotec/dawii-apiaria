package apiario.edu.pe.dao;

import java.util.List;

import apiario.edu.pe.bean.Pai;
import apiario.edu.pe.bean.Ubigeo;

public interface IUbigeoDAO {

	void attachClean(Ubigeo instance);
    void attachDirty(Ubigeo instance);
    void delete(Ubigeo persistentInstance);
    List findAll();
    List findByExample(Ubigeo instance);
    Ubigeo findById(Integer id);
    Ubigeo merge(Ubigeo detachedInstance);
    void save(Ubigeo transientInstance);
    public List listDpto(Pai instance);
    public List listProv(Ubigeo instance);
    public List listDis(Ubigeo instance);
    public List findByProperty(String propertyName, Object value);
    public Ubigeo buscarPorCodigo(String ubiCodigo);
	
}
