package tech.sapnas.lottyxbe.service;

import tech.sapnas.lottyxbe.exception.UserNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tech.sapnas.lottyxbe.entity.UserEntity;
import tech.sapnas.lottyxbe.repository.UserRepository;

import javax.transaction.Transactional;
import java.util.List;

@Service
@Transactional
public class UserService {
    private final UserRepository userRepository;

    @Autowired
    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public List<UserEntity> getAllUsers(){
        return userRepository.findAll();
    }

    public UserEntity getUserById(Long id){
        return userRepository.getUserEntityById(id).
                orElseThrow(() -> new UserNotFoundException("User by id " + id + " was not found" ));
    }
}
