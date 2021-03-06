package DAO;

import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;

import AddressBEAN.District;
import AddressBEAN.Province;
import AddressBEAN.Ward;
import BEAN.Address;
import BEAN.Category_member;
import BEAN.Category_product;
import BEAN.Discount;
import BEAN.Mber;

import BEAN.Product;
import BEAN.Size_category_product;
import BEAN.imagemember;
import BEAN.imageproduct;



public class TestHomeCotroller {
	static EntityManagerFactory factory; 
	static EntityManager entitymanager;
	
	private static void close() {
		entitymanager.getTransaction().commit();
		entitymanager.close();
		factory.close();
	}
	
	private static void begin() {
		factory = Persistence.createEntityManagerFactory("jpaa");
		entitymanager = factory.createEntityManager();
		entitymanager.getTransaction().begin();
	}
	public static void main(String[] args) {
	
		
		
		begin();
	
		
		AddressDAO add = new AddressDAO();
		
		
		
		
//		//Address address = (mber.getListAddress().get(0));
		//Address address = new Address("67 Trương Định",mber,addressDAO.findWardbyId(8883),addressDAO.findProvincebyId(47),addressDAO.findDistrictbyId(550));
		
		//addressDAO.saveAddress(address);
		//	AddressDAO address = new AddressDAO();
		
		//List<Ward> ward =  address.findALLward(1, 1);
	
	//	List<District> district = address.findALLdistrict(1);
			//	address.findALLprovince();
		
//		ProductDAO produrtDAO = new ProductDAO();
//		//List<Object[]> product = produrtDAO.findproductbyid(7);
//		//model.addAttribute("product", product); 
//		
//		
//		Product pro = produrtDAO.findproductbyidd(7);
//		for(Size_category_product a:pro.getListsize()) {
//			System.out.println(a.getNameSize());
//		}
//			System.out.println(pro.getId());
//			System.out.println(pro.getName());
//			System.out.println(pro.getPrice());
//			System.out.println(pro.getDetail());
//			System.out.println(pro.getimgavt());
	
		
		
		
	//	Product product = entitymanager.find(Product.class, 7);
//		Size_category_product sizeofpd = new Size_category_product("S",product);
//		Size_category_product sizeofpd1 = new Size_category_product("M",product);
//		Size_category_product sizeofpd2 = new Size_category_product("L",product);
//		Size_category_product sizeofpd3 = new Size_category_product("XL",product);
//		Size_category_product sizeofpd4 = new Size_category_product("XL",product);
////		
////		
////	
//		product.addSize(sizeofpd);
//		product.addSize(sizeofpd1);
//		product.addSize(sizeofpd2);
//		product.addSize(sizeofpd3);
//		product.addSize(sizeofpd4);
	//	for(Size_category_product a:product.getSize()) {
		//	System.out.println(a.getSize());
	//	}
		
		
	//	entitymanager.merge(product);
		
//		entitymanager.persist(sizei1);
//		entitymanager.persist(sizei2);
//		entitymanager.persist(sizei3);
//		entitymanager.persist(sizei4);
		
//		//System.out.print(product.getimgavt());
//		
//		//ImageproductDAO image = new ImageproductDAO();
//		System.out.print(product.getimgavt());
		
		
	
		
		
//		SearchAndCmtDAO searchAndCmtDAO = new SearchAndCmtDAO();
//		List<Product> result = searchAndCmtDAO.searchproduct("h");
//		//List<String> result = new ArrayList<String>();
//		//result.add("Lưu");
//	   String test="";
//		for(Product product:result) {
//			test += "<div class='container' id='search'>"+
//				 	"<h3 style='padding-left: 12px;opacity: 1.0;''>" +
//				 	"<a href='shopsingle.htm?idpd="+product.getId()+"'>"+product.getName()+"</a></h3></div>"+"\n";
//		}
//		System.out.println(test+"\n");
	//	Category_product category_product = entitymanager.find(Category_product.class, 28);
	//	Product product = entitymanager.find(Product.class, 13);
	//	category_product.addProduct(product);
	
	//	product.addCategory(category_product);
		//for(int i=21;i<50;i++) {
		//Product product = new Product("Gray Lưu",90.00f,"Lorem ipsum dolor sit amet, consectetur adipisicing elit. Pariatur, vitae, explicabo? Incidunt facere, natus soluta dolores iusto! Molestiae expedita veritatis nesciunt doloremque sint asperiores fuga voluptas, distinctio, aperiam, ratione dolore."
		//		,5,0f,new Date(),new Date());
		//	entitymanager.persist(product);
	//	Product product = entitymanager.find(Product.class, 13);
	
		//Query q = entitymanager.createQuery("from Product");
		//listproduct = q.getResultList();	
		
//		ProductDAO produrtDAO = new ProductDAO();
//		List<Object[]> product = produrtDAO.findproductbyid(7);
//		
//		
//		for(Object[] obj:product) {			
//				System.out.println(obj[0] + " " + obj[1]+ " " + obj[2] + " " + obj[3]+ " " + obj[4]);
//		}
		
		
		
		
	//	System.out.print(product.getImgproduct());
	//	imageproduct imgpd = new imageproduct(product,"FE/Mainthem/images/prod_2.png","",false);
	//	product.addImage(imgpd);
	//	entitymanager.persist(product);
			
		
		//	}
		//category_product.addProduct(product);
	//	product.addCategory(category_product);
		//Product add category Of product
	//	entitymanager.remove(product);
	//	entitymanager.remove(category_product);
		
		
				//*/
		
		//Product product = ;
		//Category_product category_product = 
		//Category_product ca = new Category_product("Ao");
		//Category_product ca2 = new Category_product("Quan short");
		//Category_product ca3 = new Category_product("Quan dai");
//		//ca.getCategoryProduct().removeAll(ca.getCategoryProduct());
//		entitymanager.persist(ca);
//		entitymanager.persist(ca2);
//		entitymanager.persist(ca3);
//		
//		Size_category_product size1 = new Size_category_product("S");
//		Size_category_product size2 = new Size_category_product("M");
//	    Size_category_product size3 = new Size_category_product("L");
//		Size_category_product size4 = new Size_category_product("XL");
//		Size_category_product size5 = new Size_category_product("XXL");
////	
//		entitymanager.persist(size1);
//		entitymanager.persist(size2);
//		entitymanager.persist(size3);
//		entitymanager.persist(size4);
//		entitymanager.persist(size5);
		
		
//		Size_category_product size6 = new Size_category_product(ca3,"27");
//		Size_category_product size7 = new Size_category_product(ca3,"28");
//		Size_category_product size8 = new Size_category_product(ca3,"29");
//		Size_category_product size9 = new Size_category_product(ca3,"30");
//		Size_category_product size10 = new Size_category_product(ca3,"31");
//		
//		Size_category_product size11 = new Size_category_product(ca2,"28");
//		Size_category_product size12 = new Size_category_product(ca2,"29");
//		Size_category_product size13 = new Size_category_product(ca2,"30");
//		Size_category_product size14 = new Size_category_product(ca2,"31");
//		Size_category_product size15 = new Size_category_product(ca2,"32");
//		
//		
//		
//		entitymanager.persist(size1);
//		entitymanager.persist(size2);
//		entitymanager.persist(size3);
//		entitymanager.persist(size4);
//		entitymanager.persist(size5);
//		
//		entitymanager.persist(size6);
//		entitymanager.persist(size7);
//		entitymanager.persist(size8);
//		entitymanager.persist(size9);
//		entitymanager.persist(size10);
//		
//		entitymanager.persist(size11);
//		entitymanager.persist(size12);
//		entitymanager.persist(size13);
//		entitymanager.persist(size14);
//		entitymanager.persist(size15);
		
//		for(Category_product cate:product.getCategoryproduct()) {
//				//System.out.print(cate.getSize_category_product());
//			for(Size_category_product c:cate.getSize_category_product()) {
//				System.out.println(c.getSize());
//			}
//		}
		//Product product = entitymanager.find(Product.class, 7);
		//product.addCategory(entitymanager.find(Category_product.class, 40));
		//product.getCategoryproduct().removeAll(product.getCategoryproduct());
		//entitymanager.merge(product);
//			for(Category_product ca: product.getCategoryproduct()) {
//			for (Size_category_product test:ca.getSize_category_product())
//			{
//				System.out.println(test.getSize());
//			}
//		}
		//	Category_product cate = entitymanager.find(Category_product.class, 39);
		//	cate.getCategoryProduct();
		 
		
		
		//product.addCategory(entitymanager.find(Category_product.class, 39));
		//entitymanager.merge(product);
		//product.addCategory(entitymanager.find(Category_product.class, 29));
		//product.addCategory(entitymanager.find(Category_product.class, 28));
	//	ca.removeProduct(entitymanager.find(Product.class, 67));
		// ca.getCategoryProduct().removeAll(ca.getCategoryProduct());
		//ca.getCategoryproduct().removeAll(product.getCategoryproduct());
	//	for(int i=1;i<5;i++) {
//			entitymanager.persist(size1);
//			entitymanager.persist(size2);
//			entitymanager.persist(size3);
//			entitymanager.persist(size4);
//			entitymanager.persist(size5);
		//}
		//entitymanager.remove(size);
		//Product product = entitymanager.find(Product.class, 13);
		//product.getCategoryproduct().removeAll(product.getCategoryproduct());
		
		
		//category_product.removeProduct(product);
		
		//Group group = groupRepository.findOne(groupId);
	  //  group.getUsers().removeAll(group.getUsers());
		
	//	for(Category_product cate:product.getCategoryproduct()) {
	//		cate.getCategoryProduct().remove(product);
			
	//	}
		//entitymanager.remove(product);
		
		//	entitymanager.merge(category_product);
		//entitymanager.merge(category_product);
		//entitymanager.merge(category_product);
		
		
		close();
		//	entitymanager.remove(category_product);
		
		//Category_member category_member = new Category_member("client");
//		MemberDAO memberr = new MemberDAO();
//		Category_member categorymember =(Category_member) memberr.findCategoryMember(0);
//		Mber member = new Mber("Lưu Hồng Quân","hongquan0912@gmail.com","0912",true,"Dong Thap","0917392341",new Date());
//		member.setCategorymb(categorymember);
//		System.out.print(member);
//		entitymanager.persist(member);
	//	Category_member cr = new Category_member("test");
	//	member.setCreateat(createat);
	//	category_member.addMember(member);
		
	//	entitymanager.persist(member);
		
		
	//	Product product = entitymanager.find(Product.class, 7);
		
	//	image img = new image("link","",true);
		
	//	product.addImage(img);
		
	//	entitymanager.persist(img);
		
		//Product product = entitymanager.find(Product.class, 7);
		
	//	Mber mber = entitymanager.find(Mber.class, 7);
	//	imagemember img = new imagemember(mber,"link","",false);
		
	//	mber.addImage(img);
		
//		entitymanager.persist(mber);
		
		
		
	//	System.out.print(new Date());
	}
}