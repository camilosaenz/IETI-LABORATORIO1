package edu.eci.ieti.SpringBootRestAPI.service;

import edu.eci.ieti.SpringBootRestAPI.data.User;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

@Service
public class UserServiceHashMap implements UserService{

    private final HashMap<String, User> usersMap = new HashMap();

    @Override
    public User create(User user) {
        return usersMap.put(user.getId(), user);
    }

    @Override
    public User findById(String id) {
        User user = usersMap.get(id);
        return user;
    }

    @Override
    public List<User> all() {
        return new ArrayList<User>(usersMap.values());
    }

    @Override
    public void deleteById(String id) {
        usersMap.remove(id);
    }

    @Override
    public User update(User user, String userId) {
        return usersMap.put(userId, user);
    }
}
