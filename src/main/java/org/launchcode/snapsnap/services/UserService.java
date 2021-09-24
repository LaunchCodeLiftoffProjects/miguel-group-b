package org.launchcode.snapsnap.services;

import org.launchcode.snapsnap.models.Product;
import org.launchcode.snapsnap.models.data.UserRepository;
import org.launchcode.snapsnap.users.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    public User getUserById(Integer userId){
        return userRepository.getUserById(userId);
    }

}
