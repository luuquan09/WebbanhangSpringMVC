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
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import AddressBEAN.District;
import AddressBEAN.Province;
import AddressBEAN.Ward;

@Entity
@Table(name ="address")
public class Address {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name ="idaddress")
	private int id;
	private String nameaddress;

	
	
	
	@OneToMany(mappedBy = "address", cascade = CascadeType.ALL)
	private Set<Mber> Mberaddress = new HashSet<>();
	
	
	@ManyToOne
	@JoinColumn(name ="id_ward")
	private Ward ward;
	
	@ManyToOne
	@JoinColumn(name ="id_pro")
	private Province province;
	
	@ManyToOne
	@JoinColumn(name ="id_district")
	private District district;
	
	
	public Address() {
	
	}

	
	public Address(String nameaddress, Ward ward, Province province, District district) {
		
		this.nameaddress = nameaddress;
		this.ward = ward;
		this.province = province;
		this.district = district;
	}


	public int getId() {
		return id;
	}


	public void setId(int id) {
		this.id = id;
	}


	public String getNameaddress() {
		return nameaddress;
	}

	public void setNameaddress(String nameaddress) {
		this.nameaddress = nameaddress;
	}

	public Set<Mber> getMberaddress() {
		return Mberaddress;
	}

	public void setMberaddress(Set<Mber> mberaddress) {
		Mberaddress = mberaddress;
	}


	public Ward getWard() {
		return ward;
	}

	public void setWard(Ward ward) {
		this.ward = ward;
	}

	public Province getProvince() {
		return province;
	}

	public void setProvince(Province province) {
		this.province = province;
	}

	public District getDistrict() {
		return district;
	}

	public void setDistrict(District district) {
		this.district = district;
	}


	@Override
	public String toString() {
		return "Address [id=" + id + ", nameaddress=" + nameaddress + ", ward=" + ward + ", province=" + province
				+ ", district=" + district + "]";
	}
	

	




	
	
}
