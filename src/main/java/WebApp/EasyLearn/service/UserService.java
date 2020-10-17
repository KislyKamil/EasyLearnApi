package WebApp.EasyLearn.service;

import WebApp.EasyLearn.model.AuthUserDetails;
import WebApp.EasyLearn.model.User;
import WebApp.EasyLearn.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;


import java.util.List;


@Service
public class UserService implements UserDetailsService {

    @Autowired
    private UserRepository userRepository;


    public void addUser(User user) {

        userRepository.save(user);
    }

    public List<User> findUsersByName(String username) {

        return userRepository.findUsersByUsername(username);
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        User user = userRepository.findUserByUsername(username);

        return new AuthUserDetails(user);
    }
}
