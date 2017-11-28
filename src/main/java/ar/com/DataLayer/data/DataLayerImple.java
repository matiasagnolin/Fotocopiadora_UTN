package ar.com.DataLayer.data;

import java.io.Serializable;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import org.hibernate.Criteria;
import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Restrictions;
import org.hibernate.ejb.EntityManagerFactoryImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate3.HibernateCallback;
import org.springframework.orm.hibernate3.HibernateTemplate;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;


import ar.com.Request.data.Request;
import ar.com.model.domain.Alumno;
import ar.com.model.domain.Archivo;
import ar.com.model.domain.Materias;
import ar.com.model.domain.Persona;
import ar.com.model.domain.Profesor;
import ar.com.repository.Repository;

@Transactional
public class DataLayerImple<T>implements Repository {
	
	
	
	private HibernateTemplate hibernateTemplate = null;
	
	@Autowired
	public void setSessionFactory(SessionFactory sessionFactory){
		this.hibernateTemplate = new HibernateTemplate(sessionFactory);
	}
	
	
	@Transactional(propagation=Propagation.REQUIRED, readOnly=true)
	public List<Object> ReadAll(Class obj) {
		return (List<Object>) hibernateTemplate.loadAll(obj);
	}

	@Transactional(propagation=Propagation.REQUIRED)
	public int save(Object t) {
		int id = (int) hibernateTemplate.save(t);
		return id;
	}


	@Transactional(propagation=Propagation.REQUIRED)
	public Object ReadOne(Class t, Serializable id) throws Exception{
		Object obj=null;
		try{
		obj=hibernateTemplate.get(t, id);}
		catch(Exception e){e.printStackTrace();throw new Exception();}
		if(obj == null) throw new Exception();
		return obj;
	}

	@Transactional(propagation=Propagation.REQUIRED)
	public void update(Object t) {
		hibernateTemplate.update(t);
	}

	@Override
	public void delete(Object obj) {
		hibernateTemplate.delete(obj);
		
	}
	@Transactional(propagation=Propagation.REQUIRED)
	@Override
	public List<Object> ExecuteCriteria(Class clazz, Map<Object,Object> filters) {
		DetachedCriteria criteria = DetachedCriteria.forClass(clazz);
		//Materias materia=null;
//		try {
//			 materia = (Materias)ReadOne(Materias.class, 1);
//		} catch (Exception e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
		
		
		List<Object> result = null;
		 Iterator it = filters.entrySet().iterator();
		    while (it.hasNext()) {
		    	Map.Entry mentry = (Map.Entry)it.next();
		    	if(mentry.getKey().toString().equals("materia"))
		    	{
		    		List<Object> list = (List<Object>) mentry.getValue();
		    		Materias[] mat = new Materias[list.size()];
		    		for(int i = 0; i<list.size();i++)
		    		{
		    			if(list.get(i) instanceof Object[])
		    			{
		    				Object[] o =(Object[]) list.get(i);
		    				for(int h = 0 ;h<o.length;h++)
		    					if(o[h] instanceof Materias)
		    						mat[i]=(Materias)o[h];
		    			}
		    		}
		    		//criteria.add(Restrictions.in(mentry.getKey().toString(), mat));
		    	}
		    	else
		    		if(mentry.getKey().toString().equals("Aprobado"))
		    	criteria.add(Restrictions.eq(mentry.getKey().toString(), mentry.getValue()));
		    	if(mentry.getKey().equals("Deleted"))
		    			criteria.add(Restrictions.eq((String) mentry.getKey(),mentry.getValue()));
		    	if(mentry.getKey().equals("Publico"))
	    			criteria.add(Restrictions.eq((String) mentry.getKey(),mentry.getValue()));	
		    	if(mentry.getKey().equals("Nombre_Usuario"))
	    			criteria.add(Restrictions.eq((String) mentry.getKey(),mentry.getValue()));
		        it.remove(); 
		    }
		   
		    result = hibernateTemplate.findByCriteria(criteria);	
		
		return result;
	}
	@Override
	public List<Object>getFiles(List<Materias> materias,boolean approved){
		
		List<Object> files=null;
		Session session=null;
		String query="from Archivo as A inner join Materias as B on A.Id_Materia=B.id_Materia "
				+ "inner join Carreras as C on A.id_Carrera=C.id_Carrera where A.Id_Materia in (:materias) and A.Aprobado=:Aprobado and A.Publico:Publico and A.deleted=:delted";
		
		hibernateTemplate.getSessionFactory().openSession();
		if(!hibernateTemplate.getSessionFactory().isClosed())
			session= hibernateTemplate.getSessionFactory().getCurrentSession();
		
		Query q = session.createQuery(query);
		
	
		q.setParameter("Publico", true);
		q.setParameter("deleted",false);
		q.setParameterList("materias", materias);
		q.setParameter("Aprovado", approved);
		files=q.list();
		return files;
	}
	

	@Override
	public List<Object> GetAllByField(Object t, String field, Serializable id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	@Transactional(propagation=Propagation.REQUIRED)
	public List<Object> ExecuteQuery(Request t, String field, Serializable id) {
		List<Object> obj  = null;
		
		String clase=t.getObject().getClass().toString();
		String query= "from " + clase.substring(clase.indexOf("class")+6) + " where " + field +"= ?";
		
		//String query= "from Usuario where Nombre_Usuario= ?";
		//from class ar.com.model.domain.Usuario where Nombre_Usuario= ?

		Serializable[] param = {id};
		
		System.out.println(query);
		try{
			obj= hibernateTemplate.find(query,param);
		}
		catch(Exception e){System.out.println("Query failed");e.printStackTrace();}
		
		return obj;
	}
	@SuppressWarnings("finally")
	public List<Materias> getMaterias(Persona persona){
		String Query="";
		List<Materias>list=null;
		if(persona instanceof Alumno)
		Query = "from Alumno as a inner join a.materias as b where a.Id_Persona= ?";
		else
			if(persona instanceof Profesor)
				Query = "from Profesor as a inner join a.materias as b where a.Id_Persona= ?";
		
		Serializable[] param={persona.getId_Persona()};
		try{list=hibernateTemplate.find(Query,param);}
		catch(Exception e){System.out.println("Query filed");e.printStackTrace();}
		finally {
			return list;
		}
	}
	
	public HibernateTemplate getHibernateTemplate() {
		return hibernateTemplate;
	}

	@Override
	public List<Archivo> getArchivos(boolean alm, boolean prof, Materias ids){
		String Query="";
		List<Archivo>list=null;
		Query="from Archivo a where a.materia= ?";
		Serializable[] param={ids};
		try{list=hibernateTemplate. find(Query,param);}
		catch(Exception e){System.out.println("Query filed");e.printStackTrace();}
		finally {
			return list ;
		}
	
	}

	
	
	

	
}
