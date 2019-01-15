package com.viettelmor.reportvast.Service;

import com.viettelmor.reportvast.BusinessObject.UserPrincipal;
import com.viettelmor.reportvast.BusinessObject.Users;
import com.viettelmor.reportvast.DataAccessObject.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private UserRepository userRepository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Users users = userRepository.findByUsername(username);
        if(users == null)
            throw new UsernameNotFoundException(username);

        return new UserPrincipal(users);
    }

    @Override
    public boolean updatePassword(String oldPass, String newPass) {
        PasswordEncoder encoder = new BCryptPasswordEncoder();
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        UserDetails userPrincipal = (UserDetails) authentication.getPrincipal();
        Users users = userRepository.findByUsername(userPrincipal.getUsername());
        if(encoder.matches(oldPass, users.getPassword())){
            String newPassEncoder = encoder.encode(newPass);
            users.setPassword(newPassEncoder);
            userRepository.save(users);
            return true;
        }else {
            return false;
        }
    }
}
