package com.example.Domain;

public class Baseballteam {
	/** ID */
	private Integer id;
	/** リーグ名 */
	private String league;
	/** チーム名 */
	private String teamName;
	/** ホーム球場 */
	private String headquarters;
	/** 球団創立日 */
	private String inauguration;
	/** 球団史 */
	private String history;

	@Override
	public String toString() {
		return "Baseballteam [id=" + id + ", league=" + league + ", teamName=" + teamName + ", headquarters="
				+ headquarters + ", inauguration=" + inauguration + ", hostory=" + history + "]";
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getLeague() {
		return league;
	}

	public void setLeague(String league) {
		this.league = league;
	}

	public String getTeamName() {
		return teamName;
	}

	public void setTeamName(String teamName) {
		this.teamName = teamName;
	}

	public String getHeadquarters() {
		return headquarters;
	}

	public void setHeadquarters(String headquarters) {
		this.headquarters = headquarters;
	}

	public String getInauguration() {
		return inauguration;
	}

	public void setInauguration(String inauguration) {
		this.inauguration = inauguration;
	}

	public String getHistory() {
		return history;
	}

	public void setHistory(String hostory) {
		this.history = hostory;
	}

}
