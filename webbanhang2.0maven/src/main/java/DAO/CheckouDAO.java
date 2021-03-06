package DAO;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;

import BEAN.Discount;
import BEAN.Product;

public class CheckouDAO {
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
	
	public float getcost(int Provinid,int districtid) {
		return 30000f;
	}
	public float getcost2(int Provinid,int districtid) {
		return 20000f;
	}
	
	public float getDiscount(String c_code) {	
		begin();
		float discoutcost=0;
		Discount discount = new Discount();
		try {		
			String hql = "From Discount d where d.madiscount=:c_code and efficiency=1";
			Query q = entitymanager.createQuery(hql);
			q.setParameter("c_code", c_code);
			discount = (Discount) q.getSingleResult();
			discoutcost = discount.getCost();
		} catch (Exception e) {
			entitymanager.getTransaction().rollback();
			e.printStackTrace();
		}finally {
			close();			
		}
			
		return discoutcost;
	
	}
	public String getcodeDiscount(String c_code) {	
		begin();
		String namecost="";
		Discount discount = new Discount();
		try {		
			String hql = "From Discount d where d.madiscount=:c_code and efficiency=1";
			Query q = entitymanager.createQuery(hql);
			q.setParameter("c_code", c_code);
			discount = (Discount) q.getSingleResult();
			namecost = discount.getMadiscount();
		} catch (Exception e) {
			entitymanager.getTransaction().rollback();
			e.printStackTrace();
		}finally {
			close();			
		}
			
		return namecost;
	
	}
	
	
	
}
