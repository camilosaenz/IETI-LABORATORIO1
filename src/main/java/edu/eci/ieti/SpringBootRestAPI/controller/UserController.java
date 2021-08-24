package edu.eci.ieti.SpringBootRestAPI.controller;

import edu.eci.ieti.SpringBootRestAPI.data.User;
import edu.eci.ieti.SpringBootRestAPI.dto.UserDto;
import edu.eci.ieti.SpringBootRestAPI.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping( "/v1/user" )
public class UserController {

    private final UserService userService;

    public UserController(@Autowired UserService userService ){
        this.userService = userService;
    }

    @GetMapping
    public ResponseEntity<List<User>> all() {
        return ResponseEntity.status(HttpStatus.OK).body(userService.all());
    }

    @GetMapping( "/{id}" )
    public ResponseEntity<User> findById( @PathVariable String id ) { return ResponseEntity.status(HttpStatus.OK).body(userService.findById(id)); }

    @PostMapping
    public ResponseEntity<User> create( @RequestBody UserDto userDto ) {
        try{
            return ResponseEntity.status(HttpStatus.OK).body(userService.create(new User(userDto)));
        }catch(Exception e){
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR.ordinal()).body(null);
        }
    }

    @PutMapping( "/{id}" )
    public ResponseEntity<User> update( @RequestBody UserDto userDto, @PathVariable String id ) {
        try{
            return ResponseEntity.status(HttpStatus.OK).body(userService.update(new User(userDto, id), id));
        }catch(Exception e){
            userService.deleteById(id);
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR.ordinal()).body(null);
        }
    }

    @DeleteMapping( "/{id}" )
    public ResponseEntity<Boolean> delete(@PathVariable String id ) {
        try{
            userService.deleteById(id);
            return ResponseEntity.status(HttpStatus.OK).body((true));
        }catch (Exception e){
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR.ordinal()).body((false));
        }
    }

}
