package BEAN;


import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.Table;


@Entity
@Table(name ="category_product")
public class Category_product {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id_category_pd")	
	private int id;
	private String title;


	public Category_product(String title) {
		this.title = title;
		
	}
	
	
	public Category_product() {
		
	}
	@ManyToMany(mappedBy = "categoryproduct")
//	@ManyToMany(cascade = CascadeType.ALL)
//	@JoinTable(
//			name = "category_pd",
//			joinColumns = @JoinColumn(name="id_category_pd"),
//			inverseJoinColumns = @JoinColumn(name="id_product"))
	private Set<Product> categoryProduct = new HashSet<>(); 
	
	public Set<Product> getCategoryProduct() {
		return categoryProduct;
	}
	

	public void setCategoryProduct(Set<Product> categoryProduct) {
		this.categoryProduct = categoryProduct;
	}


	public String getTitle() {
		return title;
	}


	public void setTitle(String title) {
		this.title = title;
	}
	
	public void addProduct(Product product) {
		this.categoryProduct.add(product);
	}


	
}
