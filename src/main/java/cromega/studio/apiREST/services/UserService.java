package cromega.studio.apiREST.services;

import cromega.studio.apiREST.models.User;

import java.util.List;

public interface UserService {

    public List<User> findAll();
    public User findById(Long id);
    public User save(User user);
    public void delete(Long id);
}
