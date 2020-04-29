package com.asociadosct.ecommerceproducts.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "userProfiles")
@Data // genera todos los getter, setters
@AllArgsConstructor
@NoArgsConstructor
public class User {

    private static final long serialVersionUID = 1L;

    @Id
    @Column(name = "user_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer userId;

    @Column(name = "username", length = 30)
    private String username;

    @Column(name = "password", length = 40)
    private String password;

    @OneToMany(mappedBy = "user", fetch = FetchType.LAZY)
    private List<UserProfile> userProfiles;
}
