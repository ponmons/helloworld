package model.domain;

import java.io.Serializable;

public class PaymentDTO implements Serializable {
	private int payno;
	private int paycheck;
	private int price;
	private int meetno;
	private int memno;
	
	public PaymentDTO() {
		super();
		// TODO Auto-generated constructor stub
	}

	public PaymentDTO(int payno, int paycheck, int price, int meetno, int memno) {
		super();
		this.payno = payno;
		this.paycheck = paycheck;
		this.price = price;
		this.meetno = meetno;
		this.memno = memno;
	}

	public int getPayno() {
		return payno;
	}

	public void setPayno(int payno) {
		this.payno = payno;
	}

	public int getPaycheck() {
		return paycheck;
	}

	public void setPaycheck(int paycheck) {
		this.paycheck = paycheck;
	}

	public int getPrice() {
		return price;
	}

	public void setPrice(int price) {
		this.price = price;
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

	@Override
	public String toString() {
		return "PaymentDTO [payno=" + payno + ", paycheck=" + paycheck
				+ ", price=" + price + ", meetno=" + meetno + ", memno="
				+ memno + "]";
	}
	
}
