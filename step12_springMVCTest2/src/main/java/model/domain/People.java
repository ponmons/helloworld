package model.domain;

public class People {
	private String id;
	private String pw;
	
	public People() {}
	public People(String id, String pw) {
		super();
		this.id = id;
		this.pw = pw;
	}
	
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getPw() {
		return pw;
	}
	public void setPw(String pw) {
		this.pw = pw;
	}
	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("People [id=");
		builder.append(id);
		builder.append(", pw=");
		builder.append(pw);
		builder.append("]");
		return builder.toString();
	}
}
