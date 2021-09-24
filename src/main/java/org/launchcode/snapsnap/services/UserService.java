package org.launchcode.snapsnap.services;

import org.launchcode.snapsnap.models.data.UserRepository;
import org.launchcode.snapsnap.users.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpSession;
import java.util.Optional;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    private static final String userSessionKey = "user";


    public User getUserById(Integer userId){
        return userRepository.getUserById(userId);
    }

    public User getUserFromSession(HttpSession session){
        Integer userId = (Integer) session.getAttribute(userSessionKey);
        if (userId == null) {
            return null;
        }

        Optional<User> user = userRepository.findById(userId);

        if (user.isEmpty()) {
            return null;
        }

        return user.get();
    }
}
