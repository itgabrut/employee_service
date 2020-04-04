package com.ilya;

import com.ilya.controller.MainController;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.security.test.web.servlet.response.SecurityMockMvcResultMatchers.unauthenticated;


/**
 * Created by ilya on 04.04.2020.
 */
@RunWith(SpringRunner.class)
@WebMvcTest(MainController.class)
@ContextConfiguration(classes = org.springframework.boot.test.context.TestConfiguration.class)
public class UnitSecurityTest {


    @Autowired
    private MockMvc mockMvc;

    @Test
    public void accessProtected() throws Exception {
        this.mockMvc.perform(MockMvcRequestBuilders.get("/test"))
                .andExpect(unauthenticated())
                .andExpect(status().isUnauthorized());
    }
}
