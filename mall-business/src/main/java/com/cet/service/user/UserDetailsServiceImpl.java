package com.cet.service.user;


import com.cet.auth.JwtUserEntity;
import com.cet.util.PasswordUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * @author cet
 */
@Service("userDetailsService")
public class UserDetailsServiceImpl implements UserDetailsService {

    @Autowired
    private PasswordUtil passwordUtil;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        List<SimpleGrantedAuthority> authorities = new ArrayList<>();
        authorities.add(new SimpleGrantedAuthority("USER"));
        String encodePassword = passwordUtil.encode("123456");
        List<String> roles = new ArrayList<>();
        roles.add("USER");
        return new JwtUserEntity(123L, username, encodePassword, authorities, roles);
    }
}