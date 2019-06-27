package com.deafdev.springboot.demo.resource;

import com.deafdev.springboot.demo.model.VisaBookingDTO;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultHandlers;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import static org.junit.Assert.*;


@SpringBootTest
@RunWith(SpringRunner.class)
@AutoConfigureMockMvc
public class VisaBookingResourceTest {

    @Autowired
    MockMvc mockMvc;

    @Test
    public void shouldCreateVisaBooking() throws Exception {

        VisaBookingDTO visaBookingDTO = VisaBookingDTO.builder().applicationDate(System.currentTimeMillis()).noOfPax(2).address("Abc").userId(1L).build();

        ObjectMapper objectMapper=new ObjectMapper();
        String writeValueAsString=objectMapper.writeValueAsString(visaBookingDTO);
        mockMvc.perform(MockMvcRequestBuilders.post("/visa-booking")
                .accept(MediaType.APPLICATION_JSON_UTF8)
                .contentType(MediaType.APPLICATION_JSON)
                .content(writeValueAsString)).andExpect(MockMvcResultMatchers.status().isCreated())
                .andDo(MockMvcResultHandlers.print());
    }

}