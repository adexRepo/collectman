package projects.dex.collecta.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import projects.dex.collecta.models.entity.UserBase;

public interface UserBaseRepository extends JpaRepository<UserBase,Long> {
    UserBase findByEmail(String email);

    long countByEmail(String email);
}
