package BEAN;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name ="discount")
public class Discount {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="id_discount")
	private int id;
	@Column(name ="madiscount")
	private String madiscount;
	@Column(name ="name")
	private String name;
	private float cost;
	private Date startday;
	private Date endday;
	private boolean efficiency;
	
	public Discount() {
		
	}

	public Discount(String madiscount, String name,float cost, Date startday, boolean efficiency) {
		this.madiscount = madiscount;
		this.name = name;
		this.cost = cost;
		this.startday = startday;
		this.efficiency = efficiency;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getMadiscount() {
		return madiscount;
	}

	public void setMadiscount(String madiscount) {
		this.madiscount = madiscount;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public float getCost() {
		return cost;
	}

	public void setCost(float cost) {
		this.cost = cost;
	}

	public Date getStartday() {
		return startday;
	}

	public void setStartday(Date startday) {
		this.startday = startday;
	}

	public Date getEndday() {
		return endday;
	}

	public void setEndday(Date enday) {
		this.endday = enday;
	}

	public boolean isEfficiency() {
		return efficiency;
	}

	public void setEfficiency(boolean efficiency) {
		this.efficiency = efficiency;
	}

	
}
