package com.hn.springbootmobilestore.service.user;

import com.hn.springbootmobilestore.entity.User;
import com.hn.springbootmobilestore.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService{
    @Autowired
    UserRepository userRepository;
}
