/**
 *
 */
package com.example.demo2;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author goobar
 *
 */
@RequestMapping(value = "/api/movies")
@RestController
public class MovieController
{
	private final MovieRepository repostiory;

	@Autowired
	public MovieController(MovieRepository repository)
	{
		super();
		repostiory = repository;
	}

	@CrossOrigin
	@RequestMapping(method = RequestMethod.POST)
	public void addMovie(@RequestBody Movie movie)
	{
		repostiory.save(movie);
	}

	@CrossOrigin
	@RequestMapping(method = RequestMethod.GET)
	public List<Movie> getMovies()
	{
		return repostiory.findAll();
	}
}
