package com.example.paymentservice.service.Impl;

import com.example.paymentservice.dto.UserDto;
import com.example.paymentservice.entity.User;
import com.example.paymentservice.exception.NotFoundException;
import com.example.paymentservice.repository.IUserRepository;
import com.example.paymentservice.service.IUserService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UserServiceImpl implements IUserService {

    @Autowired
    private ModelMapper modelMapper;

    private final IUserRepository userRepository;
    private Environment env;
    private UserDto currentUserObj;

    public UserServiceImpl(
            IUserRepository userRepository,
            Environment env
    ) {
        this.userRepository = userRepository;
        this.env = env;
    }

    @Override
    public UserDto findById(Long id) {

        Optional<User> user = userRepository.findById(id);
        if (user.isPresent()) {
            // convert entity to DTO
            return modelMapper.map(user.get(), UserDto.class);
        }
        throw new NotFoundException("Not Found User Id: " + id, 404);
    }

    @Override
    public UserDto loadCurrentUser() {
        return this.getCurrentUser();
    }

    private UserDto getCurrentUser() {

        if (env.getProperty("user_id") != null) {
            currentUserObj = this.findById(Long.valueOf(env.getProperty("user_id")));
        } /*else {
            Authentication auth = SecurityContextHolder.getContext().getAuthentication();
            currentUserObj = modelMapper.map(auth, UserDto.class);
        }*/

        return currentUserObj;
    }
}
