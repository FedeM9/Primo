package persistence.jpa;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.Query;
import javax.persistence.TypedQuery;

import persistence.*;


public class CrudRepository <T> implements persistence.CrudRepository<T>{
	private EntityManager em;
	private Class <T> entityClass;
	public CrudRepository(EntityManager em, Class<T> entityClass) {
		this.em=em;
		this.entityClass=entityClass;
		// TODO Auto-generated constructor stub
	}
	@Override
	public T save(T entity) {
		Method getId=null;
		T persistenceEntity = null;
		try {
			getId=this.entityClass.getMethod("getId");
		} catch (NoSuchMethodException |SecurityException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		try {
			if(getId.invoke(entity)==null){
				em.persist(entity);
				persistenceEntity=entity;
			}else
				persistenceEntity=  em.merge(entity);
		} catch (IllegalAccessException |IllegalArgumentException |InvocationTargetException  e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}   //update così l'oggetto di ritorno è managed
		return persistenceEntity;
		
	}

	@Override
	public T findOne(Long id) {
		return em.find(this.entityClass, id);
	}

	
	private String getClassName(){
		String fullclassname=entityClass.getCanonicalName();
		String classname= fullclassname.substring(fullclassname.lastIndexOf('.')+1);
		return classname;
	}
	
	protected EntityManager getEm() {
		return em;
	}
	protected void setEm(EntityManager em) {
		this.em = em;
	}
	@Override
	public List<T> findAll() {

		TypedQuery<T> query=em.createQuery("SELECT e FROM "+this.getClassName()+" e", this.entityClass);
		return query.getResultList();
	}

	@Override
	public void delete(T entity) {
		// TODO Auto-generated method stub
		em.remove(entity);
		
	}

	@Override
	public void deleteAll() {
		// TODO Auto-generated method stub
		
		Query query=em.createQuery("DELETE FROM "+this.getClassName());
		query.executeUpdate();
	}

}
