package com.asociadosct.ecommerceproducts.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "userprofile")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class UserProfile implements Serializable {

    private static final long serialVersionUID = 1L;

    @EmbeddedId
    private UserProfilePk userProfilePk;

    @Column(name = "status")
    private boolean status;

    @JoinColumn(name = "user_id", referencedColumnName = "user_id", insertable = false, updatable = false)
    @ManyToOne
    private User user;

    @JoinColumn(name = "profile_id", referencedColumnName = "profile_id", insertable = false, updatable = false)
    @ManyToOne
    private Profile profile;
}
