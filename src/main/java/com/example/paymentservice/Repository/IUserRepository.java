package com.example.paymentservice.Repository;

import com.example.paymentservice.Entity.User;

import java.util.List;

public interface IUserRepository {

    User findById(Long id);
    List<User> findAll();
    User findByPhoneNumber(String phoneNumber);
    User findByMobile(String mobile);
}
