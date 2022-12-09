package cromega.studio.apiREST.controller;

import cromega.studio.apiREST.models.User;
import cromega.studio.apiREST.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api")
public class UserController {

    @Autowired
    private UserService service;

    @GetMapping("/user")
    public List<User> list() {return service.findAll();}

    @PostMapping("/user")
    public ResponseEntity<?> create(@RequestBody User user) {
        User newUser;
        Map<String, Object> response = new HashMap<>();

        try {
            newUser = service.save(user);
            response.put("message", "Successful user \"INSERT\" into database");
            response.put("user", newUser);
            return new ResponseEntity<Map<String, Object>>(response, HttpStatus.CREATED);
        }
        catch (DataAccessException error) {
            response.put("message", "Error trying to \"INSERT\" into database");
            response.put("error", error.getMessage());
            return new ResponseEntity<Map<String, Object>>(response, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping("user/{id}")
    public ResponseEntity<?> get(@PathVariable Long id) {
        User selectedUser;
        Map<String, Object> response = new HashMap<>();
        try{
            selectedUser = service.findById(id);
            if (selectedUser == null) {
                response.put("message", "Client ID: Doesn't Exist");
                return new ResponseEntity<Map<String, Object>>(response, HttpStatus.NOT_FOUND);
            } else {
                response.put("message", String.format("Client ID: %d", id));
                response.put("user", selectedUser);
                return new ResponseEntity<Map<String, Object>>(response, HttpStatus.OK);
            }
        }
        catch (DataAccessException error) {
            response.put("message", "Error trying to \"SELECT\" from database");
            response.put("error", error.getMessage());
            return new ResponseEntity<Map<String, Object>>(response, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PutMapping("user/{id}")
    public ResponseEntity<?> update(@RequestBody User user, @PathVariable Long id) {
        User currentUser = service.findById(id), updatedUser;
        Map<String, Object> response = new HashMap<>();

        if (currentUser == null) {
            response.put("message", "Client ID: Doesn't Exist");
            return new ResponseEntity<Map<String, Object>>(response, HttpStatus.NOT_FOUND);
        }

        try {
            currentUser.setFirstName(user.getFirstName());
            currentUser.setLastName(user.getLastName());
            currentUser.setDate(user.getDate());

            updatedUser = service.save(currentUser);

            response.put("message", String.format("Client \"%d\" was updated", id));
            response.put("user", updatedUser);

            return new ResponseEntity<Map<String, Object>>(response, HttpStatus.OK);
        }
        catch (DataAccessException error) {
            response.put("message", "Error trying to \"UPDATE\" into database");
            response.put("error", error.getMessage());
            return new ResponseEntity<Map<String, Object>>(response, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @DeleteMapping("user/{id}")
    public ResponseEntity<?> delete(@PathVariable Long id) {
        Map<String, Object> response = new HashMap<>();

        try {
            service.delete(id);
            response.put("message", String.format("User \"%d\" was deleted", id));
            return new ResponseEntity<Map<String, Object>>(response, HttpStatus.OK);
        }
        catch (DataAccessException error) {
            response.put("message", "Error trying to \"DELETE\" into database");
            response.put("error", error.getMessage());
            return new ResponseEntity<Map<String, Object>>(response, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
