package group_1.first.component;


import group_1.first.model.UserCourse;
import group_1.first.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;

@Component
public class CustomUserDetailsService implements UserDetailsService {

    @Autowired
    private UserRepository userRepo;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        UserCourse user=userRepo.findByUsername(username);
        return new CustomUserDetails(user);
    }
//    public User loadUserByUsername2(String username){
//        return userRepo.findByUsername(username);
//    }
}
