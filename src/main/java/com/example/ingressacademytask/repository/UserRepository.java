package com.example.ingressacademytask.repository;

import com.example.ingressacademytask.domains.UserAuthEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UserRepository extends JpaRepository<UserAuthEntity,Long> {
   Optional<UserAuthEntity> findUserByEmail(String email);
   void deleteUserAuthEntitiesByEmail(String email);


}
