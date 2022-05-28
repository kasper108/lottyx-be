package tech.sapnas.lottyxbe.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import tech.sapnas.lottyxbe.entity.UserEntity;

import java.util.Optional;

public interface UserRepository extends JpaRepository<UserEntity, Long> {
    //Optional<UserEntity> findUserBy(Long id);
    //void deleteUserById(Long id);
}
