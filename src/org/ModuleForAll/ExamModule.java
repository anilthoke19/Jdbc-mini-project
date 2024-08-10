package org.ModuleForAll;

public class ExamModule {
	
	private int examId;
	private String examName;
	private int totalMarks;
	private int passingMarks;
	 ExamSchedule es;
	
	
	
	public ExamModule(int examId, String examName, int totalMarks, int passingMarks) {
		super();
		this.examId = examId;
		this.examName = examName;
		this.passingMarks=passingMarks;
		this.totalMarks = totalMarks;
		
	}


	public ExamModule() {
		
	}  


	public int getExamId() {
		return examId;
	}


	public void setExamId(int examId) {
		this.examId = examId;
	}


	public String getExamName() {
		return examName;
	}


	public void setExamName(String examName) {
		this.examName = examName;
	}


	public int getTotalMarks() {
		return totalMarks;
	}


	public void setTotalMarks(int totalMarks) {
		this.totalMarks = totalMarks;
	}


	public int getPassingMarks() {
		return passingMarks;
	}


	public void setPassingMarks(int passingMarks) {
		this.passingMarks = passingMarks;
	}
	
	public  void  setexamSchedule( ExamSchedule es)
	{
		this.es=es;
	}
	
	public  ExamSchedule getExamSchedule()
	{
		 return  es;
	}
	

}
