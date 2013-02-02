package ca.ualberta.cs.chenlei;

public class Badges {
	private int Id;
	private int UserId;
	private String Name;
	private String Date;
	
	public Badges(){
		
	}

	public Badges(int Id, int UserId, String Name, String Date){
		this.Id = Id;
		this.UserId = UserId;
		this.Name = Name;
		this.Date = Date;
	}

	public int getId() {
		return Id;
	}

	public void setId(int id) {
		Id = id;
	}

	public int getUserId() {
		return UserId;
	}

	public void setUserId(int userId) {
		UserId = userId;
	}

	public String getName() {
		return Name;
	}

	public void setName(String name) {
		Name = name;
	}

	public String getDate() {
		return Date;
	}

	public void setDate(String date) {
		Date = date;
	}


}
