package com.rxqp.server.bo;

import com.rxqp.protobuf.DdzProto;

import java.util.Date;
import java.util.List;
import java.util.Vector;

public class Room {

	private Integer roomId;
	private List<Player> players;
	private Integer multiple = 1;// 倍率,1倍为底
	private Integer playedGames = 1;// 已经玩了几盘
	private Integer totalGames = 0;// 一共几盘
	private Integer currentPlayerId;// 当前出牌玩家
	private Integer type;// 1表示房主出房费，2表示进入房间者均摊房费 3表示赢家支付
	private List<Integer> prePokerIds;// 当前牌局中当前一轮出牌中，前一个玩家出牌的ID集合
	private Integer prePlayerId = -1;// 上一个出牌的玩家ID
	private Boolean isStartGame = false;// 是否已经开始玩游戏
	private Integer preparedPlayerCnt = 0;// 准备就绪玩家人数
	private Integer stakedPlayerCnt = 0;// 已经下注的玩家人数
	private Integer bankerId;// 庄家ID
	private DdzProto.BankerType bankerType;//庄类型，// 没有类型：BT_NONE	= 0;// 霸王庄 BT_BAWANG	= 1;// 轮庄 BT_LUNZHUANG= 2;// 转庄 BT_ZHUANZHUANG		= 3;
	private Integer showCardsPlayerCnt = 0;// 已经开牌人数
//	private Integer agreeDissolutionCnt = 1;// 同意解散房间人数,发起人是同意的
//	private Integer disAgreeDissolutionCnt = 0;// 不同意解散房间人数
	private Vector<Integer> agreeDissolutionIds = new Vector<Integer>();;//同意解散玩家ids
	private Vector<Integer> disAgreeDissulutionIds = new Vector<Integer>();;//不同意解散玩家ids
	private Date firtPlayerOffLineTime;//该房间第一位玩家离线时间
	private Integer winPlayerId;//大赢家id
	private Boolean isDisband = false;//该房间当前是否处于请求解散房间状态
	private int startDisbandTime;//请求解散房间时间点，单位是秒

	public Room() {
	}

	public void init() {
		this.multiple = 1;
		this.prePlayerId = -1;
//		this.isStartGame = false;
		this.preparedPlayerCnt = 0;
		this.stakedPlayerCnt = 0;
		this.showCardsPlayerCnt = 0;
//		this.agreeDissolutionCnt = 1;
//		this.disAgreeDissolutionCnt = 0;
		agreeDissolutionIds.clear();
		disAgreeDissulutionIds.clear();;
	}

	public Integer getRoomId() {
		return roomId;
	}

	public void setRoomId(Integer roomId) {
		this.roomId = roomId;
	}

	public List<Player> getPlayers() {
		return players;
	}

	public void setPlayers(List<Player> players) {
		this.players = players;
	}

	public Integer getMultiple() {
		return multiple;
	}

	public void setMultiple(Integer multiple) {
		this.multiple = multiple;
	}

	public Integer getPlayedGames() {
		return playedGames;
	}

	public void setPlayedGames(Integer playedGames) {
		this.playedGames = playedGames;
	}

	public Integer getTotalGames() {
		return totalGames;
	}

	public void setTotalGames(Integer totalGames) {
		this.totalGames = totalGames;
	}

	public Integer getCurrentPlayerId() {
		return currentPlayerId;
	}

	public void setCurrentPlayerId(Integer currentPlayerId) {
		this.currentPlayerId = currentPlayerId;
	}

	public Integer getType() {
		return type;
	}

	public void setType(Integer type) {
		this.type = type;
	}

	public List<Integer> getPrePokerIds() {
		return prePokerIds;
	}

	public void setPrePokerIds(List<Integer> prePokerIds) {
		this.prePokerIds = prePokerIds;
	}

	public Integer getPrePlayerId() {
		return prePlayerId;
	}

	public void setPrePlayerId(Integer prePlayerId) {
		this.prePlayerId = prePlayerId;
	}

