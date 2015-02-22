package model.domain;

import java.io.Serializable;

public class MemberDTO implements Serializable{
	private int memno;
	private String memname;
	private String mempw;
	private String cardpw;
	private String email;
	private String account;
	private int phonenumber;
	private String deviceid;
	private String mempic;
	
	public MemberDTO() {
		super();
		// TODO Auto-generated constructor stub
	}

	public MemberDTO(int memno, String memname, String mempw, String cardpw,
			String email, String account, int phonenumber, String deviceid,
			String mempic) {
		super();
		this.memno = memno;
		this.memname = memname;
		this.mempw = mempw;
		this.cardpw = cardpw;
		this.email = email;
		this.account = account;
		this.phonenumber = phonenumber;
		this.deviceid = deviceid;
		this.mempic = mempic;
	}

	public MemberDTO(String memname2, String mempw2, String email2, int phonenumber2) {
		this.memname = memname2;
		this.mempw = mempw2;
		this.email = email2;
		this.phonenumber = phonenumber2;
	}

	public MemberDTO(String email2, String mempw2) {
		this.email = email2;
		this.mempw = mempw2;
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

	public String getCardpw() {
		return cardpw;
	}

	public void setCardpw(String cardpw) {
		this.cardpw = cardpw;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
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

	public String getDeviceid() {
		return deviceid;
	}

	public void setDeviceid(String deviceid) {
		this.deviceid = deviceid;
	}

	public String getMempic() {
		return mempic;
	}

	public void setMempic(String mempic) {
		this.mempic = mempic;
	}

	@Override
	public String toString() {
		return "MemberDTO [memno=" + memno + ", memname=" + memname
				+ ", mempw=" + mempw + ", cardpw=" + cardpw + ", email="
				+ email + ", account=" + account + ", phonenumber="
				+ phonenumber + ", deviceid=" + deviceid + ", mempic=" + mempic
				+ "]";
	}
	
	
}
