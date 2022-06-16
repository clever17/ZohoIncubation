package dao;

import java.util.List;

import bean.Student;

public interface StudentDao 
{
	public void add(Student s);
	public void remove(int id);
	public void update(Student s);
	public Student getStudent(int id);
	public List<Student> getStudents();
	
}
