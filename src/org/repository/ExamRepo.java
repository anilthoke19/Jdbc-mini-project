package org.repository;
import java.util.*;

import org.ModuleForAll.DBConfig;
import org.ModuleForAll.ExamModule;
import org.ModuleForAll.ExamSchedule;
import java.sql.*;
import java.sql.Date;
public class ExamRepo extends DBConfig{
	
	ExamModule Emodule2;
	public boolean isAddExam(ExamModule Emodule)
	{
		Emodule2=Emodule;
	try {
		stmt=n.prepareStatement("insert into exam values(?,?,?,?)");
		stmt.setInt(1, Emodule2.getExamId());
		stmt.setString(2, Emodule2.getExamName());
		stmt.setInt(3, Emodule2.getTotalMarks());
		stmt.setInt(4, Emodule2.getPassingMarks());
		
		return stmt.executeUpdate()>0?true:false;
		
		
		
	} catch (SQLException e) {
		System.out.println("at exam Repo"+e);
		return false;
	}	
	}
	
	
	public boolean  isExamPresent()
	{
		
		try {
			stmt=n.prepareCall("select examName from exam where examName=?");
			stmt.setString(1, Emodule2.getExamName());
			rs=stmt.executeQuery();	
		return (rs.next())?true:false;
		
		} catch (SQLException e) {
			
			System.out.println("exception at ExamRepo"+e); 
			return false;	
		}
	}
	
	public List<ExamModule> list=new ArrayList<ExamModule >();
	 
	public List examData()
	{
		try {
			stmt=n.prepareStatement("select*from exam");
			rs=stmt.executeQuery();
			
			while(rs.next())
			{
				 ExamModule mlist=new ExamModule();

				mlist.setExamId(rs.getInt(1));
				mlist.setExamName(rs.getString(2));
				mlist.setPassingMarks(rs.getInt(3));
				mlist.setTotalMarks(rs.getInt(4));
				list.add(mlist);
				
			}		
			return list.size()>0?list:null;
			
		} catch (SQLException e) {
			System.out.println("at examRepo "+e);
			return null;
		}
		
		
	}

	public int getExamID()
	{
		int examId=0;
		
		try {
			stmt=n.prepareStatement("select max(examId) from exam");
			rs=stmt.executeQuery();
			
			if(rs.next())
			{
				examId=rs.getInt(examId);
			}else {
				return -1;
			}
			return examId++;
			
		} catch (SQLException e) {
			System.out.println(e);
		}
		
		return 1;
		
	}
	
	
	

	public boolean isAddExamSchedule(ExamModule mm, String name,java.util.Date hh) {
		ExamSchedule ex= mm.getExamSchedule();
		QuestionRepository qr=new QuestionRepository();
		int subid=qr.getSubjectIdByName(name);
		int examIId=this.getExamID();
				
			String d2=hh.toLocaleString();
			System.out.println("System date"+d2);
			
			
			String s1[]=d2.split(",");
			String s2[]=d2.split(",");
			
		
			String s11[]=s1[0].split(" "); //month  day
			String s22[]=s2[0].split(" ");
			
		
			  System.out.println(s22[0]+" "+s22[1]);

		
			int month[]=new int[] {0,1,2,3,4,5,6,7,8,9,10,11};
			
		
			
			int m=0;
			switch(s11[0])
			{
			case "Jan":
				m=0;
				break;
				
			case "Feb":
				m=1;
				break;
				
			case "Mar":
				m=2;
				break;
				
			case "Apr":
				m=3;
				break;
				
			case "May":
				m=4;
				break;
				
				
			case "June":
				m=5;
				break;

			case "July":
				m=6;
				break;

			case "Aug":
				m=7;
				break;

			case "Sep":
				m=8;
				break;

			case "Oct":
				m=9;
				break;

			case "Nov":
				m=10;
				break;

			case "Dec":
				m=11;
				break;
				default:
					
					System.out.println("month not valid");

			}
			
		

			if(Integer.parseInt(s11[1])>=Integer.parseInt (s22[1])&& (s11[0]).equalsIgnoreCase( s22[0])&& Integer.parseInt(s1[1].trim())>=Integer.parseInt(s2[1].trim()));
			{
				System.out.println("Time is correct ");
				
				// store here value in data base;
try {
	System.out.println("Sub id"+subid);
				Date td=new Date(Integer.parseInt(s11[1]), m+1480, Integer.parseInt(s11[1]));
				stmt=n.prepareStatement("insert into schedule values('0',?,?,?,?,?)");
						{
							ExamSchedule m2=mm.getExamSchedule();
							System.out.println("The Exam id is "+m2.getExamId());
							System.out.println("The Exam id is by examModule "+mm.getExamId());

					//stmt.setInt(1,);
					stmt.setInt(1,m2.getExamId());
					stmt.setDate(2,td);
					stmt.setString(3,ex.getStartTime());
					stmt.setString(4, ex.getEndTime());
					stmt.setInt(5,subid);
						}
						
						int v=stmt.executeUpdate();
						if(v>0)
						{
							return true;
						}else
						{
							return false;
						}
			
}catch(Exception e)
{
	System.out.println(e);
}
				
				
			}
		return false;
		
		
	}
	
	


}
