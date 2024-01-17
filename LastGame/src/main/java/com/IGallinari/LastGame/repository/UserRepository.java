package com.IGallinari.LastGame.repository;

import com.IGallinari.LastGame.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User,Integer> {

    User findById(int idUser);

    User findByEmail(String email);

    boolean existsByEmail(String email);
}
