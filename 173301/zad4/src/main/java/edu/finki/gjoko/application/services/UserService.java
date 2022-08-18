package edu.finki.gjoko.application.services;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;

import java.util.ArrayList;
import java.util.List;

@Service
public class UserService {

    public void setHeader(Model model) {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        String username = authentication.getName();
        List<GrantedAuthority> rolesCollection = new ArrayList<>(authentication.getAuthorities());
        String role = rolesCollection.get(0).getAuthority();
        model.addAttribute("username", username);
        model.addAttribute("role", role);
    }

}
