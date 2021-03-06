package DAO;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;

import BEAN.Product;
import BEAN.Size_category_product;

public class ProductDAO {
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
	
	
	public void save(Product product) {
		begin();					
		try {
			entitymanager.persist(product);
			System.out.println("Save product success");
			entitymanager.getTransaction().commit();
		
		} catch (Exception e) {
			entitymanager.getTransaction().rollback();
			e.printStackTrace();
		}finally {
			close();			
		}
		
	}
	
	public Product findbyId(int idproduct) {
		Product product = new Product();
		begin();					
		try {
			product = entitymanager.find(Product.class, idproduct);
			System.out.println("Get product by Id success");
			entitymanager.getTransaction().commit();
		
		} catch (Exception e) {
			entitymanager.getTransaction().rollback();
			e.printStackTrace();
		}finally {
			close();			
		}
		
		return product;
	}
	
	@SuppressWarnings("unchecked")
	public List<Object[]>  findALproduct(){
		begin();
		List<Object[]> listproduct = new ArrayList<Object[]>();
		try {
				
			String hql = "select p.id,p.name, p.price, p.discount, i.url from Product p, imageproduct i";
			Query query = entitymanager.createQuery(hql);		
			listproduct = query.getResultList();
		
		} catch (Exception e) {
			entitymanager.getTransaction().rollback();
			e.printStackTrace();
		}finally {
			close();			
		}			
		
		return listproduct;
	}
	
	@SuppressWarnings("unchecked")
	public int numberofproduct() {
		begin();
		int total=0;
		List<Product> listproduct = new ArrayList<Product>();
		try {
				
			Query q = entitymanager.createQuery("from Product");
			listproduct = q.getResultList();		
			total = listproduct.size();
		} catch (Exception e) {
			entitymanager.getTransaction().rollback();
			e.printStackTrace();
		}
			close();			
			
		
		return total;
	}
	
	@SuppressWarnings("unchecked")
	public  List<Object[]>  findproductbyPage(int pageid,int total){
		begin();
		List<Object[]> listproduct = new ArrayList<Object[]>();
		try {
				
			String hql = "select p.id,p.name, p.price, p.discount, i.url from Product p, imageproduct i";
			Query q = entitymanager.createQuery(hql);
			q.setFirstResult(pageid);
			q.setMaxResults(total);
			listproduct = q.getResultList();
		} catch (Exception e) {
			entitymanager.getTransaction().rollback();
			e.printStackTrace();
		}
			close();							
		return listproduct;
	}
	


	public  Product  findproductbyidd(int idproduct){
		begin();
		Product product = new Product();
		try {
				
		//	String hql = "select p.name, p.price, p.discount,p.detail , i.url from Product p, imageproduct i where p.id=:idproduct";
			String hql = "From Product p where p.id=:idproduct";
			Query q = entitymanager.createQuery(hql);
			q.setParameter("idproduct", idproduct);
			product = (Product)q.getSingleResult();
		} catch (Exception e) {
			entitymanager.getTransaction().rollback();
			e.printStackTrace();
		}finally {
			close();			
		}				
		return product;
	}
	@SuppressWarnings("unchecked")
	public List<Size_category_product> findsizebyidpd(Product product){
		begin();
		List<Size_category_product> listsize = new ArrayList<Size_category_product>();
		try {
				
			String hql = "From Size_category_product s where s.product_size=:idproduct";
			Query q = entitymanager.createQuery(hql);
			q.setParameter("idproduct", product);
			listsize = q.getResultList();
		} catch (Exception e) {
			entitymanager.getTransaction().rollback();
			e.printStackTrace();
		}finally {
			close();			
		}				
		return listsize;
	}


}
