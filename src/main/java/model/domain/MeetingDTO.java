package model.domain;

import java.io.Serializable;

public class MeetingDTO implements Serializable {
	private int meetno ;
	private String meetname ;
	private String place ;
	private int meetdate ;
	private int totalfee ;
	private int manageno ;
	
	public MeetingDTO() {
		super();
		// TODO Auto-generated constructor stub
	}
	public MeetingDTO(int meetno, String meetname, String place, int meetdate,
			int totalfee, int manageno) {
		super();
		this.meetno = meetno;
		this.meetname = meetname;
		this.place = place;
		this.meetdate = meetdate;
		this.totalfee = totalfee;
		this.manageno = manageno;
	}
	public int getMeetno() {
		return meetno;
	}
	public void setMeetno(int meetno) {
		this.meetno = meetno;
	}
	public String getMeetname() {
		return meetname;
	}
	public void setMeetname(String meetname) {
		this.meetname = meetname;
	}
	public String getPlace() {
		return place;
	}
	public void setPlace(String place) {
		this.place = place;
	}
	public int getMeetdate() {
		return meetdate;
	}
	public void setMeetdate(int meetdate) {
		this.meetdate = meetdate;
	}
	public int getTotalfee() {
		return totalfee;
	}
	public void setTotalfee(int totalfee) {
		this.totalfee = totalfee;
	}
	public int getManageno() {
		return manageno;
	}
	public void setManageno(int manageno) {
		this.manageno = manageno;
	}
	@Override
	public String toString() {
		return "meetingDTO [meetno=" + meetno + ", meetname=" + meetname
				+ ", place=" + place + ", meetdate=" + meetdate + ", totalfee="
				+ totalfee + ", manageno=" + manageno + "]";
	}
	
	
}
