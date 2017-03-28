package pl.piomin.microservices.customer.model;

public class Account {

	private String id;
	private String number;

	public Account() {
		
	}

	public Account(String id, String number) {
		super();
		this.id = id;
		this.number = number;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getNumber() {
		return number;
	}

	public void setNumber(String number) {
		this.number = number;
	}

}
