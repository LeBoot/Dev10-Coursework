/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bl.HelloSecurity.service;

import com.bl.HelloSecurity.dao.UserDao;
import com.bl.HelloSecurity.entities.RoleObject;
import com.bl.HelloSecurity.entities.User;
import java.util.HashSet;
import java.util.Set;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

/**
 *
 * @author Boone
 */
@Service
public class UserDetailsServiceImpl implements UserDetailsService {

    @Autowired
    UserDao users;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        User user = users.getUserByUsername(username);
        System.out.println("username parameter: " + username);
        Set<GrantedAuthority> grantedAuthorities = new HashSet<>();
        for(RoleObject role : user.getRoles()) {
            grantedAuthorities.add(new SimpleGrantedAuthority(role.getRoleObject()));
        }
       
        org.springframework.security.core.userdetails.User springUser = new org.springframework.security.core.userdetails.User(user.getUsername(), user.getPassword(), grantedAuthorities);
        System.out.println("Spring User: " + springUser.getUsername() + " " + springUser.getPassword());
        return springUser;
    }

}