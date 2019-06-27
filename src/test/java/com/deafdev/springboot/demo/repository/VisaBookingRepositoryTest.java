package com.deafdev.springboot.demo.repository;

import com.deafdev.springboot.demo.model.VisaBooking;
import org.assertj.core.api.Assertions;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Optional;


@SpringBootTest
@RunWith(SpringRunner.class)
public class VisaBookingRepositoryTest {

    @Autowired
    VisaBookingRepository visaBookingRepository;

    @Test
    public void shouldSaveAVisaBooking() {
        //Given
        VisaBooking visaBooking = VisaBooking.builder().id(1L).applicationDate(System.currentTimeMillis()).noOfPax(2).address("Abc").userId(1L).build();

        //When
        visaBookingRepository.save(visaBooking);

        //Then
        Optional<VisaBooking> optionalVisaBooking = visaBookingRepository.findById(1L);
        Assertions.assertThat(optionalVisaBooking.get()).isEqualTo(visaBooking);
    }


}