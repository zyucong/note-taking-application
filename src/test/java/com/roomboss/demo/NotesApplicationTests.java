package com.roomboss.demo;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.roomboss.demo.entity.SaveRequest;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

//@ExtendWith(SpringExtension.class)
//@WebFluxTest(ServerController.class)
@SpringBootTest
@AutoConfigureMockMvc
class NotesApplicationTests {

	@Autowired
	private MockMvc mockMvc;

	private static final String SUCCESS = "success";

	@Test
	public void testSave() throws Exception {
		SaveRequest request1 = new SaveRequest("Hello, How are you " + System.currentTimeMillis());
		SaveRequest request2 = new SaveRequest("I am fine, thank you " + System.currentTimeMillis());
		ObjectMapper ojm = new ObjectMapper();

		MvcResult mvcResult1 = mockMvc.perform(MockMvcRequestBuilders.post("/server/save")
						.contentType(MediaType.APPLICATION_JSON)
						.content(ojm.writeValueAsString(request1)))
				.andExpect(MockMvcResultMatchers.status().isOk())
				.andReturn();

		MvcResult mvcResult2 = mockMvc.perform(MockMvcRequestBuilders.post("/server/save")
						.contentType(MediaType.APPLICATION_JSON)
						.content(ojm.writeValueAsString(request2)))
				.andExpect(MockMvcResultMatchers.status().isOk())
				.andReturn();

		String str1 = mvcResult1.getResponse().getContentAsString();
		String str2 = mvcResult2.getResponse().getContentAsString();

		Assertions.assertTrue(str1.equals(SUCCESS) && str2.equals(SUCCESS));
		System.out.println(SUCCESS);
	}

	@Test
	public void testQuery() throws Exception {
		// webTestClient.get().uri("/server/notes").exchange();
		MvcResult mvcResult = mockMvc.perform(MockMvcRequestBuilders.get("/server/notes"))
				.andExpect(MockMvcResultMatchers.status().isOk())
				.andReturn();
		System.out.println(mvcResult.getResponse().getContentAsString());
	}

}
