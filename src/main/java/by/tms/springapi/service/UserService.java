package by.tms.springapi.service;

import by.tms.springapi.entity.User;
import by.tms.springapi.exception.UserAlreadyExistException;
import by.tms.springapi.exception.UserNotExistException;
import by.tms.springapi.repository.InMemoryUserStorage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {

    @Autowired
    private InMemoryUserStorage userStorage;

    public void saveUser(User user) throws UserAlreadyExistException {
        if (userStorage.findByUsername(user.getUsername()) != null) {
            throw new UserAlreadyExistException("User already exist!");
        } else {
            userStorage.saveUser(user);
        }
    }

    public List<User> getAllUsers() {
        return userStorage.getAllUsers();
    }

    public User findByUsername(String username) throws UserNotExistException {
            if( userStorage.findByUsername(username)==null){
                throw new UserNotExistException("User not found!");
            }else {
                return userStorage.findByUsername(username);
            }
    }

    public User updateUser(String username, User user) throws UserNotExistException {
        if (userStorage.findByUsername(username) != null) {
            throw new UserNotExistException("User not found!");
        } else {
            return userStorage.updateUser(username,user);
        }
    }

    public void deleteUser(String username) throws UserNotExistException {
        if (userStorage.findByUsername(username) == null) {
            throw new UserNotExistException("User not found!");
        } else {
            userStorage.deleteUser(username);
        }
    }
}
