package com.ehliyet.sinav.repository;

import com.ehliyet.sinav.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {
    
    Optional<User> findByUsername(String username);
    
    Optional<User> findByEmail(String email);
    
    Optional<User> findByTcNo(String tcNo);
    
    boolean existsByUsername(String username);
    
    boolean existsByEmail(String email);
    
    boolean existsByTcNo(String tcNo);
    
    List<User> findByRolesContaining(String role);
    
    List<User> findByEnabledTrue();
}
