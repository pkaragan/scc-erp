package mx.mintik.mbs.core.backend.repositories;

import mx.mintik.mbs.core.backend.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface UserRepository extends JpaRepository<User, Long> {

    @Query("SELECT u FROM User u WHERE u.username= :username")
    User getByUsername(@Param("username") String username);


}
