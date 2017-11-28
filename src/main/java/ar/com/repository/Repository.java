package ar.com.repository;

import java.io.Serializable;
import java.util.List;
import java.util.Map;

import ar.com.Request.data.Request;
import ar.com.model.domain.Archivo;
import ar.com.model.domain.Materias;
import ar.com.model.domain.Persona;

public interface Repository{
	
	public List<Object> ReadAll(Class t);
	public Object ReadOne(Class t,Serializable id)throws Exception;
	public int save(Object t);
	public void update(Object t);
	public List<Object> ExecuteQuery(Request t,String field, Serializable id); 
	public List<Object> GetAllByField(Object t,String field, Serializable id);
	public List<Object> ExecuteCriteria(Class clazz, Map<Object,Object> filters);
	public void delete(Object obj);
	public List<Materias> getMaterias(Persona persona);
	public List<Object>getFiles(List<Materias> materias,boolean approved);
	public List<Archivo> getArchivos(boolean alm, boolean prof, Materias ids);
	
}


