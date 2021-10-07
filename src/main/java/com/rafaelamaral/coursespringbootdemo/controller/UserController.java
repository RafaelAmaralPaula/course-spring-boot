package com.rafaelamaral.coursespringbootdemo.controller;

import com.rafaelamaral.coursespringbootdemo.model.User;
import com.rafaelamaral.coursespringbootdemo.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/users")
public class UserController {

    @Autowired
    private UserService userService;

    @GetMapping
    public List<User> findAll(){
        return userService.listAll();
    }

    @PostMapping
    public ResponseEntity<User> save(@RequestBody User user){
        return ResponseEntity.status(HttpStatus.CREATED).body(userService.save(user));

    }

    @DeleteMapping
    public ResponseEntity<String> delete(@RequestParam(name = "id") Long id){
        userService.delete(id);

        return new ResponseEntity<String>("User deleted with sucess" , HttpStatus.OK);
    }

    @GetMapping("/buscarPeloId")
    public ResponseEntity<User> findById(@RequestParam(name = "id") Long id){
        User userFound = userService.findById(id);

        return ResponseEntity.ok(userFound);

    }

    @GetMapping("/buscarPeloNome")
    public List<User> findByName(@RequestParam(name = "name") String name){
        return userService.findByName(name);
    }

    @PutMapping("/{id}")
    public ResponseEntity<User> update(@RequestBody User user , @PathVariable Long id ){
        User userUpdated = userService.update(user,id );
        return ResponseEntity.ok(userUpdated);
    }


}
