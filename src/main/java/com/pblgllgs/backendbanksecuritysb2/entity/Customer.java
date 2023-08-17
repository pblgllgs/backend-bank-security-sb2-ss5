package com.pblgllgs.backendbanksecuritysb2.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.Set;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Customer {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(
            name = "customer_id"
    )
    private int id;
    private String name;
    private String email;
    @Column(
            name = "mobile_number"
    )
    private String mobileNumber;
    @JsonIgnore
    private String pwd;
    private String role;
    @Column(
            name = "create_dt"
    )
    private String createDt;

    @JsonIgnore
    @OneToMany(mappedBy = "customer",fetch = FetchType.EAGER)
    private Set<Authority> authorities;
}
