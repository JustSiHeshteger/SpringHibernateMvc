package web.repository;

import web.entity.User;

import java.util.List;


public interface UserRepository {
    List<User> getAllUsers();

    void addUser(User user);

    void updateUser(User user);

    void deleteUser(int id);

    User readUser(int id);
}
