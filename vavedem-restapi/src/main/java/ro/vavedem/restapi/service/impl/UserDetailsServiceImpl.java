package ro.vavedem.restapi.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ro.vavedem.persistence.entities.Role;
import ro.vavedem.persistence.entities.UserAccount;
import ro.vavedem.persistence.repository.UserRepository;

import java.util.HashSet;
import java.util.Set;

/**
 * This service is used to authenticate/authorize users into the application
 * For the rest-api, it will be used to authorize requests based on user's role
 */
@Service
public class UserDetailsServiceImpl implements UserDetailsService {

    @Autowired
    private UserRepository userRepository;

    @Override
    @Transactional(readOnly = true)
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        UserAccount userAccount = userRepository.findByUsername(username);

        Set<GrantedAuthority> grantedAuthorities = new HashSet<>();

        for (Role role : userAccount.getRoles()) {
            grantedAuthorities.add(new SimpleGrantedAuthority(role.getRole()));
        }

        return new User(userAccount.getUsername(), userAccount.getPassword(), grantedAuthorities);
    }
}
