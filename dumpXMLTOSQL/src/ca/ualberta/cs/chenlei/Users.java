package ca.ualberta.cs.chenlei;

public class Users {
	private String Id;
	private String Reputation;
	private String CreationDate;
	private String DisplayName;
	private String EmailHash;
	private String LastAccessDate;
	private String WebsiteUrl;
	private String Location;
	private String Age;
	private String AboutMe;
	private String Views;
	private String UpVotes;
	private String DownVotes;
	
	public Users(){
		
	}

	public Users(String id, String reputation, String creationDate,
			String displayName, String emailHash, String lastAccessDate,
			String websiteUrl, String location, String age, String aboutMe,
			String views, String upVotes, String downVotes) {
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


	public String getId() {
		return Id;
	}
	public void setId(String id) {
		Id = id;
	}
	public String getReputation() {
		return Reputation;
	}
	public void setReputation(String reputation) {
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
	public String getAge() {
		return Age;
	}
	public void setAge(String age) {
		Age = age;
	}
	public String getAboutMe() {
		return AboutMe;
	}
	public void setAboutMe(String aboutMe) {
		AboutMe = aboutMe;
	}
	public String getViews() {
		return Views;
	}
	public void setViews(String views) {
		Views = views;
	}
	public String getUpVotes() {
		return UpVotes;
	}
	public void setUpVotes(String upVotes) {
		UpVotes = upVotes;
	}
	public String getDownVotes() {
		return DownVotes;
	}
	public void setDownVotes(String downVotes) {
		DownVotes = downVotes;
	}

}
