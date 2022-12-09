package cromega.studio.apiREST.services;

import cromega.studio.apiREST.models.User;
import cromega.studio.apiREST.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImplemented implements UserService {

    @Autowired
    private UserRepository repository;

    @Override
    public List<User> findAll() {return (List<User>) repository.findAll();}

    @Override
    public User findById(Long id) {return repository.findById(id).orElse(null);}

    @Override
    public User save(User user) {return repository.save(user);}

    @Override
    public void delete(Long id) {repository.deleteById(id);}
}
