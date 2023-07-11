package com.goit.module15_hw_sprinbootsecurity.repository;

import com.goit.module15_hw_sprinbootsecurity.entity.UserAccountEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserAccountRepository extends JpaRepository<UserAccountEntity, Long> {

    UserAccountEntity findUserAccountEntityByUsername(String username);

    void deleteByUsername(String username);

}
