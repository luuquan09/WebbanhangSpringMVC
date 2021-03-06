package DAO;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import BEAN.Cart;
import BEAN.Order;
import BEAN.Order_item;

public class OrderDAO {
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

	public void saveorder(Order order) {
		begin();					
		try {
			entitymanager.persist(order);	
			entitymanager.getTransaction().commit();	
		} catch (Exception e) {
			entitymanager.getTransaction().rollback();
			e.printStackTrace();
		}finally {
			close();			
		}
		
	}
	
	public void saveorderitems(Order_item order_item) {
		begin();					
		try {
			entitymanager.persist(order_item);	
			entitymanager.getTransaction().commit();	
		} catch (Exception e) {
			entitymanager.getTransaction().rollback();
			e.printStackTrace();
		}finally {
			close();			
		}
		
	}
	public boolean Sendmail(Order order,Order_item order_item) {
		boolean a=false;
		
		
		return a;
	}
	
}
