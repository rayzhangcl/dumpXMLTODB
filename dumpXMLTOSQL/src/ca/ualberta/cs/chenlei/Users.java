package ca.ualberta.cs.chenlei;

public class Users {
	private int Id;
	private int Reputation;
	private String CreationDate;
	private String DisplayName;
	private String EmailHash;
	private String LastAccessDate;
	private String WebsiteUrl;
	private String Location;
	private int Age;
	private String AboutMe;
	private int Views;
	private int UpVotes;
	private int DownVotes;
	
	public Users(){
		
	}

	public Users(int id, int reputation, String creationDate,
			String displayName, String emailHash, String lastAccessDate,
			String websiteUrl, String location, int age, String aboutMe,
			int views, int upVotes, int downVotes) {
		super();
		Id = id;
		Reputation = reputation;
		CreationDate = creationDate;
		DisplayName = displayName;
		EmailHash = emailHash;
		LastAccessDate = lastAccessDate;
		WebsiteUrl = websiteUrl;
		Location = location;
		Age = age;
		AboutMe = aboutMe;
		Views = views;
		UpVotes = upVotes;
		DownVotes = downVotes;
	}


	public int getId() {
		return Id;
	}
	public void setId(int id) {
		Id = id;
	}
	public int getReputation() {
		return Reputation;
	}
	public void setReputation(int reputation) {
		Reputation = reputation;
	}
	public String getCreationDate() {
		return CreationDate;
	}
	public void setCreationDate(String creationDate) {
		CreationDate = creationDate;
	}
	public String getDisplayName() {
		return DisplayName;
	}
	public void setDisplayName(String displayName) {
		DisplayName = displayName;
	}
	public String getEmailHash() {
		return EmailHash;
	}
	public void setEmailHash(String emailHash) {
		EmailHash = emailHash;
	}
	public String getLastAccessDate() {
		return LastAccessDate;
	}
	public void setLastAccessDate(String lastAccessDate) {
		LastAccessDate = lastAccessDate;
	}
	public String getWebsiteUrl() {
		return WebsiteUrl;
	}
	public void setWebsiteUrl(String websiteUrl) {
		WebsiteUrl = websiteUrl;
	}
	public String getLocation() {
		return Location;
	}
	public void setLocation(String location) {
		Location = location;
	}
	public int getAge() {
		return Age;
	}
	public void setAge(int age) {
		Age = age;
	}
	public String getAboutMe() {
		return AboutMe;
	}
	public void setAboutMe(String aboutMe) {
		AboutMe = aboutMe;
	}
	public int getViews() {
		return Views;
	}
	public void setViews(int views) {
		Views = views;
	}
	public int getUpVotes() {
		return UpVotes;
	}
	public void setUpVotes(int upVotes) {
		UpVotes = upVotes;
	}
	public int getDownVotes() {
		return DownVotes;
	}
	public void setDownVotes(int downVotes) {
		DownVotes = downVotes;
	}

}
