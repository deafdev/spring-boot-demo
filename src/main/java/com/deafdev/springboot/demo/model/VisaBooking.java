package com.deafdev.springboot.demo.model;

import lombok.*;

import javax.persistence.*;
import java.util.Date;


@Table(name = "visa_booking", schema = "vsa")
@Entity

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@ToString(exclude = {"id"})
@EqualsAndHashCode(exclude = {"id"})
public class VisaBooking {

    @Id
    @GeneratedValue
    @Column(name = "id")
    Long id;

    @Column(name = "application_date")
    Long applicationDate;

    @Column(name = "no_of_pax")
    Integer noOfPax;

    @Column(name = "address")
    String address;

    @Column(name = "user_id")
    Long userId;


}
