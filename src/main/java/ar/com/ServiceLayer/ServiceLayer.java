package ar.com.ServiceLayer;

import java.io.Serializable;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.stereotype.Service;

import ar.com.DataLayer.data.DataLayerImple;
import ar.com.Request.data.Request;
import ar.com.config.spring.AppConfig;
import ar.com.model.domain.Archivo;
import ar.com.model.domain.Materias;
import ar.com.model.domain.Persona;
import ar.com.repository.Repository;

public class ServiceLayer implements ServiceCRUD {

	@Autowired
	private Repository data;

	public ServiceLayer() {

	}

	public void setData(Repository data) {
		this.data = data;
	}

	@Override
	public List<Object> ReadAll(Request req) {
		List<Object> obj = new ArrayList<Object>();
		obj = data.ReadAll(req.getObject().getClass());
		return obj;
	}

	@Override
	public Object ReadOne(Request req) throws Exception {
		try {
			return data.ReadOne(req.getObject().getClass(), req.getId());
		} catch (Exception ex) {
			System.out.println("BAD SERVICE");
			ex.printStackTrace();

			throw new Exception();
		}
	}

	@Override
	public int Save(Request req) {
		int id=0;
		try {
			id =data.save(req.getObject());
		} catch (Exception e) {
			e.printStackTrace();
		}
		return id;
	}

	@Override
	public void Update(Request req) {
		data.update(req.getObject());

	}

	@Override
	public void Delete(Request req) {
		data.delete(req.getObject());

	}

	@Override
	public List<Object> GetAllByField(Request req, String field) {
		data.GetAllByField(req.getObject(), field, req.getId());
		return null;
	}

	@Override
	public int getDiffFecha(String Fecha) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public boolean exists(Request req) {
		try {
			this.ReadOne(req);
			return true;
		} catch (Exception e) {

			return false;
		}

	}

	@Override
	public List<Object> ExecuteQuery(Request t, String field, Serializable id) {
		try{
			return data.ExecuteQuery(t,field,id);
			}
		catch(Exception e){
			e.printStackTrace();return null;
			}
		
	}

	@Override
	public List<Object> ExecuteCriteria(Class clazz, Map<Object, Object> filters) {
		try{return data.ExecuteCriteria(clazz, filters);}
		catch (Exception e) {
			e.printStackTrace();return null;
		}
	}

	@Override
	public List<Materias> getMaterias(Persona persona) {
		try{return data.getMaterias(persona);}
		catch (Exception e) {
			e.printStackTrace();return null;
		}
	}

	
	@Override
	public List<Object> getFiles(List<Materias> materias, boolean approved) {
		// TODO Auto-generated method stub
		return data.getFiles(materias, approved);
	}

	@Override
	public  List<Archivo> getArchivos(boolean alm, boolean prof, Materias ids) {
		return (List<Archivo>) data.getArchivos( alm, prof, ids);
	}
	
	

}
