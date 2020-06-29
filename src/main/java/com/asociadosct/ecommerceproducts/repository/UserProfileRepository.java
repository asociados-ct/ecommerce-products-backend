package com.asociadosct.ecommerceproducts.repository;

import com.asociadosct.ecommerceproducts.entity.UserProfile;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserProfileRepository extends JpaRepository<UserProfile, Integer> {

    Page<UserProfile> findByUserProfileId(Integer userprofileId, Pageable pageable);
}
