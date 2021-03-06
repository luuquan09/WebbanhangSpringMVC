package DAO;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;

import BEAN.Mber;

public class LoginAndRegistrationDAO {
	static EntityManagerFactory factory; 
	static EntityManager entitymanager;
	
	private static void close() {
		entitymanager.close();
		factory.close();
	}
	
	private static void begin() {
		factory = Persistence.createEntityManagerFactory("jpaa");
		entitymanager = factory.createEntityManager();
		entitymanager.getTransaction().begin();
	}
	

	@SuppressWarnings("unchecked")
	public List<Object[]> validatelogin(String email,String password) {
		begin();
		List<Object[]> result = new ArrayList<Object[]>();
		try {
			
			String hql = "Select m.namemember,m.id,m.categorymb from Mber m where email=:em and password=:pass";
			Query query = entitymanager.createQuery(hql);		
			query.setParameter("em", email);
			query.setParameter("pass", password);
			result  = query.getResultList();	
	
		} catch (Exception e) {
			entitymanager.getTransaction().rollback();
			e.printStackTrace();
		}finally {
			close();			
		}				
		return result;
	}
	
	
}
