package org.services;
import java.io.*;
import java.util.List;

import org.ModuleForAll.QuestionModule;
import org.repository.QuestionRepository;

public class QuestionServices {
	String path="C:\\Users\\91913\\Favorites\\Desktop\\Java\\ExamQuestion";
    //String SubName;
	QuestionRepository qr=new QuestionRepository();
	SubjectServices sr=new SubjectServices();

	
	public int addQuestion(QuestionModule qmodel,String subName)
	{
		
		return qr.isAddQuestion(qmodel,subName)?1:0;
		
	}
	
	
	public boolean isCreateFile()
	{
		try {
		File f=new File("C:\\Users\\91913\\Favorites\\Desktop\\Java\\ExamQuestion");
		
		if(!f.exists())
		{
		f.mkdir();
		}
		List<String> subList=sr.getAllSubject();
		
		if(subList!=null)
		{
		
			for(String subName:subList)
			{
				
				f=new File(path+"\\"+subName+".csv");
				f.createNewFile();
				
				if(!f.exists()) {
				System.out.println("file created"+subName);} // if file present not repeat file 
			
			
			
			
			}
			
		}else
		{
			System.out.println("Subject not found");
		}
		
	  
		
		}catch(Exception e)
		{
			System.out.println("Question Ser");
		}
		return true;
	}
	

	public boolean uploadBulkQuestion(String SubName)
	{
		boolean b=this.isCreateFile();
		if(b) {
		
			boolean flag=false;
			File f=new File(path);
			File list[]=f.listFiles();
			
			for(File listt:list)
			{
				if(listt.isFile())
				{

				int index=listt.toString().indexOf(SubName);
				if(index!=-1)
				{
					flag=true;
					break;
				}
						}
				
			}
			
			if(flag)
			{
				try {
					
					FileReader fr=new FileReader("C:\\Users\\91913\\Favorites\\Desktop\\Java\\ExamQuestion"+"\\"+SubName+".csv ");
					BufferedReader br=new BufferedReader(fr);
					String question;
					flag=false;
					while((question=br.readLine())!=null)
					{
						
						String qWithOp[]=question.split(",");
						flag=qr.addBulkQuestion(qWithOp,SubName);
						
					System.out.println(question);	
						
					}
					
				}catch(Exception ee)
				{
					System.out.println("at questiion service");
				}
			}
			
			
			return true;
		}
		else {
			return false;
		}
		
		//return false;
		
		
	}
	
	
	
	
}
