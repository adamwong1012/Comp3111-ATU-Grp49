package Lab7.ATU_Process;

public class Team {
	private int id;
	private double k1_average;
	private double k2_average;
	private Student students[] = new Student[4];
	private int student_no;
	
	public Team(int id) {
		this.id = id;
		k1_average = 0;
		k2_average = 0;
		student_no = 0;
	}
	
	public void addStudent(Student student) {
		students[student_no++] = student;
		k1_average = (k1_average * (student_no-1) + 
student.getK1()) / student_no;
		k2_average = (k2_average * (student_no-1) + 
student.getK2()) / student_no;
	}
	
	public int getID() { return id; }
	public double getK1() { return k1_average; }
	public double getK2() { return k2_average; }
	public int getStudentNo () { return student_no; }
	
}

