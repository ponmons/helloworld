package model.domain;

import java.io.Serializable;

public class MeetingDTO implements Serializable {
	private int meetingType;
	private int meetNo ;
	private String meetName ;
	private String place ;
	private String meetDate ;
	private int totalfee ;
	private int manageNo ;
	
	public MeetingDTO() {
		super();
	}

	public MeetingDTO(int meetingType, int meetNo, String meetName,
			String place, String meetDate, int totalfee, int manageNo) {
		super();
		this.meetingType = meetingType;
		this.meetNo = meetNo;
		this.meetName = meetName;
		this.place = place;
		this.meetDate = meetDate;
		this.totalfee = totalfee;
		this.manageNo = manageNo;
	}

	public MeetingDTO(int parseInt, String string, String spendLocation,
			String spendDate, String spendMemo, int count2, int intValue, int i) {
	}

	public int getMeetingType() {
		return meetingType;
	}

	public void setMeetingType(int meetingType) {
		this.meetingType = meetingType;
	}

	public int getMeetNo() {
		return meetNo;
	}

	public void setMeetNo(int meetNo) {
		this.meetNo = meetNo;
	}

	public String getMeetName() {
		return meetName;
	}

	public void setMeetName(String meetName) {
		this.meetName = meetName;
	}

	public String getPlace() {
		return place;
	}

	public void setPlace(String place) {
		this.place = place;
	}

	public String getMeetDate() {
		return meetDate;
	}

	public void setMeetDate(String meetDate) {
		this.meetDate = meetDate;
	}

	public int getTotalfee() {
		return totalfee;
	}

	public void setTotalfee(int totalfee) {
		this.totalfee = totalfee;
	}

	public int getManageNo() {
		return manageNo;
	}

	public void setManageNo(int manageNo) {
		this.manageNo = manageNo;
	}

	@Override
	public String toString() {
		return "MeetingDTO [meetingType=" + meetingType + ", meetNo=" + meetNo
				+ ", meetName=" + meetName + ", place=" + place + ", meetDate="
				+ meetDate + ", totalfee=" + totalfee + ", manageNo="
				+ manageNo + "]";
	}

}
