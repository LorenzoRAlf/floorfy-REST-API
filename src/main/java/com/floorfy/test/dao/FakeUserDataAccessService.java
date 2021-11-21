package com.floorfy.test.dao;

import com.floorfy.test.model.User;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Repository("fakeDao")
public class FakeUserDataAccessService implements UserDao {

   private static List<User> DB = new ArrayList<>();

    @Override
    public int insertUser(UUID id, User user) {
        DB.add(new User(id, user.getEmail(), user.getName(), user.getPhone()));
        return 1;
    }

    @Override
    public List<User> selectAllUsers() {
        return DB;
    }

    @Override
    public Optional<User> selectUserById(UUID id) {
        return DB.stream()
                .filter(user -> user.getId().equals(id))
                .findFirst();
    }
}
