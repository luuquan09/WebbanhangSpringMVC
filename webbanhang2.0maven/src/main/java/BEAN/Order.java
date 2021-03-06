package BEAN;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

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
@Table (name ="`order`")
public class Order {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name ="id_order")
	private int id;
	private float total;
	private float shipcost;
	private float discount;
	private Date createat;
	private Date updateat;
	private int numberproduct;
	private String firstname;
	private String name;
	private String email;
	private String phone;
	private String note;
	@ManyToOne
	@JoinColumn(name ="id_member")
	private Mber memberoder;
	
	@ManyToOne
	@JoinColumn(name ="idaddress")
	private Address address;
	
	@OneToMany(mappedBy = "orderitem", cascade = CascadeType.ALL)
	private List<Order_item> oder_item = new ArrayList<>();

	public Order(float total, int numberproduct, Mber memberoder) {
		
		this.total = total;
		this.numberproduct = numberproduct;
		this.memberoder = memberoder;
	}

	public Order() {
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Date getUpdateat() {
		return updateat;
	}

	public void setUpdateat(Date updateat) {
		this.updateat = updateat;
	}

	public String getFirstname() {
		return firstname;
	}

	public void setFirstname(String firstname) {
		this.firstname = firstname;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public void setShipcost(float shipcost) {
		this.shipcost = shipcost;
	}

	public float getTotal() {
		return total;
	}

	public void setTotal(float total) {
		this.total = total;
	}

	public float getShipcost() {
		return shipcost;
	}


	public float getDiscount() {
		return discount;
	}

	public void setDiscount(float discount) {
		this.discount = discount;
	}

	public Date getCreateat() {
		return createat;
	}

	public void setCreateat(Date createat) {
		this.createat = createat;
	}

	public Date getUpdateeat() {
		return updateat;
	}

	public void setUpdateeat(Date updateeat) {
		this.updateat = updateeat;
	}

	public int getNumberproduct() {
		return numberproduct;
	}

	public void setNumberproduct(int numberproduct) {
		this.numberproduct = numberproduct;
	}

	public String getNote() {
		return note;
	}

	public void setNote(String note) {
		this.note = note;
	}

	public Mber getMemberoder() {
		return memberoder;
	}

	public void setMemberoder(Mber memberoder) {
		this.memberoder = memberoder;
	}

	public Address getAddress() {
		return address;
	}

	public void setAddress(Address address) {
		this.address = address;
	}

	public List<Order_item> getOder_item() {
		return oder_item;
	}

	public void setOder_item(List<Order_item> oder_item) {
		this.oder_item = oder_item;
	}
	
	public void addOrder_item(Order_item order_item) {
		this.oder_item.add(order_item);
	}

	@Override
	public String toString() {
		return "Order [id=" + id + ", total=" + total + ", shipcost=" + shipcost + ", discount=" + discount
				+ ", createat=" + createat + ", updateat=" + updateat + ", numberproduct=" + numberproduct
				+ ", firstname=" + firstname + ", name=" + name + ", email=" + email + ", phone=" + phone + ", note="
				+ note + ", memberoder=" + memberoder.getNamemember() + ", address=" + address.getNameaddress() + "]";
	}

	
	
	
	
	
	
}
