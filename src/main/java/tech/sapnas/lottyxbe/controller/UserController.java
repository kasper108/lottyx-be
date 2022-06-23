package tech.sapnas.lottyxbe.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import tech.sapnas.lottyxbe.entity.UserEntity;
import tech.sapnas.lottyxbe.service.UserService;

import java.util.List;

@RestController
@RequestMapping("api/v1/users/")
public class UserController {

    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping()
    public ResponseEntity<List<UserEntity>> findAllUsers(){
        List<UserEntity> users = userService.getAllUsers();
        return new ResponseEntity<>(users, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<UserEntity> findUserById(@PathVariable Long id){
        UserEntity userEntity = userService.getUserById(id);
        return new ResponseEntity<>(userEntity, HttpStatus.OK);
    }

    @PutMapping()
    public ResponseEntity<UserEntity> updateUser(@RequestBody UserEntity userEntity){
        UserEntity updateUser = userService.updateUser(userEntity);
        return new ResponseEntity<>(updateUser, HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> removeUser(@PathVariable("id") Long id){
        userService.deleteUserEntityById(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @PostMapping()
    public ResponseEntity<UserEntity> addUser(@RequestBody UserEntity userEntity){
        UserEntity newUserEntity = userService.addUserEntity(userEntity);
        return new ResponseEntity<>(newUserEntity, HttpStatus.CREATED);
    }
}
