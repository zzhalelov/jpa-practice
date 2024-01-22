package model;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Getter
@Setter
@Entity
@Table(name = "users")
@ToString
public class User {
    @Id
    private int id;
    private String name;
    private String email;
    private int age;
}