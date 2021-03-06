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

import DAO.MemberDAO;

@Entity
@Table(name ="`member`")
public class Mber {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id_member")
	private int id;
	@Column(name ="firstname")
	private String firstname;
	@Column(name = "name")
	private String namemember;
	private String email;
	private String password;
	private boolean sex;
	private String phone;
	private Date createat;
	
	
	@ManyToOne
	@JoinColumn(name ="category_mb_id")
	private Category_member categorymb;
	
	@OneToMany(mappedBy = "id_image_mb", cascade = CascadeType.ALL)
	private Set<imagemember> img = new HashSet<>();
	
	
//	@OneToMany(mappedBy = "mberaddress", cascade = CascadeType.ALL)
//	private List<Address> address = new ArrayList<>();
	
	@ManyToOne
	@JoinColumn(name ="idaddress")
	private Address address;
	
	
	@OneToMany(mappedBy = "memberoder", cascade = CascadeType.ALL)
	private List<Order> oder = new ArrayList<>();
	
	
	public Mber() {
		
	}
	public Mber(String firstname,String name, String email, String password, boolean sex, String phone, Date createat) {	
		this.firstname = firstname;
		this.namemember = name;
		this.email = email;
		this.password = password;
		this.sex = sex;
		this.phone = phone;
		this.createat = createat;
		
	}
	
	
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}

	public String getFirstname() {
		return firstname;
	}
	public void setFirstname(String firstname) {
		this.firstname = firstname;
	}
	public String getNamemember() {
		return namemember;
	}
	public void setNamemember(String namemember) {
		this.namemember = namemember;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public boolean isSex() {
		return sex;
	}
	public void setSex(boolean sex) {
		this.sex = sex;
	}

	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	public Date getCreateat() {
		return createat;
	}
	public void setCreateat(Date createat) {
		this.createat = createat;
	}
	public Category_member getCategorymb() {
		return categorymb;
	}
	public void setCategorymb(Category_member categorymb) {
		this.categorymb = categorymb;
	}	
	

	public void addImage(imagemember img) {
		this.img.add(img);
	}
	
	public Address getAddress() {
		return address;
	}
	public void setAddress(Address address) {
		this.address = address;
	}
	@Override
	public String toString() {
		return "Mber [id=" + id + ", namemember=" + namemember + ", email=" + email + ", password=" + password
				+ ", sex=" + sex + ", address=" + address + ", phone=" + phone + ", createat=" + createat
				+ ", categorymb=" + categorymb + ", img=" + img + "]";
	}
	
}
