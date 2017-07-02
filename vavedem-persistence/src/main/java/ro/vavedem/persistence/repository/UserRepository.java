/**
 * @author CoruptiaUcide
 */
package ro.vavedem.persistence.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ro.vavedem.persistence.entities.UserAccount;

import java.util.List;


public interface UserRepository extends JpaRepository<UserAccount, Long> {

    List<UserAccount> findAll();

    UserAccount findByUsername(String username);

}
