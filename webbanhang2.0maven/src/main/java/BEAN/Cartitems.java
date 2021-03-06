package BEAN;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "cart_item")
public class Cartitems {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name ="id_cart_item")
	private int id;
	
	@ManyToOne
	@JoinColumn(name ="id_product")
	private Product productitem;
	
	@ManyToOne
	@JoinColumn(name ="id_cart")
	private Cart cart;
	
	private int quantity;
	
	private String size;

	
	public Cartitems() {
		
	}

	public Cartitems(Product productitem, int quantity, String size) {		
		this.productitem = productitem;
		this.quantity = quantity;
		this.size = size;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Product getProductitem() {
		return productitem;
	}

	public void setProductitem(Product productitem) {
		this.productitem = productitem;
	}

	public Cart getCart() {
		return cart;
	}

	public void setCart(Cart cart) {
		this.cart = cart;
	}

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	public String getSize() {
		return size;
	}

	public void setSize(String size) {
		this.size = size;
	}
	

	
	
	
	
}
