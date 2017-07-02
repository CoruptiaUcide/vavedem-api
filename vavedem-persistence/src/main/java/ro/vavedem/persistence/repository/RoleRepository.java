/**
 * @author CoruptiaUcide
 */
package ro.vavedem.persistence.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ro.vavedem.persistence.entities.Role;

import java.util.List;

public interface RoleRepository extends JpaRepository<Role, Integer> {

    List<Role> findAll();

    Role findByRole(String role);
}
