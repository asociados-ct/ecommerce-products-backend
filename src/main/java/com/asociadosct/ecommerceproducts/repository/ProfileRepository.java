package com.asociadosct.ecommerceproducts.repository;

import com.asociadosct.ecommerceproducts.entity.Profile;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProfileRepository extends JpaRepository<Profile, Integer> {
}
