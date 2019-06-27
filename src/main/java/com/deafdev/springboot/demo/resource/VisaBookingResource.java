package com.deafdev.springboot.demo.resource;


import com.deafdev.springboot.demo.model.VisaBookingDTO;
import com.deafdev.springboot.demo.service.VisaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "visa-booking")
public class VisaBookingResource {

    @Autowired
    VisaService visaService;

    @PostMapping
    @RequestMapping(produces = MediaType.APPLICATION_JSON_UTF8_VALUE, consumes = MediaType.APPLICATION_JSON_UTF8_VALUE)
    ResponseEntity createVisaVisaBooking(VisaBookingDTO visaBookingDTO) throws VisaBookingCreateException {
        boolean saved = visaService.save(visaBookingDTO);
        if (!saved) {
            throw new VisaBookingCreateException();
        } else {
            return ResponseEntity.status(HttpStatus.CREATED).build();
        }
    }

    private static class VisaBookingCreateException extends Throwable {
    }
}
