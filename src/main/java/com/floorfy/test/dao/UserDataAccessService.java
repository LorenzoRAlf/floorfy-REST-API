package com.floorfy.test.dao;

import com.floorfy.test.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Repository("postgres")
public class UserDataAccessService implements UserDao {

    private final JdbcTemplate jdbcTemplate;

    @Autowired
    public UserDataAccessService(JdbcTemplate jdbcTemplate){
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    public int insertUser(UUID id, User user) {
        return 0;
    }

    @Override
    public List<User> selectAllUsers() {
        final String sql = "SELECT id, email, name, phone FROM User";
        return jdbcTemplate.query(sql, (resultSet, i) -> {
            UUID id = UUID.fromString(resultSet.getString("id"));
            String email = resultSet.getString("email");
            String name = resultSet.getString("name");
            String phone = resultSet.getString("phone");
            return new User(id, email, name, phone);
        });
    }

    @Override
    public Optional<User> selectUserById(UUID id) {
        final String sql = "SELECT id, email, name, phone FROM User where id = ?";

        User user = jdbcTemplate.queryForObject(
                sql,
                (resultSet, i) -> {
                    UUID userId = UUID.fromString(resultSet.getString("id"));
                    String email = resultSet.getString("email");
                    String name = resultSet.getString("name");
                    String phone = resultSet.getString("phone");
                    return new User(userId, email, name, phone);
                },
                id);
        return Optional.ofNullable(user);
    }
}
