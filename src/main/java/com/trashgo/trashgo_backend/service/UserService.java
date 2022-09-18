package com.trashgo.trashgo_backend.service;

import com.trashgo.trashgo_backend.domain.model.User;
import com.trashgo.trashgo_backend.domain.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {

    @Autowired
    UserRepository userRespository;

    public User findById(Long id){
        return userRespository.findById(id).get();
    }

    public List<User> findAll(){
        return userRespository.findAll();
    }

    // 2. 레파지토리의 세이브 메서드를 불러서 save 메서드 만들기
    public User save(User user) {return  userRespository.save(user);}

    public User findByEmailAndPassword(String email, String password) {
        User user = null;
        if (userRespository.findByEmailAndPassword(email, password).isPresent()) {
            user = userRespository.findByEmailAndPassword(email, password).get();
        }
        return user;
    }
}
