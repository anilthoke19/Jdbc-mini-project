package org.services;

import java.util.List;

import org.ModuleForAll.QuestionModule;
import org.ModuleForAll.SubjectInfo;
import org.repository.QuestionRepository;
import org.repository.SubjectRepository;

public class SubjectServices {
	SubjectRepository sr=new SubjectRepository();
	QuestionRepository qr=new QuestionRepository();
	
	public int addSubject(SubjectInfo module)
	{		
		
		return sr.ischeckrepSubject(module.getName())?-1:sr.isAddSubject(module)?1:0;
	}
	
//	
//	public int addQuestion(QuestionModule qmodel,String subName)
//	{
//		
//		return qr.isAddQuestion(qmodel,subName)?1:0;
//		
//	}
	
	public List<String> getAllSubject()
	{
		return this.sr.getAllSubjects();
	}
	

}
