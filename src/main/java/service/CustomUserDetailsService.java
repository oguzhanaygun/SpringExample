package service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import model.User;


@Service
public class CustomUserDetailsService implements UserDetailsService{

	@Autowired
	UserService service;
    
	@Transactional(readOnly=true)
    public UserDetails loadUserByUsername(String email)
            throws UsernameNotFoundException {
       User user = service.getUser(email);
      
        if(user==null){
         
            throw new UsernameNotFoundException("Username not found");
        }
        List<GrantedAuthority> auth=new ArrayList<GrantedAuthority>();
        auth.add(new SimpleGrantedAuthority(user.getRole()));
        return new org.springframework.security.core.userdetails.User(user.getEmail(), user.getPass(), 
                true, true, true, true,auth );
        
    }
 
  
}
