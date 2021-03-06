package DAO;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;

import BEAN.Product;

public class SearchAndCmtDAO {
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
	public List<Product> searchproduct(String name) {
			begin();			
			List<Product> listproduct = new ArrayList<Product>();
			try {
					
				Query q = entitymanager.createQuery("select p from Product p where p.name LIKE :search");
				q.setParameter("search","%"+name+"%");
				q.setFirstResult(0);
				q.setMaxResults(5);
				listproduct = q.getResultList();						
			} catch (Exception e) {
				entitymanager.getTransaction().rollback();
				e.printStackTrace();
			}
				close();					
			return listproduct;
	}
}
