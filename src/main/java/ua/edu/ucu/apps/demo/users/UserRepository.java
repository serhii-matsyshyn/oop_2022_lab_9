package ua.edu.ucu.apps.demo.users;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.Optional;

public interface UserRepository extends JpaRepository<StoreUser, Integer> {
    @Query("SELECT u FROM StoreUser u WHERE u.email = ?1")
    Optional<StoreUser> findStoreUserByEmail(String email);
}
