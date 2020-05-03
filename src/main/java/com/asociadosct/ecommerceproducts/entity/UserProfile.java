package com.asociadosct.ecommerceproducts.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "userprofile")
@Data
@NoArgsConstructor
public class UserProfile implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "userprofile_id")
    private Integer userProfileId;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id", unique = true)
    @JsonIgnore
    private User user;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "profile_id", unique = true)
    //@JsonRawValue
    //@JsonRootName(value = "profile")
    private Profile profile;

    //@EmbeddedId
    //private UserProfilePk userProfilePk;

   /* @ManyToOne
    @MapsId("user_id")
    @JoinColumn(name = "user_id")
    private User user;

    @ManyToOne
    @MapsId("profile_id")
    @JoinColumn(name = "profile_id")
    private Profile profile;*/

    @Column(name = "status")
    private boolean status;

}