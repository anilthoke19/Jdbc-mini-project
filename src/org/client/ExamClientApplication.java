package org.client;
//import java.sql.*;
import java.util.*;

import org.ModuleForAll.ExamModule;
import org.ModuleForAll.ExamSchedule;
import org.ModuleForAll.QuestionModule;
import org.ModuleForAll.StudentModule;
import org.ModuleForAll.SubjectInfo;
import org.repository.SubjectRepository;
import org.services.ExamServices;
import org.services.QuestionServices;
import org.services.StudentServices;
import org.services.SubjectServices;
import java.io.*;
import java.util.*;

public class ExamClientApplication {

	public static void main(String[] args) {
		
		int choice,ans,passingM,totalM;
		String name,que,op1,op2,op3,op4,subName;
		SubjectInfo modul=new SubjectInfo();
		int sid;
		String stdname,contact,email,username,password;
		
		StudentModule stdModel=new StudentModule();
		StudentServices sr=new StudentServices();
		SubjectServices sv=new SubjectServices();
		QuestionServices  qs=new QuestionServices();
		ExamModule mm=new ExamModule();

		ExamServices es=new ExamServices();
		Scanner sc=new Scanner(System.in);
		
		do {
			System.out.println("enter your choice");

			System.out.println("1:add SUBJECT information");
			System.out.println("2:Add Single question  data");
			System.out.println("3:Add multiple question data by csv file");
			System.out.println("4: Add exam info ");
			System.out.println("5:Add exam schedule by subject ");
			System.out.println("6: Student information ");
			System.out.println("7:Student should login to systrem");
			System.out.println("8: Exam schedule and exam login for student");
			//System.out.println("9: Exam Question for student");

			
			choice=sc.nextInt();
			
			switch(choice)
			{
			case 1:
				System.out.println("Enter Subject  name");
				sc.nextLine();
				name=sc.nextLine();
				modul.setName(name);
				
				int result=sv.addSubject(modul);
				if(result==1) {
					System.out.println("Subject added successfully");
				}
				else if(result==-1){
					System.out.println("Subject already present");
				}
				
				else
				{
					System.out.println("Some problem is there");
				}
			
				break;
			
				
			case 2:
				
				
				System.out.println("Enter subject name ,question,option1,option 2 ,option3,option4 and answer option  ");

				
				sc.nextLine();
				subName=sc.nextLine();
				que=sc.nextLine();
				op1=sc.nextLine();
				op2=sc.nextLine();
				op3=sc.nextLine();
				op4=sc.nextLine();
				ans=sc.nextInt();
				
				QuestionModule qModel=new QuestionModule(que,op1,op2,op3,op4,ans);
				int  value=qs.addQuestion(qModel,subName);
				if(value==1)
				{
					System.out.println("Question added");
				}else
				{
					System.out.println("Question not added");
				}
				
				break;
				
			case 3:
				Scanner scc=new Scanner(System.in);
				System.out.println("Enter subject name for bulk questions");
				String sname=scc.nextLine();
				qs.uploadBulkQuestion(sname);
				
				
				break;
				
				
	
			
				
				
				case 4:
					ExamServices er=new ExamServices();

					System.out.println("Enter name,id,passing marks,total marks");
					sc.nextLine();
					name=sc.nextLine();
					int id=sc.nextInt();
					
					passingM=sc.nextInt();
					totalM=sc.nextInt();
					

					ExamModule em=new ExamModule(id,name,totalM,passingM);
					
					value=er.addExam(em);
					if(value==1) {
						
						
						System.out.println("exam added");
					}
					else if(value==-1)
						System.out.println("Exam already presentt");
					else 
						System.out.println("Exam Not added");
					
					break;
					
					
					
					
					
					
				case 5:
Scanner sc2=new Scanner(System.in);
					ExamServices er2=new ExamServices();
						ExamSchedule esc=new ExamSchedule();
						List <ExamModule> list=new ArrayList<ExamModule>();
					
						list=es.examData();
						System.out.println("Exam available: ");

						for(ExamModule em2:list)
						{
							System.out.println(em2.getExamName());
						}
						System.out.println("Enter Examname name ");
						name=sc2.nextLine();
						sid=er2.getExamIdByExamName(name); //
						System.out.println(sid+"put here ");
						if(sid!=-1)
						{
						sc.nextLine();
						System.out.println("Enter exam name for create exam Schedule  ");
						
						
						
							//System.out.println("Subject present");

							System.out.println("Enter date,startTime,Endtime");
							

							String dateSh=sc.nextLine();
							Date dd=new Date(dateSh);
							String startTime=sc.nextLine();
							String endtime=sc.nextLine();
							
	
						ExamSchedule esc2=new ExamSchedule(0,sid,dd,startTime,endtime);
						
						
						mm.setexamSchedule(esc2); // getter & setter method
						value=es.addExamShedule(mm, name);
						
						if(value>0)
						{
							System.out.println("schedule created");
						}else
						{
							System.out.println("Shedule not created");
						}
						
						}else
						{
							System.out.println("Subject not present.............");
						}
						
						
						
						
						break;
						
					
				
				
						
						
						
						
						
						
			case 6:
				System.out.println("Enter studetn id, name,email,contact,Username,password");
				sid=sc.nextInt();
				sc.nextLine();
				stdname=sc.nextLine();
				email=sc.nextLine();
				contact=sc.nextLine();
				username=sc.nextLine();
				password=sc.nextLine();
				
				StudentModule stdModel2=new StudentModule(sid,stdname,email,contact,username,password);
				
              value=sr.addStudent(stdModel2);
              if(value==1)System.out.println("Student added...............");
              else System.out.println("Studetn not add....................");
                
			break;
			
			
			// you can add  here subject question and shedule for student subject
			case 7:
			Scanner sc3=new Scanner(System.in);
				System.out.println("Enter username and  password for login");
				username=sc3.nextLine();
				password=sc3.nextLine();
				
				value=sr.getUserNamePassword(username,password);
				Scanner sc4=new Scanner(System.in);
				if(value==1)
				{
					System.out.println("User valid ");

					
					System.out.println("Enter student name  for studennt id ");
					name=sc4.nextLine();
					System.out.println("Enter subject name  for subject id ");
					String name2=sc4.nextLine();
					
					
					int joinn=sr.studentSubJoin(name,name2);
					if(joinn==1)
					{
						System.out.println("join Student-subject table created");
						
						
						
						
						
					}else
					{
						System.out.println(" join Student-subject table not created");

					}
					
					
					
			
				}else
				{
					System.out.println("Invalid user or register as a student");
				}
				break;
				
			case 8:
				
				
				Scanner sc5=new Scanner(System.in);
				System.out.println("Enter username and  password for login");
				username=sc5.nextLine();
				password=sc5.nextLine();
				 
				value=sr.getUserNamePassword(username,password);
				Scanner sc6=new Scanner(System.in);
				if(value==1)
				{
					System.out.println("1: for schedule");
					System.out.println("2: Exam question  login");
					System.out.println("Enter your choice");
					 choice=sc6.nextInt();
				
//					do
//					{
						switch (choice) {
						
						case 1:
							Object obj[] = sr.getStudentScheduleS(username);
                            System.out.println("Object length is :"+obj.length);
							for(int i=0;i<obj.length;i++)
							{
								
								//obj[i]=obj[i];
								System.out.println(obj[0]+" "+obj[1]+" "+obj[2]+"  "+obj[3]+" "+obj[4]);
							}
//							for (Object esc2 : obj) {
//								System.out.println(esc2 + " ");
//								
//								// System.out.println(esc2.getEndTime()+" "+esc2.getStartTime()+"
//								// "+esc2.getStartTime()+" "+esc2.getDate());
//							}

							break;

						case 2:

							List<QuestionModule> qList = sr.getStudetnQuestion(username);

							if (qList != null) {
								for (QuestionModule m : qList) {
									System.out.println(m.getQuestion() + " " + m.getOpt1() + " " + m.getOpt2() + " "
											+ m.getOpt3() + " " + m.getOpt4());
							
								}

							}
						else {
								System.out.println("Null question list at client");
							}

							break;
						}
						
						
						
				//	}while(choice<3);
					
					
					System.out.println("User valid ");
					
				
				}else
				{
					System.out.println("Invalid user or register as a student");
				}
				
				break;
				
				
			case 9:
				
				
				
				
				
				break;
			
			}
			
		
			
			
			
			
		}while(true);
		
		
		
		
	}

}
