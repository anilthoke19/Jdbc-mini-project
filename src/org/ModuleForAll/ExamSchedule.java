package org.ModuleForAll;

import java.util.Date;

public class ExamSchedule {
	private int Schid;
	private int ExamId;
	private  Date date2 ;
	private String startTime;
	private String endTime;
	
	public int getSchid() {
		return Schid;
	}
	public void setSchid(int schid) {
		Schid = schid;
	}
	public int getExamId() {
		return ExamId;
	}
	public void setExamId(int examId) {
		ExamId = examId;
	}
	public Date  getDate() {
		return date2;
	}
	public void setDate(Date date2) {
		this.date2 = date2;
	}
	public String getStartTime() {
		return startTime;
	}
	public void setStartTime(String startTime) {
		this.startTime = startTime;
	}
	public String getEndTime() {
		return endTime;
	}
	public void setEndTime(String endTime) {
		this.endTime = endTime;
	}
	
	
	public ExamSchedule(int schid, int examId, Date date, String startTime, String endTime) {
		super();
		Schid = schid;
		ExamId = examId;
	     date2 = date;
		this.startTime = startTime;
		this.endTime = endTime;
	}
	
	
	public ExamSchedule() {

	}
	
	
	
	
	

}
