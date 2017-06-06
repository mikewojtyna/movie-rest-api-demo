package com.example.demo2;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.Matchers.hasSize;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.security.test.context.support.WithMockUser;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.annotation.DirtiesContext.ClassMode;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

@RunWith(SpringRunner.class)
@SpringBootTest
@AutoConfigureMockMvc
@DirtiesContext(classMode = ClassMode.AFTER_EACH_TEST_METHOD)
public class Demo2ApplicationTests
{
	@Autowired
	private MockMvc mockMvc;

	@Test
	@WithMockUser
	public void should_AddNewMovie() throws Exception
	{
		// given
		String movieAsJson = "{ \"title\": \"Guardians of the Galaxy vol. 2\", \"director\": { \"name\": \"James Cameron\" } }";

		// when
		mockMvc.perform(post("/api/movies")
			.contentType(MediaType.APPLICATION_JSON_UTF8)
			.content(movieAsJson))

			// then
			.andExpect(status().isOk()).andDo(print());
		mockMvc.perform(get("/api/movies")).andExpect(status().isOk())
			.andExpect(jsonPath("$", hasSize(1)))
			.andExpect(jsonPath("$[0].title",
				is("Guardians of the Galaxy vol. 2")))
			.andExpect(jsonPath("$[0].director.name",
				is("James Cameron")))
			.andDo(print());
	}

}
