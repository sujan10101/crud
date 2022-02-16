package com.example.carryapp.dao;

import com.example.carryapp.entity.User;

import java.util.List;

public interface UserDao {

    public List<User> findAll();

    public User findById(int id);

    public int deleteById(int id);

    public int save(User e);

    public int update(User e, int id);
}
