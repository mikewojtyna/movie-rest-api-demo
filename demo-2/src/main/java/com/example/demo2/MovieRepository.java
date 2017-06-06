/**
 *
 */
package com.example.demo2;

import org.springframework.data.mongodb.repository.MongoRepository;

/**
 * @author goobar
 *
 */
public interface MovieRepository extends MongoRepository<Movie, String>
{

}
