/**
 *
 */
package com.example.demo2;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

/**
 * @author goobar
 *
 */
@Document
public class Movie
{
	private Director director;

	@Id
	private String title;

	/**
	 * @return the director
	 */
	public Director getDirector()
	{
		return director;
	}

	/**
	 * @return the title
	 */
	public String getTitle()
	{
		return title;
	}

	/**
	 * @param director
	 *                the director to set
	 */
	public void setDirector(Director director)
	{
		this.director = director;
	}

	/**
	 * @param title
	 *                the title to set
	 */
	public void setTitle(String title)
	{
		this.title = title;
	}
}
