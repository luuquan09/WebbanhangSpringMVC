package BEAN;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "cart")
public class Cart {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name ="id_cart")
	private int id;
	
	@ManyToOne
	@JoinColumn(name ="id_member")
	private Mber member;
	
	@OneToMany(mappedBy = "cart", cascade = CascadeType.ALL)
	private List<Cartitems> cart_item = new ArrayList<>();
	
	private int session_id;
	
	private String status;
	private String email;
	private Date createat;
	private Date updateat;
	private String content;
	
	public Cart(Mber member, int session_id, String status, String email, Date createat, Date updateat,
			String content) {
		//super();
		this.member = member;
		this.session_id = session_id;
		this.status = status;
		this.email = email;
		this.createat = createat;
		this.updateat = updateat;
		this.content = content;
	}
	public List<Cartitems> getCart_item() {
		return cart_item;
	}

	public void setCart_item(List<Cartitems> cart_item) {
		this.cart_item = cart_item;
	}



	public void addCartitem(Cartitems cartitems) {
		this.cart_item.add(cartitems);
	}


}
