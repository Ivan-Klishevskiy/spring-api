package by.tms.springapi.repository;

import by.tms.springapi.entity.User;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Objects;

@Component
public class InMemoryUserStorage {
    private final List<User> userList;

    public InMemoryUserStorage(List<User> userList) {
        this.userList = userList;
    }

    public void saveUser(User user) {
        userList.add(user);
    }

    public List<User> getAllUsers() {
        return userList;
    }

    public User findByUsername(String username) {
        for (User user : userList) {
            if (user.getUsername() != null && user.getUsername().equals(username)) {
                return user;
            }
        }
        return null;
    }

    public User updateUser(User user) {
        for (User temp : userList) {
            if (Objects.equals(temp.getUsername(), user.getUsername())) {
                temp = user;
                break;
            }
        }
        return user;
    }

    public void deleteUser(String username) {
        userList.removeIf(user -> Objects.equals(username, user.getUsername()));
    }
}
