package com.kamal.spring_security_demo.service;

import com.kamal.spring_security_demo.dao.UserRepo;
import com.kamal.spring_security_demo.model.User;
import com.kamal.spring_security_demo.model.UserPrincipal;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class MyUserDetailService implements UserDetailsService {

    @Autowired
    private UserRepo repo;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

        User user = repo.findByUsername(username);
        if(user == null){
            throw new UsernameNotFoundException("User Not Found 404");
        }
        else{
            return new UserPrincipal(user);
        }
    };
}
