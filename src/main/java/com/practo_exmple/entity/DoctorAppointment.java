//package com.practo_exmple.entity;
//
//import jakarta.persistence.*;
//import java.time.LocalDateTime;
//
//@Entity
//public class DoctorAppointment {
//    @Id
//    @GeneratedValue(strategy = GenerationType.IDENTITY)
//    private Long id;
//
//    @ManyToOne
//    @JoinColumn(name = "doctor_id", nullable = false)
//    private Doctor doctor;
//
//    @Column(nullable = false)
//    private LocalDateTime appointmentDateTime;
//
//    @Column(nullable = false)
//    private boolean morningSlot1Available;
//
//    @Column(nullable = false)
//    private boolean afternoonSlotAvailable;
//
//    @Column(nullable = false)
//    private boolean eveningSlot1Available;
//
//}
