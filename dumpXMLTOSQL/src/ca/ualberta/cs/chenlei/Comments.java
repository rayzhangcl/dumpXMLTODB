package ca.ualberta.cs.chenlei;

public class Comments {
	private String Id;
	private String PostId;
	private String Score;
	private String Text;
	private String CreationDate;
	private String UserId;
	
	public Comments(){
		
	}
	
	public Comments(String id, String postId, String score, String text,
			String creationDate, String userId) {
		super();
		Id = id;
		PostId = postId;
		Score = score;
		Text = text;
		CreationDate = creationDate;
		UserId = userId;
	}

	public String getId() {
		return Id;
	}
	public void setId(String id) {
		Id = id;
	}
	public String getPostId() {
		return PostId;
	}
	public void setPostId(String postId) {
		PostId = postId;
	}
	public String getScore() {
		return Score;
	}
	public void setScore(String score) {
		Score = score;
	}
	public String getText() {
		return Text;
	}
	public void setText(String text) {
		Text = text;
	}
	public String getCreationDate() {
		return CreationDate;
	}
	public void setCreationDate(String creationDate) {
		CreationDate = creationDate;
	}
	public String getUserId() {
		return UserId;
	}
	public void setUserId(String userId) {
		UserId = userId;
	}
}
