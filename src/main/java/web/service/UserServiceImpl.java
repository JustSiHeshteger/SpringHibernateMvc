package web.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import web.repository.UserRepository;
import web.entity.User;

import java.util.List;

@Service
@Transactional
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository userRepository;

    @Override
    public List<User> getAllUsers() {
        return this.userRepository.getAllUsers();
    }

    @Override
    public void addUser(User user) {
        this.userRepository.addUser(user);
    }

    @Override
    public void updateUser(User user) {
        this.userRepository.updateUser(user);
    }

    @Override
    public void deleteUser(int id) {
        this.userRepository.deleteUser(id);
    }

    @Override
    public User readUser(int id) {
        return this.userRepository.readUser(id);
    }
}
