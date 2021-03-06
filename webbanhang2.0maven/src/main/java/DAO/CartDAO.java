package DAO;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;

import BEAN.Cart;
import BEAN.Product;

public class CartDAO {
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

	public void save(Cart cart) {
		begin();					
		try {
			entitymanager.persist(cart);	
			entitymanager.getTransaction().commit();	
		} catch (Exception e) {
			entitymanager.getTransaction().rollback();
			e.printStackTrace();
		}finally {
			close();			
		}
		
	}

}
