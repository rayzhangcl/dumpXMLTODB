package ca.ualberta.cs.chenlei;

public class PostHistory {
	private String Id;
	private String PostHistoryTypeId;
	private String PostHistoryType;
	private String PostId;
	private String RevisionGUID;
	private String CreationDate;
	private String UserId;
	private String UserDisplayName;
	private String Comment;
	private String Text;
	private String CloseReasonId;
	private String CloseReason;
	
	public PostHistory(){
		
	}
	
	public String getPostHistoryType(String posthistorytypeid){
		switch (posthistorytypeid){
		case "1":   PostHistoryType = "Initial Title";
		case "2":   PostHistoryType = "Initial Body";
		case "3":   PostHistoryType = "Initial Tags";
		case "4":   PostHistoryType = "Edit Title";
		case "5":   PostHistoryType = "Edit Body";
		case "6":   PostHistoryType = "Edit Tags";
		case "7":   PostHistoryType = "Rollback Title";
		case "8":   PostHistoryType = "Rollback Body";
		case "9":   PostHistoryType = "Rollback Tags";
		case "10":   PostHistoryType = "Post Closed";
		case "11":   PostHistoryType = "Post Reopened";
		case "12":   PostHistoryType = "Post Deleted";
		case "13":   PostHistoryType = "Post Undeleted";
		case "14":   PostHistoryType = "Post Locked";
		case "15":   PostHistoryType = "Post Unlocked";
		case "16":   PostHistoryType = "Community Owned";
		case "17":   PostHistoryType = "Post Migrated";
		case "18":   PostHistoryType = "Question Merged";
		case "19":   PostHistoryType = "Question Protected";
		case "20":   PostHistoryType = "Question Unprotected"; 
		case "21":   PostHistoryType = "Post Disassociated";
		case "22":   PostHistoryType = "Question Unmerged";
		}
		return PostHistoryType;
	}
	
	public String getCloseReason(String closereasonid){
		switch(closereasonid){
		case "1": CloseReason="Exact Duplicate";
		case "2": CloseReason="off-topic"; 
		case "3": CloseReason="subjective"; 
		case "4": CloseReason="not a real question"; 
		case "7": CloseReason="too localized";
		}
		return CloseReason;
	}

	public PostHistory(String id, String postHistoryTypeId, String postId,
			String revisionGUID, String creationDate, String userId,
			String userDisplayName, String comment, String text,
			String closeReasonId) {
		super();
		Id = id;
		PostHistoryTypeId = postHistoryTypeId;
		PostId = postId;
		RevisionGUID = revisionGUID;
		CreationDate = creationDate;
		UserId = userId;
		UserDisplayName = userDisplayName;
		Comment = comment;
		Text = text;
		CloseReasonId = closeReasonId;
	}

	public String getId() {
		return Id;
	}

	public void setId(String id) {
		Id = id;
	}

	public String getPostHistoryTypeId() {
		return PostHistoryTypeId;
	}

	public void setPostHistoryTypeId(String postHistoryTypeId) {
		PostHistoryTypeId = postHistoryTypeId;
	}

	public String getPostId() {
		return PostId;
	}

	public void setPostId(String postId) {
		PostId = postId;
	}

	public String getRevisionGUID() {
		return RevisionGUID;
	}

	public void setRevisionGUID(String revisionGUID) {
		RevisionGUID = revisionGUID;
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

	public String getUserDisplayName() {
		return UserDisplayName;
	}

	public void setUserDisplayName(String userDisplayName) {
		UserDisplayName = userDisplayName;
	}

	public String getComment() {
		return Comment;
	}

	public void setComment(String comment) {
		Comment = comment;
	}

	public String getText() {
		return Text;
	}

	public void setText(String text) {
		Text = text;
	}

	public String getCloseReasonId() {
		return CloseReasonId;
	}

	public void setCloseReasonId(String closeReasonId) {
		CloseReasonId = closeReasonId;
	}

}
