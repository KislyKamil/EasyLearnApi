package WebApp.EasyLearn.service;

import WebApp.EasyLearn.model.UserDetail;
import WebApp.EasyLearn.repository.UserDetailRepository;
import WebApp.EasyLearn.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class DetailService {


    @Autowired
    private UserDetailRepository userDetailRepository;

    public void addDetail(UserDetail detail) {

        userDetailRepository.save(detail);
    }

    public boolean isUserExists(int id) {

        return userDetailRepository.existsByUserid(id);
    }

    public UserDetail getUserDetail(int userID){

        return userDetailRepository.findByUserid(userID);
    }

}
