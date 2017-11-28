package ar.com.ServiceLayer;

import java.io.Serializable;
import java.util.List;
import java.util.Map;

import ar.com.Request.data.Request;
import ar.com.model.domain.Archivo;
import ar.com.model.domain.Materias;
import ar.com.model.domain.Persona;

public interface ServiceCRUD {
	public List<Object> ReadAll(Request req);

	public Object ReadOne(Request req) throws Exception;

	public int Save(Request req);

	public void Update(Request req);

	public void Delete(Request req);
	
	public List<Object> ExecuteQuery(Request t,String field, Serializable id); 

	public List<Object> GetAllByField(Request req, String field);
	
	public List<Object> ExecuteCriteria(Class clazz, Map<Object,Object> filters);

	public int getDiffFecha(String Fecha);
	
	public boolean exists(Request obj);
	public List<Materias> getMaterias(Persona persona);
	public List<Object> getFiles(List<Materias> materias,boolean approved);
	public List<Archivo> getArchivos(boolean alm, boolean prof, Materias ids);
}
