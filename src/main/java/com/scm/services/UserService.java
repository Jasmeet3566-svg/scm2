package com.scm.services;
import com.scm.Entities.User;
import java.util.Optional;
import java.util.*;

public interface UserService {

    User saveUser(User user);

    Optional<User> getUserById(String id);

    Optional<User> updateUser(User user);

    void deleteUser(String id);

    boolean isUserExist(String userid);

    boolean isUserExistByEmail(String email);

    List<User> getAllUsers();
}
