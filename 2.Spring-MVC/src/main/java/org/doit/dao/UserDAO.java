package org.doit.dao;

import org.doit.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * @author Aidar Shaifutdinov.
 */
@Component
public class UserDAO {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    public List<User> getAll() {
        return jdbcTemplate.query(
                "select * from users",
                new BeanPropertyRowMapper<>(User.class)
        );
    }

    public User getOne(String email) {
        return jdbcTemplate.query(
                "select * from users where email = ?",
                new Object[] { email },
                new BeanPropertyRowMapper<>(User.class)
        ).stream().findAny().orElse(null);
    }

    public void add(User user) {
        jdbcTemplate.update(
                "insert into users values(?, ?, ?)",
                user.getName(), user.getSurname(), user.getEmail()
        );
    }

}
