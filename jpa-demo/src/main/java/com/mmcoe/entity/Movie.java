package com.mmcoe.entity;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity @Table(name = "movies")
public class Movie {
	@Id @Column(name = "mid")
	private int movId;
	@Column(length = 30)
	private String title;
	@Column(length = 12)
	private String genre;
	
	@OneToMany(mappedBy = "movie", fetch = FetchType.EAGER)
	private List<Song> songs = new ArrayList<Song>();
	
	@ManyToMany
	@JoinTable(name = "showtime", joinColumns = {@JoinColumn(name = "mid")},
			inverseJoinColumns = {@JoinColumn(name = "cid")})
	private List<Cinema> cinemas = new ArrayList<Cinema>();
	
	public Movie() {
	}
	public Movie(int movId, String title, String genre) {
		this.movId = movId;
		this.title = title;
		this.genre = genre;
	}
	
	@Override
	public String toString() {
		return "Movie [Id=" + movId + ", Title=" + title + ", Genre=" + genre + "]";
	}
	
	public int getMovId() {
		return movId;
	}
	public void setMovId(int movId) {
		this.movId = movId;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getGenre() {
		return genre;
	}
	public void setGenre(String genre) {
		this.genre = genre;
	}
	public List<Song> getSongs() {
		return songs;
	}
	public void setSongs(List<Song> songs) {
		this.songs = songs;
	}
	public List<Cinema> getCinemas() {
		return cinemas;
	}
	public void setCinemas(List<Cinema> cinemas) {
		this.cinemas = cinemas;
	}
}
