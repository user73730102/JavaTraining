package com.mmcoe.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity @Table(name = "players")
public class Player {
	@Id @Column(name = "jno")
	private int jerseyNo;
	@Column(name = "pname", length = 30)
	private String playerName;
	@Column(name = "p_role", length = 20)
	private String role;
	@Column(name = "bid_amt")
	private double bidAmount;
	
	@ManyToOne
	@JoinColumn(name = "code")
	private Team team;
	
	public Player() {
	}
	public Player(int jerseyNo, String playerName, String role, double bidAmount) {
		this.jerseyNo = jerseyNo;
		this.playerName = playerName;
		this.role = role;
		this.bidAmount = bidAmount;
	}
	
	@Override
	public String toString() {
		return "Player [jerseyNo=" + jerseyNo + ", playerName=" + playerName + ", role=" + role + ", bidAmount="
				+ bidAmount + "]";
	}
	
	// Getters & Setters
	public int getJerseyNo() {
		return jerseyNo;
	}
	public void setJerseyNo(int jerseyNo) {
		this.jerseyNo = jerseyNo;
	}
	public String getPlayerName() {
		return playerName;
	}
	public void setPlayerName(String playerName) {
		this.playerName = playerName;
	}
	public String getRole() {
		return role;
	}
	public void setRole(String role) {
		this.role = role;
	}
	public double getBidAmount() {
		return bidAmount;
	}
	public void setBidAmount(double bidAmount) {
		this.bidAmount = bidAmount;
	}
	public Team getTeam() {
		return team;
	}
	public void setTeam(Team team) {
		this.team = team;
	}
}
