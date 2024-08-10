package org.services;
import java.util.*;


//import java.sql.Date.*;

import java.sql.SQLException;
import java.util.*;

import org.ModuleForAll.ExamModule;
import org.ModuleForAll.ExamSchedule;
import org.client.ExamClientApplication;
import org.repository.ExamRepo;

public class ExamServices {

	ExamRepo er =new ExamRepo();
	public int addExam(ExamModule eModule)
	{
		System.out.println( eModule.getTotalMarks()+"total");
		System.out.println(eModule.getPassingMarks()+"passing ");
		
		//return er.isAddExam(eModule)?1:0;
		if(er.isAddExam(eModule))
		{
			return 1;
		}else if(er.isExamPresent())
		{
			return -1;
		}else
		{
			return 0;
		}
	}

	public List examData()
	{
		
		List <ExamModule> list=new ArrayList <ExamModule>();
		
//	list =er.examData();
//	
//	if(list!=null)
//	{
//		return list;
//	}else
//	{
//		return null;
//	}
//		
	return er.examData() ;
		
		
	}
	
	public int ScheduleWithSubject()
	{
		
		
		return 1;
	}

	
	public int  getExamIdByExamName(String name)  //call schedule for examid
	{
		int examid;
		 List<ExamModule> s=er.examData();
		 
		 for(ExamModule m:s)
		 {
			 if(m.getExamName().equalsIgnoreCase(name))
			 {
				 examid=m.getExamId();
				 return examid;
			 }else
			 {
				 return -1;
			 }
		 }
		
		return 0;
	}
	
	

	public int addExamShedule(ExamModule mm,String name)
	{
		Scanner sc=new Scanner(System.in);
		ExamSchedule s=mm.getExamSchedule();
		
		String d1=s.getDate().toLocaleString();
		Date hh=(Date) new java.util.Date();
		System.out.println("Enter subject name");
		String subname=sc.nextLine();
		
		
	return (er.isAddExamSchedule(mm,subname,hh)?1:-1);
		
		
	
		
		
	}
	
	
}
