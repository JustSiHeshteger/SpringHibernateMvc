package web.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import web.repository.UserRepository;
import web.entity.User;

import java.util.List;

@Service
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;

    @Autowired
    public UserServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public List<User> getAllUsers() {
        return this.userRepository.getAllUsers();
    }

    @Override
    @Transactional
    public void addUser(User user) {
        this.userRepository.addUser(user);
    }

    @Override
    @Transactional
    public void updateUser(User user) {
        this.userRepository.updateUser(user);
    }

    @Override
    @Transactional
    public void deleteUser(int id) {
        this.userRepository.deleteUser(id);
    }

    @Override
    public User getUserById(int id) {
        return this.userRepository.readUser(id);
    }
}
