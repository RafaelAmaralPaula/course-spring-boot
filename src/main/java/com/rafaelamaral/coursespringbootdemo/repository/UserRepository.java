package com.rafaelamaral.coursespringbootdemo.repository;

import com.rafaelamaral.coursespringbootdemo.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserRepository extends JpaRepository<User,Long> {

    @Query("SELECT u FROM User u WHERE upper(trim(u.name)) LIKE %?1% ")
   public List<User> findByName(String name);
}
