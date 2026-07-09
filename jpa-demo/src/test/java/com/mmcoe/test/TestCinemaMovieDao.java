package com.mmcoe.test;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.List;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import com.mmcoe.dao.CinemaMovieDao;
import com.mmcoe.entity.Cinema;
import com.mmcoe.entity.Movie;

public class TestCinemaMovieDao {
	private static CinemaMovieDao dao;
	
	@BeforeAll
	public static void setup() {
		dao = new CinemaMovieDao();
	}
	
	@Test
	public void testSaveMovie() {
		Movie m = new Movie(212, "Inception", "SciFi");
		assertNotNull(dao.save(m));
	}
	
	@Test
	public void testSaveCinema() {
		Cinema c = new Cinema(903, "Citypolis", "Thane");
		assertNotNull(dao.save(c));
	}
	
	@Test
	public void testAddMovieToCinema() {
		assertTrue(dao.addMovieToCinema(221, 903));
	}
	
	@Test
	public void testFindByMovieTitle() {
		List<Cinema> cinemas = dao.findByMovieTitle("Avatar");
		assertFalse(cinemas.isEmpty());
		cinemas.forEach(System.out::println);
	}
	
	@Test
	public void testFindByGenre() {
		List<Movie> movies = dao.findByGenre("SciFi");
		assertFalse(movies.isEmpty());
		movies.forEach(System.out::println);
	}
	
	@Test
	public void testFindByLocation() {
		List<Cinema> cinemas = dao.findByLocation("Pune");
		assertFalse(cinemas.isEmpty());
		cinemas.forEach(System.out::println);
	}
	
	@Test
	public void testFindMovieByLocation() {
		List<Movie> movies = dao.findMovieByLocation("Pune");
		assertFalse(movies.isEmpty());
		movies.forEach(System.out::println);
	}
}
