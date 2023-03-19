package projects.dex.collecta.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import projects.dex.collecta.repository.entity.UserBase;


public interface UserBaseRepository extends JpaRepository<UserBase,Long> {
    Optional<UserBase> findByUsername(String username);
    Optional<UserBase> findByEmail(String email);
    Optional<UserBase> findByUsernameAndEmail(String username,String email);

    long countByEmail(String email);
}
