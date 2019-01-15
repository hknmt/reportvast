package com.viettelmor.reportvast.Service;

import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;

public interface UserService extends UserDetailsService {
    public UserDetails loadUserByUsername(String username);
    public boolean updatePassword(String oldPass, String newPass);
}
