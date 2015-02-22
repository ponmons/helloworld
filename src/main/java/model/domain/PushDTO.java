package model.domain;
import java.io.Serializable;
import java.sql.Date;
public class PushDTO implements Serializable{
	String content;
	int notificationno;
	int meetno;
	int memno;
	int ckNo;
	String alramtime;
	
	public PushDTO(String content,int memno,int meetno) {
		super();
		this.content = content;
		this.memno = memno;
		this.meetno=meetno;
	}
	public PushDTO() {
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
	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("PushDTO [content=");
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
	public PushDTO(String content, int notificationno, int meetno, int memno,
			int ckNo, String alramtime) {
		super();
		this.content = content;
		this.notificationno = notificationno;
		this.meetno = meetno;
		this.memno = memno;
		this.ckNo = ckNo;
		this.alramtime = alramtime;
	}
	
	
	
	
	
	
	
	
}
