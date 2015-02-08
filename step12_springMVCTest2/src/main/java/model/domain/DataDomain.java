package model.domain;

public class DataDomain {
	private String kodb;
	private String key;
	private String key2;
	
	public DataDomain() {}
	public DataDomain(String kodb, String key, String key2) {
		super();
		this.kodb = kodb;
		this.key = key;
		this.key2 = key2;
	}
	
	public String getKodb() {
		return kodb;
	}
	public void setKodb(String kodb) {
		this.kodb = kodb;
	}
	public String getKey() {
		return key;
	}
	public void setKey(String key) {
		this.key = key;
	}
	public String getKey2() {
		return key2;
	}
	public void setKey2(String key2) {
		this.key2 = key2;
	}
	
	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("DataDomain [kodb=");
		builder.append(kodb);
		builder.append(", key=");
		builder.append(key);
		builder.append(", key2=");
		builder.append(key2);
		builder.append("]");
		return builder.toString();
	}
}
