package numbersapp.primesservice.service;
import numbersapp.primesservice.model.Customer;
import numbersapp.primesservice.repository.AuthenticationDBRepository;
import numbersapp.primesservice.repository.IAuthenticationRepository;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.io.IOException;

@Service
public class AuthenticationService implements IAuthenticationService, UserDetailsService {

    IAuthenticationRepository iAuthenticationRepository;
    AuthenticationDBRepository authenticationDBRepository;

    public AuthenticationService(AuthenticationDBRepository authenticationDBRepository) {
        this.authenticationDBRepository = authenticationDBRepository;
    }

    @Override
    public Customer register(Customer customer) throws IOException {
        System.out.println(customer);
        BCryptPasswordEncoder bc = new BCryptPasswordEncoder();
        String passwordEncoded = bc.encode(customer.getPassword());
        customer.setPassword(passwordEncoded);
        return authenticationDBRepository.save(customer);
    }

    @Override
    public boolean login(String username, String password) throws IOException {
        return false;
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException{
        try{
            Customer customer = iAuthenticationRepository.findByUsername(username);
            if(customer==null){
                throw new UsernameNotFoundException("");
            }
            return User
                    .withUsername(username)
                    .password(customer.getPassword())
                    .build();
        }
        catch (Exception e){
            throw new RuntimeException(e);
        }

    }
}