package BEAN;

public class KnapsackPackageResult {
	private double weight;
	private double value;
	private String namething;
	private int SLsp;
	
	public KnapsackPackageResult (double weight, double value,String namething, int SLsp) {
		super();
		this.namething=namething;
		this.weight = weight;
		this.value = value;	
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

	public int getSLsp() {
		return SLsp;
	}
	
}
