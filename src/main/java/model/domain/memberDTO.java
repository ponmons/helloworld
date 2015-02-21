package model.domain;

import java.io.Serializable;

public class memberDTO implements Serializable{
	private int memno;
	private String memname;
	private String mempw;
	private String memid;
	private String account;
	private int phonenumber;
	public memberDTO() {
		super();
		// TODO Auto-generated constructor stub
	}
	public memberDTO(int memno, String memname, String mempw, String memid,
			String account, int phonenumber) {
		super();
		this.memno = memno;
		this.memname = memname;
		this.mempw = mempw;
		this.memid = memid;
		this.account = account;
		this.phonenumber = phonenumber;
	}
	public int getMemno() {
		return memno;
	}
	public void setMemno(int memno) {
		this.memno = memno;
	}
	public String getMemname() {
		return memname;
	}
	public void setMemname(String memname) {
		this.memname = memname;
	}
	public String getMempw() {
		return mempw;
	}
	public void setMempw(String mempw) {
		this.mempw = mempw;
	}
	public String getMemid() {
		return memid;
	}
	public void setMemid(String memid) {
		this.memid = memid;
	}
	public String getAccount() {
		return account;
	}
	public void setAccount(String account) {
		this.account = account;
	}
	public int getPhonenumber() {
		return phonenumber;
	}
	public void setPhonenumber(int phonenumber) {
		this.phonenumber = phonenumber;
	}
	@Override
	public String toString() {
		return "memberDTO [memno=" + memno + ", memname=" + memname
				+ ", mempw=" + mempw + ", memid=" + memid + ", account="
				+ account + ", phonenumber=" + phonenumber + "]";
	}
	
	
}
