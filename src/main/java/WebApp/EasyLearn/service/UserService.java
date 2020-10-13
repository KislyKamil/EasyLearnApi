package WebApp.EasyLearn.service;

import WebApp.EasyLearn.model.AuthUserDetails;
import WebApp.EasyLearn.model.User;
import WebApp.EasyLearn.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Optional;

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
        var user = userRepository.findUserByUsername(username);

        return new AuthUserDetails(user);
    }
}
