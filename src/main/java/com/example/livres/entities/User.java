package com.example.livres.entities;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import jakarta.persistence.JoinColumn;

@Data
@Entity
@NoArgsConstructor
@AllArgsConstructor
@JsonIgnoreProperties({"hibernateLazyInitializer"})
public class User {
@Id
@GeneratedValue (strategy=GenerationType.IDENTITY)
private Long user_id;
private String username;
private String password;
private Boolean enabled;
 @ManyToMany(cascade=CascadeType.ALL, fetch = FetchType.EAGER)
@JoinTable(name="user_role",joinColumns = @JoinColumn(name="user_id") ,
 inverseJoinColumns = @JoinColumn(name="role_id"))
private List<Role> roles;
}