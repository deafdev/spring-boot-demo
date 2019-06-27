package com.deafdev.springboot.demo.service;

import com.deafdev.springboot.demo.model.VisaBooking;
import com.deafdev.springboot.demo.model.VisaBookingDTO;
import com.deafdev.springboot.demo.repository.VisaBookingRepository;
import org.assertj.core.api.Assertions;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mockito;

import java.util.List;

public class VisaServiceTest {


    VisaService visaService;

    @Before
    public void setup() {
        visaService=new VisaService();
        visaService.visaBookingRepository= Mockito.mock(VisaBookingRepository.class);
    }

    @Test
    public void shouldSave() {
        //Given
        VisaBookingDTO visaBookingDTO = VisaBookingDTO.builder().applicationDate(System.currentTimeMillis()).noOfPax(2).address("Abc").userId(1L).build();

        Mockito.when(visaService.visaBookingRepository.save(Mockito.any(VisaBooking.class))).thenReturn(new VisaBooking());

        //When
        boolean saved=visaService.save(visaBookingDTO);
        Assertions.assertThat(saved).isTrue();
    }

}