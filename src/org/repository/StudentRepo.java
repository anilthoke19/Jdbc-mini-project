package org.repository;

import java.sql.Date;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.naming.ldap.StartTlsRequest;

import org.ModuleForAll.DBConfig;
import org.ModuleForAll.ExamSchedule;
import org.ModuleForAll.QuestionModule;
import org.ModuleForAll.StudentModule;

public class StudentRepo extends DBConfig{
List<Object> schList=new ArrayList<Object>();

	
	
	public boolean isAddStudent(StudentModule smodel)
	{
		
		
		
		try {
			stmt=n.prepareStatement("insert into student values(?,?,?,?,?,?)");
			
			stmt.setInt(1,smodel.getSid() );
			stmt.setString(2, smodel.getName());
			stmt.setString(3,smodel.getEmail());
			stmt.setString(4,smodel.getContact());
			stmt.setString(5, smodel.getUsername());
			stmt.setString(6, smodel.getPassword());
			
			return stmt.executeUpdate()>0?true:false;
			
			
	
		} catch (SQLException e) {
			
			System.out.println("at Student repo");
			return false;
		}
		
		
	}
	
	// for case 7
	
	
	public ArrayList<StudentModule> isGetUserNamePassword()
	{
		
		try {
			stmt=n.prepareStatement("select UserName ,Password from student ");
			ArrayList<StudentModule>ar=new ArrayList<StudentModule>();
			rs=stmt.executeQuery();
			
			while(rs.next())
			{
				StudentModule sm=new StudentModule();
	
			String Username=rs.getString("UserName");
			String password=rs.getString("Password");
			sm.setUsername(Username);
			sm.setPassword(password);
			
			ar.add(sm);
			//System.out.println("here in side repop"+sm.getUsername());

			
			}
			
			
			return ar.size()>0?ar:null;
			
			
		} catch (SQLException e) {
			
			System.out.println(e);
			return null;
			
		}
		
		
		
	}
	
	
	public int getSidByName(String name )
	{
		
		try {
			stmt=n.prepareStatement("select stid from student where name=?");
			stmt.setString(1, name);
			rs=stmt.executeQuery();
			
			if(rs.next()) {
				return rs.getInt(1);
			}else
			{
				return -1;
			}
			
			
		} catch (SQLException e) {
			
			System.out.println("At repo"+e);
			return -1;
		}
		
	
	}
	
	
	
	public boolean isStudentSubJoin(int stid,int subid)
	{
		
		try {
			
		stmt=n.prepareStatement("insert into studentsubjectjoin values(?,?)");
		stmt.setInt(1, stid);
		stmt.setInt(2, subid);
		
		return stmt.executeUpdate()>0?true:false;
		
		
		}catch(Exception e)
		{
			System.out.println(e );
			return false;
		}	
	}
	
	
	public Object[] isGetgetStudentScheduleS(int stid ) throws SQLException
	{
		
		//int stid=this.getSidByName(username);
		stmt=n.prepareStatement(" select distinct sbj.subjectName, sb.ExamId,sb.edate,sb.startTime,sb.EndTime,sb.Sid from  schedule sb inner join studentsubjectjoin stb on sb.sid=stb.sid  inner join subject sbj  on sbj.sid=sb.sid where stid="+stid );
		rs=stmt.executeQuery();
		Object obj[]=new Object[5];
int i=0;
		while(rs.next())
		{
i=0;
			ExamSchedule es = new ExamSchedule();
			obj[i]=new Object();
		    obj[0]=	rs.getString("subjectName");
			obj[1]=rs.getDate("sb.ExamId"); 
			obj[2]= rs.getString("sb.edate");
			obj[3]= rs.getString("startTime");
			obj[4]= rs.getString("EndTime");
			i++;

//			es.setDate(d);
//			es.setStartTime(st);
//			es.setEndTime(et);
//			
			return obj;

		//schList.add(obj);
			
			
		}
	if(schList!=null)
	{
		//return schList;
		return obj;
		
	}else
	{
		return null;
	}
		
	}
	
	public List isGetExamQuestionPaper(String username)
	{
	List <QuestionModule> qList=new ArrayList<QuestionModule>();
	
		int stid=this.getSidByName(username);
		
		try {
		
			stmt=n.prepareStatement("select q.question,q.op1,q.op2,q.op3,q.op4 from  question q inner join  subjectquestionjoin qs on q.qid=qs.qid inner join studentsubjectjoin st on qs.sid=st.sid where st.stid="+stid);
		rs=stmt.executeQuery();
		
		while (rs.next())
		{
			QuestionModule qm=new QuestionModule();
			
			qm.setQuestion(rs.getString(1));
			qm.setOpt1(rs.getString(2));
			qm.setOpt2(rs.getString(3));
			qm.setOpt3(rs.getString(4));
			qm.setOpt4(rs.getString(5));
			
			qList.add(qm);
			
			
		}
		return qList ;
			
		} catch (SQLException e) {
System.out.println(e);	
return null;


		}
		
		
	}
	
	

}
