package test;

import java.util.Scanner;

import bean.Student;
import controller.StudentController;
import controller.StudentOperationController;
import dao.StudentDao;
import db.DbConnection;

public class StudentManagementSystem 
{
	public static void main(String[] args)
	{
		Scanner sc = new Scanner(System.in);
		DbConnection db= new DbConnection();
		StudentController sct = new StudentController();
		StudentOperationController soc = new StudentOperationController();
		Student s= new Student();
		db.getConnection();
		
		boolean loop=true;
		while(true)
		{
			System.out.println("\nStudent Management System \n1.Add Student Details \n2.Remove Student Details \n3.Update Stduent Details \n4.Show Student Details "
					+ "\n5.Show All Student Details \n"
					+ "\nOperation \n6.Display the Rank Based Report of All Students \n7.Display Average Marks of each Subject"
					+ "\n8.Name of the student who have higher marks than average \n9.Top Scorer of the Subject \n10.Academic Details "
					+ "\n11.Subject count of Highest Marks");
			int choice;
			choice=sc.nextInt();
			switch(choice)
			{
				case 1:
				{
					System.out.println("Enter the Name");
					s.setStud_name(sc.next());
					System.out.println("Enter the marks in English");
					s.setEnglish_marks(sc.nextInt());
					System.out.println("Enter the marks in Hindi");
					s.setHindi_marks(sc.nextInt());
					System.out.println("Enter the marks in Maths");
					s.setMaths_marks(sc.nextInt());
					System.out.println("Enter the marks in Science");
					s.setScience_marks(sc.nextInt());
					System.out.println("Enter the marks in Social Science");
					s.setSocialscience_marks(sc.nextInt());
					s.setTotal_marks(s.getEnglish_marks()+s.getHindi_marks()+s.getMaths_marks()+s.getScience_marks()+s.getSocialscience_marks());
					sct.add(s);
					break;
					
				}
				case 2:
				{
					System.out.println("Enter the Roll Number");
					s.setId(sc.nextInt());
					sct.remove(s.getId());
					break;
				}
				case 3:
				{
					System.out.println("Enter the Roll Number");
					s.setId(sc.nextInt());
					System.out.println("Enter the Name");
					s.setStud_name(sc.next());
					System.out.println("Enter the marks in English");
					s.setEnglish_marks(sc.nextInt());
					System.out.println("Enter the marks in Hindi");
					s.setHindi_marks(sc.nextInt());
					System.out.println("Enter the marks in Maths");
					s.setMaths_marks(sc.nextInt());
					System.out.println("Enter the marks in Science");
					s.setScience_marks(sc.nextInt());
					System.out.println("Enter the marks in Social Science");
					s.setSocialscience_marks(sc.nextInt());
					s.setTotal_marks(s.getEnglish_marks()+s.getHindi_marks()+s.getMaths_marks()+s.getScience_marks()+s.getSocialscience_marks());				
					sct.update(s);	
					break;
					
				}
				case 4:
				{
					System.out.println("Enter the Roll Number");
					s.setId(sc.nextInt());
					s=sct.getStudent(s.getId());
					System.out.println("Roll Number: "+s.getId());
					System.out.println("Name: "+s.getStud_name());
					System.out.println("English Marks: "+s.getEnglish_marks());
					System.out.println("Hindi Marks: "+s.getHindi_marks());
					System.out.println("Maths Marks: "+s.getMaths_marks());
					System.out.println("Science Marks: "+s.getScience_marks());
					System.out.println("Social Science: "+s.getSocialscience_marks());
					System.out.println("Total Marks: "+s.getTotal_marks());
					break;
				}
				case 5:
				{
						for(Student ss: sct.getStudents())
						{
							
							System.out.println("\nRoll Number: "+ss.getId());
							System.out.println("Name: "+ss.getStud_name());
							System.out.println("English Marks: "+ss.getEnglish_marks());
							System.out.println("Hindi Marks: "+ss.getHindi_marks());
							System.out.println("Maths Marks: "+ss.getMaths_marks());
							System.out.println("Science Marks: "+ss.getScience_marks());
							System.out.println("Social Science: "+ss.getSocialscience_marks());
							System.out.println("Total Marks: "+ss.getTotal_marks());
							
						}
						break;
					
				}
				case 6:
				{
					int count=1;
					for(Student st : soc.display_Rankbased())
					{
						System.out.println("\nRank"+st.getRank());
						System.out.println("Roll Number: "+st.getId());
						System.out.println("Name: "+st.getStud_name());
						System.out.println("English Marks: "+st.getEnglish_marks());
						System.out.println("Hindi Marks: "+st.getHindi_marks());
						System.out.println("Maths Marks: "+st.getMaths_marks());
						System.out.println("Science Marks: "+st.getScience_marks());
						System.out.println("Social Science: "+st.getSocialscience_marks());
						System.out.println("Total Marks: "+st.getTotal_marks());
						count++;
						
					}
					break;
				}
				case 7:
				{	
					soc.average_Mark();
					break;
				}
				case 8:
				{
					soc.display_HigherAverage();
					break;
				}
				case 9:
				{
					System.out.println("\nTop Scorer of the Subjects");
					soc.top_scorer();
					break;
				}
				case 10:
				{
					
					soc.academic_Details();
					break;
				}
				case 11:
				{
					soc.subjectcount_HigherMarks();
					break;
				}
				
			}
			
		}
	}
}
