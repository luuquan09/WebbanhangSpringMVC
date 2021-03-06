package BEAN;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "order_item")
public class Order_item {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name ="id_order_item")
	private int id;
		
	@ManyToOne
	@JoinColumn(name = "id_order")
	private Order orderitem;
	
	@ManyToOne
	@JoinColumn(name = "id_product")
	private Product orderitemproduct;
	
	private int quantity;
	private String size;
	private float total;
	
	
	public Order_item() {
		
	}


	public Order_item(Order orderitem, Product orderitemproduct, int quantity, String size, float total) {
		this.orderitem = orderitem;
		this.orderitemproduct = orderitemproduct;
		this.quantity = quantity;
		this.size = size;
		this.total = total;
	}


	public int getId() {
		return id;
	}


	public void setId(int id) {
		this.id = id;
	}


	public Order getOrderitem() {
		return orderitem;
	}


	public void setOrderitem(Order orderitem) {
		this.orderitem = orderitem;
	}


	public Product getOrderitemproduct() {
		return orderitemproduct;
	}


	public void setOrderitemproduct(Product orderitemproduct) {
		this.orderitemproduct = orderitemproduct;
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


	public float getTotal() {
		return total;
	}


	public void setTotal(float total) {
		this.total = total;
	}


	@Override
	public String toString() {
		return "Order_item [id=" + id + ", quantity=" + quantity + ", size=" + size + ", total=" + total + "]";
	}

	
	
}
