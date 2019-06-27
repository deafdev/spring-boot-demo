package com.deafdev.springboot.demo.service;


import com.deafdev.springboot.demo.model.VisaBooking;
import com.deafdev.springboot.demo.model.VisaBookingDTO;
import com.deafdev.springboot.demo.repository.VisaBookingRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class VisaService {

    @Autowired
    VisaBookingRepository visaBookingRepository;

    public boolean save(VisaBookingDTO visaBookingDTO) {
        VisaBooking visaBooking = new VisaBookingTransformer().transform(visaBookingDTO);
        VisaBooking saved = visaBookingRepository.save(visaBooking);
        return saved != null;
    }

    private class VisaBookingTransformer extends VisaBooking {
        public VisaBookingTransformer() {

        }

        public VisaBooking transform(VisaBookingDTO visaBookingDTO) {
            return VisaBooking.builder()
                    .address(visaBookingDTO.getAddress())
                    .applicationDate(visaBookingDTO.getApplicationDate())
                    .noOfPax(visaBookingDTO.getNoOfPax())
                    .userId(visaBookingDTO.getUserId()).build();
        }
    }
}
