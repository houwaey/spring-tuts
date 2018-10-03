package com.hibernate.test.controllers;

import static org.junit.Assert.*;
import static org.mockito.Mockito.*;
import static org.hamcrest.Matchers.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;
import static com.jayway.jsonpath.matchers.JsonPathMatchers.*;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.sql.Date;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import com.h2h.builder.ClassBuilder;
import com.h2h.configuration.WebConfiguration;
import com.h2h.model.WebUser;
import com.h2h.util.Constant;
import com.hibernate.test.utils.TestUtil;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = { WebConfiguration.class } )
@WebAppConfiguration
public class UserControllerTest {

	private MockMvc mockMvc;
	
	@Autowired
	private WebApplicationContext webApplicationContext;
	
	@Before
	public void setUp() {
		mockMvc = MockMvcBuilders.webAppContextSetup(webApplicationContext).build();
	}
	
	/* TODO: fix post request */
	/*@Test
	public void createWebUser_CREATED() throws IOException, Exception {
		WebUser webUser = new ClassBuilder<WebUser>(new WebUser())
								.setField("username", "paulo")
								.setField("password", "pass1")
								.setField("email", "test@email.com")
								.setField("birthDate", LocalDate.parse("15/01/2010", DateTimeFormatter.ofPattern("d/MM/yyyy")))
								.setField("status", Constant.ACTIVE)
								.build();
									
		String jsonResult = mockMvc.perform(
											post("/user/web/create")
												.contentType(TestUtil.APPLICATION_JSON_UTF8)
												.content(TestUtil.convertObjectToJsonBytes(webUser))
										)
											.andExpect(status().isOk())
											.andExpect(content().contentType(TestUtil.APPLICATION_JSON_UTF8))
											.andReturn()
												.getResponse()
												.getContentAsString();
		System.out.println(jsonResult);
		assertThat(jsonResult, hasJsonPath("$.code", is(HttpStatus.CREATED.value())));
		assertThat(jsonResult, hasJsonPath("$.message", is(HttpStatus.CREATED.getReasonPhrase())));
		assertThat(jsonResult, hasJsonPath("$.data", nullValue()));
		assertThat(jsonResult, hasJsonPath("$.fieldErrors",  nullValue()));
	}*/
	
	@Test
	public void findAllWebUsers_OK() throws UnsupportedEncodingException, Exception {
		String jsonResult = mockMvc.perform(
										get("/user/web/all")
									)
										.andExpect(status().isOk())
										.andExpect(content().contentType(TestUtil.APPLICATION_JSON_UTF8))
										.andReturn()
											.getResponse()
											.getContentAsString();

		assertThat(jsonResult, hasJsonPath("$.code", is(HttpStatus.OK.value())));
		assertThat(jsonResult, hasJsonPath("$.message", is(HttpStatus.OK.getReasonPhrase())));
		assertThat(jsonResult, hasJsonPath("$.fieldErrors", nullValue()));
		assertThat(jsonResult, hasJsonPath("$.data[0].id", is(equalTo(1))));
		assertThat(jsonResult, hasJsonPath("$.data[0].username", is("paulo")));
		assertThat(jsonResult, hasJsonPath("$.data[0].password", is("pass1")));
		assertThat(jsonResult, hasJsonPath("$.data[0].email", is("test@email.com")));
		assertThat(jsonResult, hasJsonPath("$.data[0].status", is("ACTIVE")));
	}

}
