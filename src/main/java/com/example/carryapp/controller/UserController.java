package com.example.carryapp.controller;

import com.example.carryapp.dao.UserDao;
import com.example.carryapp.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
public class UserController {

    @Autowired
    private UserDao eDAO;

    @GetMapping("/users")
    public List<User> findAll() {
        return eDAO.findAll();    /* Get all users */
    }

//    @GetMapping("/users/{id}")
//    public User findById(@PathVariable int id) {
//        return eDAO.findById(id);
//    }

    @DeleteMapping("/users/{id}")
    public String deleteById(@PathVariable int id) {
        return eDAO.deleteById(id)+" User(s) delete from the database";  /* Delete a user */
    }


    @PostMapping("/users")
    public String save(@RequestBody User e) {
        return eDAO.save(e)+" User(s) saved successfully";   /* Post a new user */
    }

    @PutMapping("/users/{id}")
    public String update(@RequestBody User e, @PathVariable int id) {
        return eDAO.update(e, id)+" User(s) updated successfully";  /* Update a user */
    }

}
