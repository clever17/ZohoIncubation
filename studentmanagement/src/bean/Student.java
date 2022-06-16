package bean;

public class Student 
{
	private int rank;
	private int id;
	private String stud_name;
	
	private int english_marks;
	private int hindi_marks;
	private int maths_marks;
	private int science_marks;
	private int socialscience_marks;
	private int total_marks;
	
	public Student() {
	
	}

	public int getId() 
	{
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getStud_name() {
		return stud_name;
	}

	public void setStud_name(String stud_name) {
		this.stud_name = stud_name;
	}

	public int getEnglish_marks() {
		return english_marks;
	}

	public void setEnglish_marks(int english_marks) {
		this.english_marks = english_marks;
	}

	public int getHindi_marks() {
		return hindi_marks;
	}

	public void setHindi_marks(int hindi_marks) {
		this.hindi_marks = hindi_marks;
	}

	public int getMaths_marks() {
		return maths_marks;
	}

	public void setMaths_marks(int maths_marks) {
		this.maths_marks = maths_marks;
	}

	public int getScience_marks() {
		return science_marks;
	}

	public void setScience_marks(int science_marks) {
		this.science_marks = science_marks;
	}

	public int getSocialscience_marks() {
		return socialscience_marks;
	}

	public void setSocialscience_marks(int socialscience_marks) {
		this.socialscience_marks = socialscience_marks;
	}

	public int getTotal_marks() {
		return total_marks;
	}

	public void setTotal_marks(int total_marks) {
		this.total_marks = total_marks;
	}
	public int getRank() {
		return rank;
	}

	public void setRank(int rank) {
		this.rank = rank;
	}

	
}
