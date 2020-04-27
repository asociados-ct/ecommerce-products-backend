package com.asociadosct.ecommerceproducts.entity;


import lombok.Data;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "profile")

public @Data class Profile {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "profile_id")
    private Integer profileId;

    @Column(name = "name", length = 30)
    private String name;

    @OneToMany(mappedBy = "profile", cascade = CascadeType.REFRESH, fetch = FetchType.LAZY)
    private List<User> users;

}
