package com.freshshop.ecommerce.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.freshshop.ecommerce.model.User;

@Repository
public class UserRepository extends JpaRepository<User, Long>{

}