	public Boolean getIsStartGame() {
		return isStartGame;
	}

	public void setIsStartGame(Boolean isStartGame) {
		this.isStartGame = isStartGame;
	}

	public Integer getPreparedPlayerCnt() {
		return preparedPlayerCnt;
	}

	public void setPreparedPlayerCnt(Integer preparedPlayerCnt) {
		this.preparedPlayerCnt = preparedPlayerCnt;
	}

	public synchronized void increasePreparedPlayerCnt() {
		preparedPlayerCnt++;
	}

	public Integer getBankerId() {
		return bankerId;
	}

	public void setBankerId(Integer bankerId) {
		this.bankerId = bankerId;
	}

	public Integer getShowCardsPlayerCnt() {
		return showCardsPlayerCnt;
	}

	public void setShowCardsPlayerCnt(Integer showCardsPlayerCnt) {
		this.showCardsPlayerCnt = showCardsPlayerCnt;
	}

	public synchronized void increaseShowCardsPlayerCnt() {
		showCardsPlayerCnt++;
	}

	public synchronized void increasePlayedGamesCnt() {
		playedGames++;
	}

	public Integer getStakedPlayerCnt() {
		return stakedPlayerCnt;
	}

	public void setStakedPlayerCnt(Integer stakedPlayerCnt) {
		this.stakedPlayerCnt = stakedPlayerCnt;
	}

	public synchronized void increaseStakedPlayerCnt() {
		stakedPlayerCnt++;
	}

//	public Integer getAgreeDissolutionCnt() {
//		return agreeDissolutionCnt;
//	}
//
//	public void setAgreeDissolutionCnt(Integer agreeDissolutionCnt) {
//		this.agreeDissolutionCnt = agreeDissolutionCnt;
//	}
//
//	public synchronized void increaseAgreeDissolutionCnt() {
//		agreeDissolutionCnt++;
//	}
//
//	public Integer getDisAgreeDissolutionCnt() {
//		return disAgreeDissolutionCnt;
//	}
//
//	public void setDisAgreeDissolutionCnt(Integer disAgreeDissolutionCnt) {
//		this.disAgreeDissolutionCnt = disAgreeDissolutionCnt;
//	}

	public Vector<Integer> getAgreeDissolutionIds() {
		return agreeDissolutionIds;
	}

	public void setAgreeDissolutionIds(Vector<Integer> agreeDissolutionIds) {
		this.agreeDissolutionIds = agreeDissolutionIds;
	}

	public Vector<Integer> getDisAgreeDissulutionIds() {
		return disAgreeDissulutionIds;
	}

	public void setDisAgreeDissulutionIds(Vector<Integer> disAgreeDissulutionIds) {
		this.disAgreeDissulutionIds = disAgreeDissulutionIds;
	}

	public Boolean getStartGame() {
		return isStartGame;
	}

	public void setStartGame(Boolean startGame) {
		isStartGame = startGame;
	}

	public Integer getWinPlayerId() {
		return winPlayerId;
	}

	public void setWinPlayerId(Integer winPlayerId) {
		this.winPlayerId = winPlayerId;
	}

//	public synchronized void increaseDisAgreeDissolutionCnt() {
//		disAgreeDissolutionCnt++;
//	}

	public Date getFirtPlayerOffLineTime() {
		return firtPlayerOffLineTime;
	}

	public void setFirtPlayerOffLineTime(Date firtPlayerOffLineTime) {
		this.firtPlayerOffLineTime = firtPlayerOffLineTime;
	}

	public DdzProto.BankerType getBankerType() {
		return bankerType;
	}

	public void setBankerType(DdzProto.BankerType bankerType) {
		this.bankerType = bankerType;
	}

	public Boolean getDisband() {
		return isDisband;
	}

	public void setDisband(Boolean disband) {
		isDisband = disband;
	}

	public int getStartDisbandTime() {
		return startDisbandTime;
	}

	public void setStartDisbandTime(int startDisbandTime) {
		this.startDisbandTime = startDisbandTime;
	}
}
