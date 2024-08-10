package org.ModuleForAll;
import java.sql.*;
import java.util.*;
import java.sql.*;

public class DBConfig {
	
		protected Connection n;
		protected PreparedStatement stmt;
		   public ResultSet rs;
		
		public DBConfig() {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
		 n=DriverManager.getConnection("jdbc:mysql://localhost:3306/examproject","root","root");
} catch (Exception e) {
			
		System.out.println(e);
		}
		 
		 
		if(n!=null)
		{
			System.out.println("Connection created");
		}else
		{
			System.out.println("some problem at connection");
		}
		
		}	
	

}
