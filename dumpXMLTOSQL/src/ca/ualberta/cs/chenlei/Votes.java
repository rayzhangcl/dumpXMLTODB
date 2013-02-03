package ca.ualberta.cs.chenlei;

public class Votes {
	private int Id;
	private int PostId;
	private int VoteTypeId;
	private String VoteType;
	private String CreationDate;

	private int UserId;
	private int BountyAmount;
	
	public Votes(){
		
	}

	public Votes(int id, int postId, int voteTypeId, String creationDate) {
		super();
		Id = id;
		PostId = postId;
		VoteTypeId = voteTypeId;
		CreationDate = creationDate;
	}

	public int getId() {
		 return Id;
	}

	public void setId(int id) {
		Id = id;
	}

	public int getPostId() {
		 return PostId;
	}

	public void setPostId(int postId) {
		PostId = postId;
	}

	public int getVoteTypeId() {
		return VoteTypeId;
	}

	public void setVoteTypeId(int voteTypeId) {
		VoteTypeId = voteTypeId;
	}

	public String getCreationDate() {
		 return CreationDate;
	}

	public void setCreationDate(String creationDate) {
		CreationDate = creationDate;
	}
	
	public String getVoteType(int votetypeid){

		switch (votetypeid){
		case 1:  VoteType = "AcceptedByOriginator"; break;
		case 2:  VoteType = "UpMOd"; break;
		case 3:  VoteType = "DownMod"; break;
		case 4:  VoteType = "Offensive"; break;
		case 5:  VoteType = "Favorite"; break;
		case 6:  VoteType = "Close"; break;
		case 7:  VoteType = "Reopen"; break;
		case 8:  VoteType = "BountyStart"; break;
		case 9:  VoteType = "BountyClose"; break;
		case 10:  VoteType = "Deletion"; break;
		case 11:  VoteType = "Undeletion"; break;
		case 12:  VoteType = "Spam"; break;
		case 13:  VoteType = "InfromModerator"; break;
		
		}
		return VoteType;
	}
	
	public int getUserId() {
		 return UserId;
	}

	public void setUserId(int userid) {
		UserId = userid;
	}
	
	public int getBountyAmount() {
		 return BountyAmount;
	}

	public void setBountyAmount(int bountyamount) {
		BountyAmount = bountyamount;
	}
}
