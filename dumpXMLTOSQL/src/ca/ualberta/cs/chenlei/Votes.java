package ca.ualberta.cs.chenlei;

public class Votes {
	private String Id;
	private String PostId;
	private String VoteTypeId;
	private String VoteType;
	private String CreationDate;

	private String UserId = null;
	private String BountyAmount = null;
	
	public Votes(){
		
	}

	public Votes(String id, String postId, String voteTypeId, String creationDate) {
		super();
		Id = id;
		PostId = postId;
		VoteTypeId = voteTypeId;
		CreationDate = creationDate;
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

	public String getVoteTypeId() {
		return VoteTypeId;
	}

	public void setVoteTypeId(String voteTypeId) {
		VoteTypeId = voteTypeId;
	}

	public String getCreationDate() {
		 return CreationDate;
	}

	public void setCreationDate(String creationDate) {
		CreationDate = creationDate;
	}
	
	public String getVoteType(String votetypeid){

		switch (votetypeid){
		case "1":  VoteType = "AcceptedByOriginator"; break;
		case "2":  VoteType = "UpMOd"; break;
		case "3":  VoteType = "DownMod"; break;
		case "4":  VoteType = "Offensive"; break;
		case "5":  VoteType = "Favorite"; break;
		case "6":  VoteType = "Close"; break;
		case "7":  VoteType = "Reopen"; break;
		case "8":  VoteType = "BountyStart"; break;
		case "9":  VoteType = "BountyClose"; break;
		case "10":  VoteType = "Deletion"; break;
		case "11":  VoteType = "Undeletion"; break;
		case "12":  VoteType = "Spam"; break;
		case "13":  VoteType = "InfromModerator"; break;
		
		}
		return VoteType;
	}
	
	public String getUserId() {
		 return UserId;
	}

	public void setUserId(String userid) {
		UserId = userid;
	}
	
	public String getBountyAmount() {
		 return BountyAmount;
	}

	public void setBountyAmount(String bountyamount) {
		BountyAmount = bountyamount;
	}
}
