package com.test.everis;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.web.context.WebApplicationContext;

@RunWith(SpringRunner.class)
//@SpringBootTest
@WebMvcTest(EverisApplication.class)
public class EverisApplicationTests {

	final String BASE_URL = "http://localhost:8080/";

    @Autowired
    private WebApplicationContext wac;

    private MockMvc mockMvc;

    @Before
    public void setup() {
        //this.mockMvc = MockMvcBuilders.webAppContextSetup(this.wac).build();
    }

      @Test
      public void testHome() throws Exception {
    	 // mockMvc.perform(null);

      }

      @Test
      public void contextLoads() {
      }
}
