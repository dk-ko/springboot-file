package com.example.filedemo;

import org.springframework.boot.SpringBootConfiguration;
//import org.springframework.boot.test.SpringApplicationConfiguration;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import org.jboss.logging.Logger;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.mock.web.MockMultipartFile;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.web.context.WebApplicationContext;

import com.example.filedemo.controller.ArticlesController;
import com.example.filedemo.service.ArticlesService;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import static org.springframework.test.web.servlet.setup.MockMvcBuilders.webAppContextSetup;

@RunWith(SpringJUnit4ClassRunner.class)
//@SpringApplicationConfiguration(classes = Application.class)
//@SpringBootConfiguration
@org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest(ArticlesController.class)
@WebAppConfiguration
public class ArticleFileUploadTest {
	
	Logger logger = Logger.getLogger(this.getClass());
	
	private MockMvc mvc;
	
	@Autowired
    private ArticlesController articlesController;

    @Autowired
    private ArticlesService articlesService;

	@Autowired
    private WebApplicationContext wac;
	
	@Before
	public void setUp() throws Exception {
		mvc = webAppContextSetup(wac).build();
	}
	
	private String jsonStringFromObject(Object object) throws JsonProcessingException {
		ObjectMapper mapper = new ObjectMapper();
		return mapper.writeValueAsString(object);
	}
	

	@Test
	public void testSubmit() throws Exception {
		MockMultipartFile file = new MockMultipartFile("file", "filename.txt", "text/plain",
				"some xml".getBytes());
		
		MvcResult result = mvc.perform(
//				multipart("/articles").file(file)
				fileUpload("/articles").file(file)
				.param("title", "test title")
				.param("content", "test contecnt"))
				.andExpect(status().isOk())
				.andExpect(content().contentTypeCompatibleWith(MediaType.APPLICATION_JSON))
				.andReturn();
		
		
		logger.info(result.getResponse().getContentAsString());
				
	}
}
