package com.comixtorm.collector.service.impl;

import com.comixtorm.collector.model.User;
import com.comixtorm.collector.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class AppUserDetailsService implements UserDetailsService {
    @Autowired
    private UserRepository userRepository;

    @Override
    public UserDetails loadUserByUsername(String s) throws UsernameNotFoundException {

        BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
        User user = userRepository.findByUsername(s);

        if(user == null) {
            throw new UsernameNotFoundException(String.format("The username %s doesn't exist", s));
        }

        List<GrantedAuthority> authorities = new ArrayList<>();
        user.getProfiles().forEach(profile -> {
            authorities.add(new SimpleGrantedAuthority(profile.getDescription()));
        });

        UserDetails userDetails = new org.springframework.security.core.userdetails.User(
                user.getUsername(),  user.getPassword(), authorities);
//                user.getUsername(),  user.getPassword().substring(8), authorities);
        userDetails.getUsername();

        return userDetails;
    }
}
