  package org.repository;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import org.ModuleForAll.DBConfig;
import org.ModuleForAll.QuestionModule;

public class QuestionRepository extends DBConfig {
	int value;
	private int qusId2;
	
 
	
	
	public int getQuestionId() {
		
		try
		{
		    stmt= n.prepareStatement("select max(qid) from question");
			rs=stmt.executeQuery();
			 
			if(rs.next())
			{
				qusId2=rs.getInt(1);
			}
			
			++qusId2;
			
		}
		catch(Exception e)
		{
			System.out.println(e +"at getQuestion ");
			return 0;
		}
		return qusId2;
	}
	
	

	
	
	
	public boolean isAddQuestion(QuestionModule qmodel,String subName)
	{
try {
		int qid=this.getQuestionId();
		
		if(qid!=0) {
		
		
			stmt =n.prepareStatement("insert into question values('0',?,?,?,?,?,?)");
			
			stmt.setString(1, qmodel.getQuestion());
			stmt.setString(2,qmodel.getOpt1());
			stmt.setString(3,qmodel.getOpt2());
			stmt.setString(4,qmodel.getOpt3());
			stmt.setString(5,qmodel.getOpt4());
			stmt.setInt(6,qmodel.getAnswer());
			
		    value=stmt.executeUpdate();
			if(value>0)
			{
				
			int sid=this.getSubjectIdByName(subName);	
          	if(sid!=-1)
			{
			stmt=n.prepareStatement("insert into subjectquestionjoin values(?,?)");
			stmt.setInt(1,qusId2 );
			stmt.setInt(2, sid);
			
				return stmt.executeUpdate()>0?true:false;
			}else if(sid==-1)
			{
				System.out.println("Subject not found");
				return false;
			}
			else
			{ 
				System.out.println("some problem");
				return false;
			}
			
			}else
			{
				return false;
			}
			

		}else
		{
			return false; 
		}
		
		
		
}catch(Exception e)
{
	System.out.println("here"+e);
	return false;
}
		
	}
	
	
	public int getSubjectIdByName(String name)
	{
		try {
		
		stmt=n.prepareStatement("select *from subject where subjectName=?");
		stmt.setString(1, name);
		rs=stmt.executeQuery();
		
		if(rs.next())
		{
		return rs.getInt(1);	
			
		}else
		{
			return -1;
		}
		
		}catch(Exception e)
		{
		System.out.println(e +"subnm add");	
		return 0;
		}
	}
	
	
	public boolean addBulkQuestion(String nQuestion[],String subName)
	{
		
		
		try {
			int qid=this.getQuestionId();
			
			if(qid!=0) {
			

				stmt =n.prepareStatement("insert into question values(?,?,?,?,?,?,?)");
				

				stmt.setInt(1, qid);
				stmt.setString(2,nQuestion[0]);
				stmt.setString(3,nQuestion[1]);
				stmt.setString(4,nQuestion[2]);
				stmt.setString(5,nQuestion[3]);
				stmt.setString(6,nQuestion[4]);
				stmt.setInt(7,Integer.parseInt(nQuestion[5].trim()));
				
                int v=stmt.executeUpdate();
				if(v>0)
				{

				int sid=this.getSubjectIdByName(subName);	
	          	if(sid!=-1)
				{
				stmt=n.prepareStatement("insert into subjectquestionjoin values(?,?)");
				stmt.setInt(1,qusId2 );
				stmt.setInt(2, sid);
				
					return stmt.executeUpdate()>0?true:false;
				}else if(sid==-1)
				{
					System.out.println("Subject not found");
					return false;
				}
				else
				{ 
					System.out.println("some problem");
					return false;
				}
				
				}else
				{
					return false;
				}
				

			}else
			{
				return false; 
			}
			
			
			
	}catch(Exception e)
	{
		System.out.println("exception aat queston repo"+e);
		return false;
	}
		
		
		
		
		
		
		
		
		
	}
	
	
	

}
