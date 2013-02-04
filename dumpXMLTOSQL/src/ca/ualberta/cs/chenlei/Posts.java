package ca.ualberta.cs.chenlei;

public class Posts {
    private String Id; 
    private String PostTypeId;
       //private String1: Question
       //private String2: Answer
    private String ParentId;
    private String AcceptedAnswerId;
    private String CreationDate; 
    private String Score; 
    private String ViewCount;
    private String Body; 
    private String OwnerUserId;
    private String LastEditorUserId; 
    private String LastEditorDisplayName; 
    private String LastEditDate; 
    private String LastActivityDate; 
    private String CommunityOwnedDate; 
    private String ClosedDate;
    private String Title; 
    private String Tags; 
    private String AnswerCount; 
    private String CommentCount; 
    private String FavoriteCount;
    
    public Posts(){
    	
    }

	public Posts(String id, String postTypeId, String parentId,
			String acceptedAnswerId, String creationDate, String score,
			String viewCount, String body, String ownerUserId,
			String lastEditorUserId, String lastEditorDisplayName,
			String lastEditDate, String lastActivityDate,
			String communityOwnedDate, String closedDate, String title,
			String tags, String answerCount, String commentCount,
			String favoriteCount) {
		super();
		Id = id;
		PostTypeId = postTypeId;
		ParentId = parentId;
		AcceptedAnswerId = acceptedAnswerId;
		CreationDate = creationDate;
		Score = score;
		ViewCount = viewCount;
		Body = body;
		OwnerUserId = ownerUserId;
		LastEditorUserId = lastEditorUserId;
		LastEditorDisplayName = lastEditorDisplayName;
		LastEditDate = lastEditDate;
		LastActivityDate = lastActivityDate;
		CommunityOwnedDate = communityOwnedDate;
		ClosedDate = closedDate;
		Title = title;
		Tags = tags;
		AnswerCount = answerCount;
		CommentCount = commentCount;
		FavoriteCount = favoriteCount;
	}

	public String getId() {
		return Id;
	}

	public void setId(String id) {
		Id = id;
	}

	public String getPostTypeId() {
		return PostTypeId;
	}

	public void setPostTypeId(String postTypeId) {
		PostTypeId = postTypeId;
	}

	public String getParentId() {
		return ParentId;
	}

	public void setParentId(String parentId) {
		ParentId = parentId;
	}

	public String getAcceptedAnswerId() {
		return AcceptedAnswerId;
	}

	public void setAcceptedAnswerId(String acceptedAnswerId) {
		AcceptedAnswerId = acceptedAnswerId;
	}

	public String getCreationDate() {
		return CreationDate;
	}

	public void setCreationDate(String creationDate) {
		CreationDate = creationDate;
	}

	public String getScore() {
		return Score;
	}

	public void setScore(String score) {
		Score = score;
	}

	public String getViewCount() {
		return ViewCount;
	}

	public void setViewCount(String viewCount) {
		ViewCount = viewCount;
	}

	public String getBody() {
		return Body;
	}

	public void setBody(String body) {
		Body = body;
	}

	public String getOwnerUserId() {
		return OwnerUserId;
	}

	public void setOwnerUserId(String ownerUserId) {
		OwnerUserId = ownerUserId;
	}

	public String getLastEditorUserId() {
		return LastEditorUserId;
	}

	public void setLastEditorUserId(String lastEditorUserId) {
		LastEditorUserId = lastEditorUserId;
	}

	public String getLastEditorDisplayName() {
		return LastEditorDisplayName;
	}

	public void setLastEditorDisplayName(String lastEditorDisplayName) {
		LastEditorDisplayName = lastEditorDisplayName;
	}

	public String getLastEditDate() {
		return LastEditDate;
	}

	public void setLastEditDate(String lastEditDate) {
		LastEditDate = lastEditDate;
	}

	public String getLastActivityDate() {
		return LastActivityDate;
	}

	public void setLastActivityDate(String lastActivityDate) {
		LastActivityDate = lastActivityDate;
	}

	public String getCommunityOwnedDate() {
		return CommunityOwnedDate;
	}

	public void setCommunityOwnedDate(String communityOwnedDate) {
		CommunityOwnedDate = communityOwnedDate;
	}

	public String getClosedDate() {
		return ClosedDate;
	}

	public void setClosedDate(String closedDate) {
		ClosedDate = closedDate;
	}

	public String getTitle() {
		return Title;
	}

	public void setTitle(String title) {
		Title = title;
	}

	public String getTags() {
		return Tags;
	}

	public void setTags(String tags) {
		Tags = tags;
	}

	public String getAnswerCount() {
		return AnswerCount;
	}

	public void setAnswerCount(String answerCount) {
		AnswerCount = answerCount;
	}

	public String getCommentCount() {
		return CommentCount;
	}

	public void setCommentCount(String commentCount) {
		CommentCount = commentCount;
	}

	public String getFavoriteCount() {
		return FavoriteCount;
	}

	public void setFavoriteCount(String favoriteCount) {
		FavoriteCount = favoriteCount;
	}
}
