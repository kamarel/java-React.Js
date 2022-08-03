package com.ecomApp.Ecom.users;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "Users")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long userId;
    private String firstName;
    private String lastName;
    private String phoneNumber;
    private String address;
    private String city;
    private String zipCode;
    private String country;
    private String email;
    private boolean isAdmin;
}
