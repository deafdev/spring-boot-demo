package com.deafdev.springboot.demo.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class VisaBookingDTO {
    String address;
    Integer noOfPax;
    Long applicationDate;
    Long userId;
}