package DAO;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;

import BEAN.Address;
import BEAN.Category_member;
import BEAN.Mber;
import BEAN.Product;
import BEAN.Size_category_product;

public class MemberDAO {
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
	

	public Mber findbyId(int idmber) {
		Mber mber = new Mber();
		begin();					
		try {
			mber = entitymanager.find(Mber.class, idmber);
			//System.out.println("Get product by Id success");
			entitymanager.getTransaction().commit();	
		} catch (Exception e) {
			entitymanager.getTransaction().rollback();
			e.printStackTrace();
		}finally {
			close();			
		}
		
		return mber;
	}
	
	public void Save(Mber mber) {
		begin();					
		try {
			entitymanager.persist(mber);			
			entitymanager.getTransaction().commit();	
		} catch (Exception e) {
			entitymanager.getTransaction().rollback();
			e.printStackTrace();
		}finally {
			close();			
		}
		
	}
	public Category_member findCategoryMember(int id) {
		Category_member category_member = new Category_member();
		begin();					
		try {
			category_member = entitymanager.find(Category_member.class, id);		
				
		} catch (Exception e) {
			entitymanager.getTransaction().rollback();
			e.printStackTrace();
		}finally {
			close();			
		}
		return category_member;
	}
	
	
}
