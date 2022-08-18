package edu.finki.gjoko.application.services;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.Set;

@Service
public class UserDetailsService  implements org.springframework.security.core.userdetails.UserDetailsService {

    private BCryptPasswordEncoder passwordEncoder;

    public UserDetailsService(BCryptPasswordEncoder passwordEncoder) {
        this.passwordEncoder = passwordEncoder;
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

        switch(username) {
            case "user1":
                return generateUser(username, passwordEncoder.encode("lozinka1"), "DATE");
            case "user2":
                return generateUser(username, passwordEncoder.encode("lozinka2"), "GUESS_NUMBER");
            case "user3":
                return generateUser(username, passwordEncoder.encode("lozinka3"), "GUESS_NUMBER");
            case "user4":
                return generateUser(username, passwordEncoder.encode("lozinka4"), "DATE");
        }
        throw new UsernameNotFoundException("Non existing username");
    }

    public User generateUser(String username, String password, String authority) {
        Set<GrantedAuthority> grantedAuthorities = new HashSet<>();
        grantedAuthorities.add(new SimpleGrantedAuthority(authority));
        return new User(username, password, grantedAuthorities);
    }
}
