package model.domain;

import java.io.Serializable;

public class PayDTO implements Serializable{
	String memName;
	String memPw;
	String email;
	String account;
	String phoneNumber;
	String carPw;
	String memPic;
	int payCheck;
	int price;
	int memno;
	int totalfee;
	int meetno;
	String deviceId;
	
	public PayDTO() {}

	public PayDTO(int memno) {
		super();
		this.memno = memno;
	}


	public PayDTO(int memno, int meetno) {
		super();
		this.memno = memno;
		this.meetno = meetno;
	}
	public PayDTO(int price2, int totalfee2, int meetno2) {
		this.meetno = meetno2;
		this.price = price2;
		this.totalfee = totalfee2;
	}

	public PayDTO(String memName, String memPw, String email, String account,
			String phoneNumber, String carPw, int payCheck, int price,
			int memno, int totalfee, int meetno,String deviceId) {
		super();
		this.memName = memName;
		this.memPw = memPw;
		this.email = email;
		this.account = account;
		this.phoneNumber = phoneNumber;
		this.carPw = carPw;
		this.payCheck = payCheck;
		this.price = price;
		this.memno = memno;
		this.totalfee = totalfee;
		this.meetno = meetno;
		this.deviceId=deviceId;
	}

	


	public String getDeviceId() {
		return deviceId;
	}


	public void setDeviceId(String deviceId) {
		this.deviceId = deviceId;
	}


	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("PayDTO [memName=");
		builder.append(memName);
		builder.append(", memPw=");
		builder.append(memPw);
		builder.append(", email=");
		builder.append(email);
		builder.append(", account=");
		builder.append(account);
		builder.append(", phoneNumber=");
		builder.append(phoneNumber);
		builder.append(", carPw=");
		builder.append(carPw);
		builder.append(", payCheck=");
		builder.append(payCheck);
		builder.append(", price=");
		builder.append(price);
		builder.append(", memno=");
		builder.append(memno);
		builder.append(", totalfee=");
		builder.append(totalfee);
		builder.append(", meetno=");
		builder.append(meetno);
		builder.append(", deviceId=");
		builder.append(deviceId);
		builder.append("]");
		return builder.toString();
	}


	public String getMemName() {
		return memName;
	}


	public void setMemName(String memName) {
		this.memName = memName;
	}


	public String getMemPw() {
		return memPw;
	}

	public void setMemPw(String memPw) {
		this.memPw = memPw;
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


	public String getPhoneNumber() {
		return phoneNumber;
	}


	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}


	public String getCarPw() {
		return carPw;
	}


	public void setCarPw(String carPw) {
		this.carPw = carPw;
	}


	public int getPayCheck() {
		return payCheck;
	}


	public void setPayCheck(int payCheck) {
		this.payCheck = payCheck;
	}


	public int getPrice() {
		return price;
	}


	public void setPrice(int price) {
		this.price = price;
	}


	public int getMemno() {
		return memno;
	}


	public void setMemno(int memno) {
		this.memno = memno;
	}


	public int getTotalfee() {
		return totalfee;
	}


	public void setTotalfee(int totalfee) {
		this.totalfee = totalfee;
	}


	public int getMeetno() {
		return meetno;
	}


	public void setMeetno(int meetno) {
		this.meetno = meetno;
	}

	
}
