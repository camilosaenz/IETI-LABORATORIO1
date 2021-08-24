package edu.eci.ieti.SpringBootRestAPI.data;

import java.util.Date;
import java.util.UUID;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonFormat.Shape;
import edu.eci.ieti.SpringBootRestAPI.dto.UserDto;

public class User {

    private String id;
    private String name;
    private String email;
    private String lastName;
    @JsonFormat(shape = Shape.STRING, pattern = "yyyy-MM-dd")
    private Date createdAt;

    public User(String id, String name, String email, String lastName, Date createdAt) {
        this.id = id;
        this.name = name;
        this.email = email;
        this.lastName = lastName;
        this.createdAt = createdAt;
    }

    public User(UserDto userDto) {
        this.id = UUID.randomUUID().toString();
        this.name = userDto.getName();
        this.email = userDto.getEmail();
        this.lastName = userDto.getLastName();
        this.createdAt = userDto.getCreatedAt();
    }

    public User(UserDto userDto, String id) {
        this.id = id;
        this.name = userDto.getName();
        this.email = userDto.getEmail();
        this.lastName = userDto.getLastName();
        this.createdAt = userDto.getCreatedAt();
    }

    public String getId() {
        return id;
    }

    public void setId(String id) { this.id = id;}

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public Date getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(Date createdAt) {
        this.createdAt = createdAt;
    }

}