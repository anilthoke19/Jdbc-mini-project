package org.repository;
import org.ModuleForAll.*;
import org.services.*;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class SubjectRepository extends DBConfig {
	 static int value;
	 ArrayList<String> list=new ArrayList<>();

	public boolean isAddSubject(SubjectInfo module)
	{
		
		
		try {
			stmt=n.prepareStatement("insert into subject values('0',?) ");
			 stmt.setString(1,module.getName());
			 return stmt.executeUpdate()>0?true:false;
			
		} catch (SQLException e) {
			//System.out.println("at subject repositiory");

			return false;
		}
		
		
	
	}
	public boolean ischeckrepSubject(String name )
	{
		
		try {
			stmt=n.prepareStatement("select*from subject where subjectName=?");
			stmt.setString(1,name);
			
			rs=stmt.executeQuery();
			return rs.next();
		} catch (SQLException e) {
			return false;			
}	
	}

	
	public List<String> getAllSubjects()
	{

		try {
			stmt=n.prepareStatement("select subjectName from subject");
		rs=stmt.executeQuery();
	
		
		while(rs.next())
		{
			list.add(rs.getString(1));
		}
		return list.size()>0?list:null;
			
		}catch(Exception e)
		{
			System.out.println("At subject repo");
			return null;
		}
		
	}


}
