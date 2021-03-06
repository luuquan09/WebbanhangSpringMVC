package AddressBEAN;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import BEAN.Address;
import BEAN.Category_member;
import BEAN.imagemember;

@Entity
@Table(name = "ward")
public class Ward {

	@Id
	@Column(name ="id_ward")
	private int id;
	@Column(name ="name")
	private String name;
	@Column(name ="prefix")
	private String prefix;
	

	@Column(name ="id_province")
	private int provinceid;

	@Column(name ="id_district")
	private int districtid;


	@OneToMany(mappedBy = "ward", cascade = CascadeType.ALL)
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

	public String getPrefix() {
		return prefix;
	}

	public void setPrefix(String prefix) {
		this.prefix = prefix;
	}

	public int getProvinceid() {
		return provinceid;
	}

	public void setProvinceid(int provinceid) {
		this.provinceid = provinceid;
	}

	public int getDistrictid() {
		return districtid;
	}

	public void setDistrictid(int districtid) {
		this.districtid = districtid;
	}
	
}
