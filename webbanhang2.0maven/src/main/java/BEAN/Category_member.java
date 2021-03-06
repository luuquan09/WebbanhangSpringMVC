package BEAN;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity
public class Category_member{

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "category_mb_id")
	private int id;
	
	private String name;	
	
	@OneToMany(mappedBy = "categorymb", cascade = CascadeType.ALL)
	private Set<Mber> member = new HashSet<>();
	
	public Category_member() {
		
	}

	public Category_member(String name) {		
		this.name = name;
	}
	
	public void addMember(Mber mber) {
		this.member.add(mber);
	}

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


	
}
