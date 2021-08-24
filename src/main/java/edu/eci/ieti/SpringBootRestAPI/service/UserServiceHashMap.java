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
        if (usersMap.containsKey(user.getId())) {
            throw new RuntimeException("El Usuario ya Existe!");
        }
        usersMap.put(user.getId(), user);
        return usersMap.get(user.getId());
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
        if(usersMap.containsKey(id)){
            usersMap.remove(id);
        }else{
            throw new RuntimeException("El Usuario no Existe!");
        }
    }

    @Override
    public User update(User user, String userId) {
        if (!usersMap.containsKey(userId)) {
            throw new RuntimeException("El Usuario no Existe!");
        }
        deleteById(userId);
        return create(user);
    }

}