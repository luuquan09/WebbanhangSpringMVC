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

@Entity
@Table(name ="district")
public class District {

	@Id
	@Column(name ="id_district")
	private int id;
	@Column(name ="name")
	private String name;
	@Column(name = "prefix")
	private String prefix;
	

	@Column(name ="id_provice")
	private int provinceid;

	
	@OneToMany(mappedBy = "district", cascade = CascadeType.ALL)
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
	

}
