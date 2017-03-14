package entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

/**
 *
 * Created by Tim on 05/12/2016.
 */

@Entity
public class User {

    @Id
    @Column
    private int id;
    private String username;
    private String address;

    public User(int id, String username, String address, String password, int age) {
        this.id = id;
        this.username = username;
        this.address = address;
        this.password = password;
        this.age = age;
    }

    private String password;
    private int age;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }


    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
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

    public User() {
    }
}
