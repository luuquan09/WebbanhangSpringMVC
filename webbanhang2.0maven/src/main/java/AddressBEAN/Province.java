package AddressBEAN;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import BEAN.Address;

@Entity
@Table(name ="province")
public class Province {

	@Id
	@Column(name ="id_province")
	private int id;
	@Column(name ="name")
	private String name;
	@Column(name ="code")
	private String code;
	
	@OneToMany(mappedBy = "province", cascade = CascadeType.ALL)
	private Set<Address> address = new HashSet<>();
	
	
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getCode() {
		return code;
	}
	public void setCode(String code) {
		this.code = code;
	}
	@Override
	public String toString() {
		return "Province [id=" + id + ", name=" + name + ", code=" + code + "]";
	}
	
//	@OneToMany(mappedBy = "provincedistrict", cascade = CascadeType.ALL)
//	private Set<District> district = new HashSet<>();
//
//	@OneToMany(mappedBy = "provinceward", cascade = CascadeType.ALL)
//	private Set<Ward> ward = new HashSet<>();

	
	
}
