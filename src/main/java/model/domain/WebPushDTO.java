package model.domain;
import java.io.Serializable;
import java.sql.Date;
public class WebPushDTO implements Serializable{
	String memname;
	String content;
	int notificationno;
	int meetno;
	int memno;
	int ckNo;
	String alramtime;
	
	public WebPushDTO() {
	}
	
	

	public WebPushDTO(String memname, String content, int notificationno,
			int meetno, int memno, int ckNo, String alramtime) {
		super();
		this.memname = memname;
		this.content = content;
		this.notificationno = notificationno;
		this.meetno = meetno;
		this.memno = memno;
		this.ckNo = ckNo;
		this.alramtime = alramtime;
	}






	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public int getNotificationno() {
		return notificationno;
	}
	public void setNotificationno(int notificationno) {
		this.notificationno = notificationno;
	}
	public int getMeetno() {
		return meetno;
	}
	public void setMeetno(int meetno) {
		this.meetno = meetno;
	}
	public int getMemno() {
		return memno;
	}
	public void setMemno(int memno) {
		this.memno = memno;
	}
	public int getCkNo() {
		return ckNo;
	}
	public void setCkNo(int ckNo) {
		this.ckNo = ckNo;
	}
	public String getAlramtime() {
		return alramtime;
	}
	public void setAlramtime(String alramtime) {
		this.alramtime = alramtime;
	}
	public String getMemname() {
		return memname;
	}
	public void setMemname(String memname) {
		this.memname = memname;
	}



	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("WebPushDTO [memname=");
		builder.append(memname);
		builder.append(", content=");
		builder.append(content);
		builder.append(", notificationno=");
		builder.append(notificationno);
		builder.append(", meetno=");
		builder.append(meetno);
		builder.append(", memno=");
		builder.append(memno);
		builder.append(", ckNo=");
		builder.append(ckNo);
		builder.append(", alramtime=");
		builder.append(alramtime);
		builder.append("]");
		return builder.toString();
	}



	
	
}
