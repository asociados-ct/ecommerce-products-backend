package com.asociadosct.ecommerceproducts.service;

import com.asociadosct.ecommerceproducts.entity.Profile;
import java.util.List;

public interface IProfileService {

    List<Profile> getAll();
    void create(Profile profile);
}
