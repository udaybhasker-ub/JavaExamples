
class Student implements Comparable<Student> {
	private String name;
	private int grade;
	private String standard;

	public Student(String name, String standard, int grade) {
		this.name = name;
		this.grade = grade;
		this.standard = standard;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getGrade() {
		return grade;
	}

	public void setGrade(int grade) {
		this.grade = grade;
	}

	public String getStandard() {
		return standard;
	}

	public void setStandard(String standard) {
		this.standard = standard;
	}

	// Compared by grade using comparable interface
	@Override
	public int compareTo(Student o) {
		return this.grade - o.grade;
	}

	@Override
	public String toString() {
		return name + "	" + standard + "		" + grade;
	}
}