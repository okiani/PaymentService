package com.example.paymentservice.service;

import com.example.paymentservice.dto.UserDto;

public interface IUserService {

    UserDto findById(Long id);

    UserDto loadCurrentUser();
}
