package DAO;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;

import AddressBEAN.District;
import AddressBEAN.Province;
import AddressBEAN.Ward;
import BEAN.Address;
import BEAN.Cart;
import BEAN.Product;

public class AddressDAO {
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
	
	
	public boolean valiAddressChangeFromID(int idaddress,int idprovince,int iddistrict,int idward){
		begin();
		boolean result= false;
		try {
			System.out.println(idprovince+":"+iddistrict+":"+idward);
			String hql = "select a from Address a where id=:idaddress";
			Query query = entitymanager.createQuery(hql);	
			query.setParameter("idaddress", idaddress);		
			Address address =(Address) query.getSingleResult();
			System.out.println(address.getProvince().getId());
			System.out.println(address.getDistrict().getId());
			System.out.println(address.getWard().getId());
			if(address.getProvince().getId()==idprovince && 
					address.getDistrict().getId() == iddistrict &&
						address.getWard().getId() == idward) {
				result = true;
			}	
		} catch (Exception e) {			
			entitymanager.getTransaction().rollback();
			//e.printStackTrace();
		}finally {
			close();			
		}			
		
		return result;
	}	
	
	public Address findAddressByID(int idaddress) {
		begin();
		Address address = new Address();
		try {

			address = entitymanager.find(Address.class, idaddress);
			entitymanager.getTransaction().commit();
		} catch (Exception e) {			
			entitymanager.getTransaction().rollback();
			e.printStackTrace();
		}finally {
			close();			
		}			
		
		return address;
	}
	
	public Province findProvinceByID(int idprovince) {
		begin();
		Province province= new Province();
		try {

			province = entitymanager.find(Province.class, idprovince);
			entitymanager.getTransaction().commit();
		} catch (Exception e) {			
			entitymanager.getTransaction().rollback();
			e.printStackTrace();
		}finally {
			close();			
		}			
		
		return province;
	}
	public District findDistrictByID(int idDistrict) {
		begin();
		District district= new District();
		try {

			district = entitymanager.find(District.class, idDistrict);
			entitymanager.getTransaction().commit();
		} catch (Exception e) {			
			entitymanager.getTransaction().rollback();
			e.printStackTrace();
		}finally {
			close();			
		}			
		
		return district;
	}
	public Ward findWardByID(int idWard) {
		begin();
		Ward ward= new Ward();
		try {

			ward = entitymanager.find(Ward.class, idWard);
			entitymanager.getTransaction().commit();
		} catch (Exception e) {			
			entitymanager.getTransaction().rollback();
			e.printStackTrace();
		}finally {
			close();			
		}			
		
		return ward;
	}
	
	
	@SuppressWarnings("unchecked")
	public List<Province>  findALLprovince(){
		begin();
		List<Province> listprovince = new ArrayList<Province>();
		try {
				
			String hql = "select p from Province p";
			Query query = entitymanager.createQuery(hql);		
			listprovince = query.getResultList();
		
		} catch (Exception e) {
			entitymanager.getTransaction().rollback();
			e.printStackTrace();
		}finally {
			close();			
		}			
		
		return listprovince;
	}
	@SuppressWarnings("unchecked")
	public List<District>  findALLdistrict(int idprovince){
		begin();
		List<District> listdistrict = new ArrayList<District>();
		try {
				
			String hql = "select p from District p where provinceid =:idprovince";
			Query query = entitymanager.createQuery(hql);		
			query.setParameter("idprovince", idprovince);
			listdistrict = query.getResultList();
		
		} catch (Exception e) {
			entitymanager.getTransaction().rollback();
			e.printStackTrace();
		}finally {
			close();			
		}			
		
		return listdistrict;
	}
	@SuppressWarnings("unchecked")
	public List<Ward>  findALLward(int idprovince,int iddistrict){
		begin();
		List<Ward> listward = new ArrayList<Ward>();
		try {
				
			String hql = "select p from Ward p where provinceid =: idprovince and districtid =: iddistrict";
			Query query = entitymanager.createQuery(hql);	
			query.setParameter("idprovince", idprovince);
			query.setParameter("iddistrict", iddistrict);
			listward = query.getResultList();
		
		} catch (Exception e) {
			entitymanager.getTransaction().rollback();
			e.printStackTrace();
		}finally {
			close();			
		}			
		
		return listward;
	}
	
	public Province findProvincebyId(int idprovice) {
		Province provine = new Province();
		begin();					
		try {
			provine  = entitymanager.find(Province.class, idprovice);			
			entitymanager.getTransaction().commit();
		
		} catch (Exception e) {
			entitymanager.getTransaction().rollback();
			e.printStackTrace();
		}finally {
			close();			
		}
		
		return provine;
	}
	
	
	public District findDistrictbyId(int idDistrict) {
		District district = new District();
		begin();					
		try {
			district  = entitymanager.find(District.class, idDistrict);			
			entitymanager.getTransaction().commit();
		
		} catch (Exception e) {
			entitymanager.getTransaction().rollback();
			e.printStackTrace();
		}finally {
			close();			
		}
		
		return district;
	}
	
	
	public Ward findWardbyId(int idWard) {
		Ward ward = new Ward();
		begin();					
		try {
			ward  = entitymanager.find(Ward.class, idWard);			
			entitymanager.getTransaction().commit();
		
		} catch (Exception e) {
			entitymanager.getTransaction().rollback();
			e.printStackTrace();
		}finally {
			close();			
		}
		
		return ward;
	}
	
	
	public void saveAddress(Address address) {
		begin();					
		try {
			entitymanager.persist(address);
			entitymanager.getTransaction().commit();
		
		} catch (Exception e) {
			entitymanager.getTransaction().rollback();
			e.printStackTrace();
		}finally {
			close();			
		}
		
	}
}
