package Lab7.ATU_Process;

public class Student {
	private String id;
	private int k1_energy;
	private int k2_energy;
	
	public Student() {
		id = "0";
		k1_energy = 0;
		k2_energy = 0;
	}
	
	public Student(String id, int k1_energy, int k2_energy) {
		this.id = id;
		this.k1_energy = k1_energy;
		this.k2_energy = k2_energy;
	}
	
	public String getID() { return id; }
	public int getK1() { return k1_energy; }
	public int getK2() { return k2_energy; }
	
}

