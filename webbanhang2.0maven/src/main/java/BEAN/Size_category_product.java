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
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name ="size_category_product")
public class Size_category_product {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id_size")
	private int id;
		
	private String size;
	
	@ManyToOne
	@JoinColumn(name ="id_product")
	private Product product_size;

	public Size_category_product(String size, Product product_size) {
		
		this.size = size;
		this.product_size = product_size;
	}

	public Size_category_product() {

	}

	public String getNameSize() {
		return size;
	}

	public void setSize(String size) {
		this.size = size;
	}
	
	

	
	
}
