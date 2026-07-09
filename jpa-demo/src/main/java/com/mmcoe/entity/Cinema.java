package com.mmcoe.entity;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

@Entity @Table(name = "cinemas")
public class Cinema {
	@Id @Column(name = "cid")
	private int cinId;
	@Column(name = "cname", length = 30)
	private String name;
	@Column(length = 20)
	private String location;
	
	@ManyToMany 
	@JoinTable(name = "showtime", joinColumns = {@JoinColumn(name = "cid")}, 
		inverseJoinColumns = {@JoinColumn(name = "mid")})
	private List<Movie> movies = new ArrayList<Movie>();
	
	public Cinema() {
	}
	public Cinema(int cinId, String name, String location) {
		this.cinId = cinId;
		this.name = name;
		this.location = location;
	}

	@Override
	public String toString() {
		return "Cinema [Id=" + cinId + ", Name=" + name + ", Location=" + location + "]";
	}
	
	public int getCinId() {
		return cinId;
	}
	public void setCinId(int cinId) {
		this.cinId = cinId;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getLocation() {
		return location;
	}
	public void setLocation(String location) {
		this.location = location;
	}
	public List<Movie> getMovies() {
		return movies;
	}
	public void setMovies(List<Movie> movies) {
		this.movies = movies;
	}
}
