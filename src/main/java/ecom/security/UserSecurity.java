package ecom.security;

import ecom.service.UserService;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;

import java.util.ArrayList;

@Component
public class UserSecurity implements UserDetailsService {
    private UserService userService;

    public UserSecurity(UserService userService){
        this.userService = userService;
    }
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        ecom.domain.User user = userService.get(username);
        if (user == null){
            return null;
        }
        else{
            User user1 = new User(user.getUsername(), user.getPassword(), user.getAuthorities());
            return user1;
        }
    }
}
