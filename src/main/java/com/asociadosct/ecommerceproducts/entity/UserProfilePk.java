package com.asociadosct.ecommerceproducts.entity;

import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Embeddable;

@Data
@Embeddable
public class UserProfilePk {

    private static final long serialVersionUID = 1L;

    @Column(name = "user_id")
    private Integer userId;

    @Column(name = "profile_id")
    private Integer profileId;
}