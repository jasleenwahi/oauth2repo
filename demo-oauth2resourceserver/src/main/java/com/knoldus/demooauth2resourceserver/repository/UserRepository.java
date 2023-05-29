package com.knoldus.demooauth2resourceserver.repository;

import com.knoldus.demooauth2resourceserver.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User, Integer> {

}
