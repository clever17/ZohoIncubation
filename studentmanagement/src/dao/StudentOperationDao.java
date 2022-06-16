package dao;

import java.util.List;

import bean.Student;

public interface StudentOperationDao 
{
	public List<Student> display_Rankbased();
	public void average_Mark();
	public void display_HigherAverage();
	public void top_scorer();
	public void academic_Details();
	public void subjectcount_HigherMarks();
}
