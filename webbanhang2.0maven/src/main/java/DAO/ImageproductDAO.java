package DAO;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;

import BEAN.Product;
import BEAN.imageproduct;

public class ImageproductDAO {
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
	
	public imageproduct getavtimage(Product product) {
		begin();
		
		imageproduct img = new imageproduct();
		
		try {				
					Query q =  entitymanager.createQuery(
				    "From imageproduct i where id_product =:id");
					q.setParameter("id", product);
				    img = (imageproduct) q.getSingleResult();
		
		} catch (Exception e) {
			entitymanager.getTransaction().rollback();
			e.printStackTrace();
		}finally {
			close();			
		}
	
		return img;
	}
	
}
