package com.rafaelamaral.coursespringbootdemo.service;

import com.rafaelamaral.coursespringbootdemo.model.User;
import com.rafaelamaral.coursespringbootdemo.repository.UserRepository;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {

    @Autowired
    private UserRepository repository;


    public List<User> listAll(){
        return repository.findAll();
    }

    public User save(User user){
        return repository.save(user);

    }

    public User findById(Long id){
        User userFound = repository.findById(id).get();

        if(userFound.getId() == null){
             new EmptyResultDataAccessException(1);
        }
        return userFound;
    }

    public void delete(Long id){
        repository.deleteById(id);
    }

    public User update(User user , Long id){
        User userFound = findById(id);
        BeanUtils.copyProperties(user , userFound , "id");
        return repository.save(userFound);

    }

    public List<User> findByName(String name){
        return repository.findByName(name.trim().toUpperCase());

    }


}
