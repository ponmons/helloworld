package model.domain;

public class People {
	private String id;
	
	public People(){
		System.out.println("Prople 기본 생성자");
	}
	public People(String s){
		System.out.println("Prople 생성자");
		id = s;
	}
	
	public String getId() {
		System.out.println("getId()");
		return id;
	}
	public void setId(String id) {
		System.out.println("setId()");
		this.id = id;
	}
	
}
