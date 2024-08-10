package org.services;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import org.ModuleForAll.ExamModule;
import org.ModuleForAll.ExamSchedule;
import org.ModuleForAll.QuestionModule;
import org.ModuleForAll.StudentModule;
import org.repository.QuestionRepository;
import org.repository.StudentRepo;
import org.repository.SubjectRepository;

public class StudentServices {
	String u2;
StudentRepo sr=new StudentRepo();
	StudentModule stm;
	
	public int addStudent(StudentModule Smodule )
	{
		//stm=Smodule;
		return sr.isAddStudent(Smodule)?1:0;
		
	}
	
	
	
	
	
	// for case 7 verify user...........................
	ArrayList<StudentModule> ar;
	public int getUserNamePassword(String username,String password)
	{
		u2=username;
		//StudentRepo sr=new StudentRepo();
		try {
			
		// list username password retun to client 
		 ar =sr.isGetUserNamePassword();
		

		
		int flag=0;
		for(StudentModule sm:ar)
		{
			if(sm.getUsername().equalsIgnoreCase(username)&& sm.getPassword().equalsIgnoreCase(password))
			{
				System.out.println("true......");
				flag=1;
				break;
			}
			else {
				System.out.println("false............");
			}
		}
		if(flag==1)
		{
			return 1;
		}else
		{
			return -1;
		}
		
		}catch(Exception e)
		{
			
			System.out.println(e);
           return -1;
		}
		
	}
	
	//....................for join student subject table................................
	
	
	
	
	public int studentSubJoin(String name,String sub)
	{
	Scanner sc=new Scanner(System.in);	

		StudentRepo sr=new StudentRepo();
		int stid=sr.getSidByName(name);
		System.out.println(stid+" "+ "student id ");
		
	QuestionRepository qr=new QuestionRepository();
	
	int n=qr.getSubjectIdByName(sub);
	System.out.println("Subject id is "+n);
	
	
	return sr.isStudentSubJoin(stid,n)?1:-1;

	
		//return 1;
	
	}
	
	
	public Object[] getStudentScheduleS(String name )
	{
		
		int stid2=sr.getSidByName(name );
		 List<Object> ex;
		try {
			
			Object obj[]= sr.isGetgetStudentScheduleS(stid2 );
			 return obj;
		} catch (SQLException e) {
			System.out.println(e);
			return null;
		}	
	}
	
	
	public List getStudetnQuestion(String username)
	{
		
		List<QuestionModule> qList =  sr.isGetExamQuestionPaper(username);
		
		if(qList!=null)
		{
			return qList;
			
		}else
		{
			return null;
		}
		
	}
	
	
}
