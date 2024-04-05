package numbersapp.primesservice.model;

import jakarta.persistence.*;

@Table
@Entity

public class Customer {

    private String username;
    private String password;
    @Id
    private Long id;

    public Customer() {

    }
    public Customer(String username, String password) {
        this.username = username;
        this.password = password;
    }




    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getId() {
        return id;
    }
}
