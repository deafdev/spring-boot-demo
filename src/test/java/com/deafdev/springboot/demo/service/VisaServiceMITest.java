package com.deafdev.springboot.demo.service;

import com.deafdev.springboot.demo.model.VisaBooking;
import com.deafdev.springboot.demo.model.VisaBookingDTO;
import com.deafdev.springboot.demo.repository.VisaBookingRepository;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.assertj.core.api.Assertions;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;


@SpringBootTest
@RunWith(SpringRunner.class)
public class VisaServiceMITest {

    @Autowired
    VisaService visaService;

    @Autowired
    VisaBookingRepository visaBookingRepository;

    @Test
    public void shouldSaveVisaBooking() {
        //Given
        VisaBookingDTO visaBookingDTO = VisaBookingDTO.builder().applicationDate(System.currentTimeMillis()).noOfPax(2).address("Abc").userId(1L).build();

        //When
        visaService.save(visaBookingDTO);

        //Then
        VisaBooking expectedVisaBooking = VisaBooking.builder()
                .address(visaBookingDTO.getAddress())
                .noOfPax(visaBookingDTO.getNoOfPax())
                .userId(visaBookingDTO.getUserId())
                .applicationDate(visaBookingDTO.getApplicationDate())
                .build();

        List<VisaBooking> all = visaBookingRepository.findAll();
        Assertions.assertThat(all.isEmpty()).isFalse();
        Assertions.assertThat(all.stream().findFirst().get()).isEqualTo(expectedVisaBooking);
    }


}