package com.escape.dongnae.model;

interface PlayerInfoInterface {
	/* -------------------- Setter/Getter -------------------- */
	public abstract void setStartTime(String startTime);
	public abstract void setEndTime(String endTime);
	public abstract void setComprehension(byte comprehension);
	public abstract void setLeftSeconds(short leftSeconds);
	public abstract void setItem(String item);
	public abstract void setCode(String code);
	public abstract void setSolvedRooms(boolean[] solvedRooms);
	public abstract void setSolvedObjects(boolean[][] solvedObjects);
	public abstract void setSuccessful(boolean successful);
	public abstract String getId();
	public abstract String getStartTime();
	public abstract String getEndTime();
	public abstract String getName();
	public abstract byte getComprehension();
	public abstract short getLeftSeconds();
	public abstract String getItem();
	public abstract String getCode();
	public abstract boolean[] getSolvedRooms();
	public abstract boolean[][] getSolvedObjests();
	public abstract boolean getSuccessful();
	/* ------------------------------------------------------- */
}

// 플레이어의 정보를 관리하는 모델
public class PlayerInfo implements PlayerInfoInterface {
	private String id; // ID
	private String startTime; // 접속 시간
	private String endTime; // 종료 시간

	private String name; // 이름
	private byte comprehension; // 이해도
	private short leftSeconds; // 남은 시간(초)
	private String item; // 아이템
	private String code; // 코드
	
	private boolean[] solvedRooms; // 각 방마다 방탈출을 성공했는지 여부를 나타냄.
	private boolean[][] solvedObjects; // 각 방의 오브젝트에 해당하는 문제 풀이의 성공 여부를 나타냄.
	private boolean successful; // 최종 게임 성공 여부
	
	public PlayerInfo(String id, String name) {
		this(id, "-", name);
	}
	
	public PlayerInfo(String id, String startTime, String name) {
		this(id, startTime, "-", name);
	}
	
	public PlayerInfo(String id, String startTime, String endTime, String name) {
		this.id = id;
		this.startTime = startTime;
		this.endTime = endTime;

		this.name = name;
		this.comprehension = 0;
		this.leftSeconds = 40 * 60;
		this.item = "없음";
		this.code = "-";
		
		// 초기 상태의 4개의 각 방은 해결되지 않은 상태임.
		this.solvedRooms = new boolean[4];
		for (byte i = 0; i < this.solvedRooms.length; i++)
			this.solvedRooms[i] = false;
		
		// 초기 상태의 모든 오브젝트에 해당한 문제는 풀지 않은 상태임.
		this.solvedObjects = new boolean[this.solvedRooms.length][5];
		for (byte i = 0; i < this.solvedRooms.length; i++) {
			for (byte j = 0; j < this.solvedObjects[i].length; j++)
				this.solvedObjects[i][j] = false;
		}
		// 초기 상태의 최종 게임 성공 여부는 false임.
		this.successful = false;
	}
	
	@Override
	public boolean equals(Object object) {
		return this.id.equals(((PlayerInfo)object).id);
	}
	
	@Override
	public int hashCode() {
		return id.hashCode();
	}
	
	/* -------------------- Setter/Getter -------------------- */
	public void setStartTime(String startTime) {
		this.startTime = startTime;
	}
	
	public void setEndTime(String endTime) {
		this.endTime = endTime;
	}

	public void setComprehension(byte comprehension) {
		this.comprehension = comprehension;
	}
	
	public void setLeftSeconds(short leftSeconds) {
		this.leftSeconds = leftSeconds;
	}
	
	public void setItem(String item) {
		this.item = item;
	}
	
	public void setCode(String code) {
		this.code = code;
	}
	
	public void setSolvedRooms(boolean[] solvedRooms) {
		this.solvedRooms = solvedRooms;
	}
	
	public void setSolvedObjects(boolean[][] solvedObjects) {
		this.solvedObjects = solvedObjects;
	}
	
	public void setSuccessful(boolean successful) {
		this.successful = successful;
	}
	
	public String getId() {
		return this.id;
	}
	
	public String getStartTime() {
		return this.startTime;
	}
	
	public String getEndTime() {
		return this.endTime;
	}

	public String getName() {
		return this.name;
	}
	
	public byte getComprehension() {
		return this.comprehension;
	}
	
	public short getLeftSeconds() {
		return this.leftSeconds;
	}
	
	public String getItem() {
		return this.item;
	}
	
	public String getCode() {
		return this.code;
	}
	
	public boolean[] getSolvedRooms() {
		return this.solvedRooms;
	}
	
	public boolean[][] getSolvedObjests() {
		return this.solvedObjects;
	}
	
	public boolean getSuccessful() {
		return this.successful;
	}
	/* ------------------------------------------------------- */
}