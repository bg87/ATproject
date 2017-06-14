package api.services;

import api.domain.User;

import java.util.List;

public interface UserService {

    Iterable<User> getAllUsers();

    User getUserById(Integer id);

    User saveUser(User user);

    void deleteUser(Integer id);

    User findByName(String name);

    User findByEmail(String email);
}
