package unicesumar.edu.hw.tech.repository.user;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;
import unicesumar.edu.hw.tech.model.user.User;

public interface UserRepository extends JpaRepository<User, Long> {

    @Transactional
    @Modifying
    @Query(value = "UPDATE USERS SET email = :email , password = :password WHERE id = :id", nativeQuery = true)
    Integer updateUser(@Param("email") String email, @Param("password") String password, @Param("id") Long id);

    @Transactional
    @Modifying
    @Query(value = "DELETE FROM USERS WHERE id = :id", nativeQuery = true)
    Integer deleteUser(@Param("id") Long id);

    @Query(value = "SELECT * FROM USERS WHERE email = :email AND password = :password", nativeQuery = true)
    User getUserByEmailAndPassword(@Param("email") String email, @Param("password") String password);
}
