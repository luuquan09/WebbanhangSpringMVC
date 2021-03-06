package BEAN;

public class KnapConsole {
	private double weight;
	private double value;
	private Double cost;
	private String namething;
	private int SLsp;
	
	public KnapConsole(double weight, double value,String namething, int SLsp) {
		super();
		this.namething=namething;
		this.weight = weight;
		this.value = value;
		this.cost = new Double(value / weight);
		this.SLsp=SLsp;
	}
	public String getnamething() {
		return namething;
	}
	public double getWeight() {
		return weight;
	}

	public double getValue() {
		return value;
	}

	public Double getCost() {
		return cost;
	}
	public int getSLsp() {
		return SLsp;
	}
	public void setSLsp(int sLsp) {
		SLsp = sLsp;
	}
}
