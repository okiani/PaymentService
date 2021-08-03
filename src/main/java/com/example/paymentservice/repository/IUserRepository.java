package com.example.paymentservice.repository;

import com.example.paymentservice.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface IUserRepository extends JpaRepository<User, Integer> {

    User findById(Long id);
    List<User> findAll();
    User findByPhoneNumber(String phoneNumber);
    User findByMobile(String mobile);
}
