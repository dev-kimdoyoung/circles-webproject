package com.project.coupon.user;

import lombok.*;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
@Table(name = "users")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class User extends BaseTimeEntity{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "user_id")
    private Integer user_id;

    @Column(name = "student_id")
    private String student_id;

    @Column(name = "username")
    private String username;

    @Column(name = "major")
    private String major;

    @Column(name = "degree")
    private Integer degree;

    @Column(name = "phone_number")
    private String phoneNumber;

    @Column(name = "address")
    private String address;

    @Column(name = "is_paid")
    private Boolean isPaid;

    @Column(name = "is_regular_member")
    private Boolean isRegularMember;

    @Builder
    public User(String student_id, String username, String major, Integer degree, String phoneNumber, String address) {
        this.student_id = student_id;
        this.username = username;
        this.major = major;
        this.degree = degree;
        this.phoneNumber = phoneNumber;
        this.address = address;
    }
}
