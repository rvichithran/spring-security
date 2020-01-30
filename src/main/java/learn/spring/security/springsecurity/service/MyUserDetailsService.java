package learn.spring.security.springsecurity.service;

import learn.spring.security.springsecurity.security.MyUserDetails;
import learn.spring.security.springsecurity.repo.UserRepository;
import learn.spring.security.springsecurity.models.UserEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class MyUserDetailsService implements UserDetailsService {

    @Autowired
    private UserRepository userRepo;

   /* @Override
    public UserDetails loadUserByUsername(final String user) throws UsernameNotFoundException {
        return new MyUserDetails(user);
    }*/

    @Override
    public MyUserDetails loadUserByUsername(final String userName) throws UsernameNotFoundException {
        final Optional<UserEntity> userEntity = userRepo.findByUsername(userName);
        return new MyUserDetails(userEntity.orElseThrow(() -> new UsernameNotFoundException("Not found -> "+userName)));
    }
}
