package by.tms.springapi.service;

import by.tms.springapi.entity.User;
import by.tms.springapi.exception.userException.UserAlreadyExistException;
import by.tms.springapi.exception.userException.UserNotExistException;
import by.tms.springapi.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {

    @Autowired
    private UserRepository userStorage;

    public void saveAllUsers(List<User>users){
        userStorage.saveAll(users);
    }

    public void saveUser(User user) throws UserAlreadyExistException {
        if (userStorage.findByUsername(user.getUsername()).isPresent()) {
            throw new UserAlreadyExistException("User already exist!");
        } else {
            userStorage.save(user);
        }
    }

    public List<User> getAllUsers() {
        return userStorage.findAll();
    }

    public User findByUsername(String username) throws UserNotExistException {
            if(userStorage.findByUsername(username).isEmpty()){
                throw new UserNotExistException("User not found!");
            }else {
                return userStorage.findByUsername(username).get();
            }
    }

    public User updateUser(User user) throws UserNotExistException {
        if (userStorage.findByUsername(user.getUsername()).isPresent()) {
            throw new UserNotExistException("User not found!");
        } else {
            return userStorage.save(user);
        }
    }

    public void deleteUser(String username) throws UserNotExistException {
        if (userStorage.findByUsername(username).isEmpty()) {
            throw new UserNotExistException("User not found!");
        } else {
            userStorage.deleteByUsername(username);
        }
    }
}
