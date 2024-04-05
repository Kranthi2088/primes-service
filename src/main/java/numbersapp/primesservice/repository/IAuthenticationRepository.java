package numbersapp.primesservice.repository;
import  numbersapp.primesservice.model.Customer;

import java.io.IOException;

public interface IAuthenticationRepository {

    Customer register(Customer customer) throws IOException;

    boolean save(Customer customer) throws IOException;
    Customer findByUsername(String username) throws IOException;


}