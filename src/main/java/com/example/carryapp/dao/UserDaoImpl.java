package com.example.carryapp.dao;

import com.example.carryapp.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class UserDaoImpl implements UserDao {

        @Autowired
        JdbcTemplate jdbcTemplate;

        @Override
        public List<User> findAll() {
            return jdbcTemplate.query("SELECT * FROM table_user", new BeanPropertyRowMapper<User>(User.class));
        }

        @Override
        public User findById(int id) {
            return jdbcTemplate.queryForObject("SELECT * FROM table_user WHERE id=?", new BeanPropertyRowMapper<User>(User.class), id);
        }

        @Override
        public int deleteById(int id) {
            return jdbcTemplate.update("DELETE FROM table_user WHERE id=?", id);
        }

        @Override
        public int save(User e) {
            return jdbcTemplate.update("INSERT INTO table_user (name, emailId, mobileNumber) VALUES (?, ?, ?)", new Object[] {e.getName(), e.getEmailId(), e.getMobileNumber()});
        }

        @Override
        public int update(User e, int id) {
            return jdbcTemplate.update("UPDATE tbl_employees SET name = ?, emailId = ?, mobileNumber = ? WHERE id = ?", new Object[] {e.getName(), e.getEmailId(), e.getMobileNumber(), id});
        }

    }

