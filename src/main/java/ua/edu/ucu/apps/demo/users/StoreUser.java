package ua.edu.ucu.apps.demo.users;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.time.LocalDate;
import java.time.Period;

@Entity
@Table
@NoArgsConstructor
@Getter
@Setter
public class StoreUser {
    @Id
    @GeneratedValue
    private int id;

    @Column(unique = true)
    private String email;
    private LocalDate dob;
    @Transient
    private int age;

    public int getAge() {
        return Period.between(dob, LocalDate.now()).getYears();
    }
    public void update(String message) {
        System.out.println("User " + email + " was notified that: " + message);
        // send email or do something else
    }

    // toString
    @Override
    public String toString() {
        return "StoreUser{" +
                "id=" + id +
                ", email='" + email + '\'' +
                ", dob=" + dob +
                '}';
    }
}
