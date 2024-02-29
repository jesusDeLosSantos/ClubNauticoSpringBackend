package com.example.ClubNauticoSpring2.modelos;


import java.util.Collection;
import java.util.List;

import jakarta.persistence.*;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name="USER", uniqueConstraints= {@UniqueConstraint(columnNames = {"USERNAME", "CORREO"})})
public class Usuario implements UserDetails{

    private static final long serialVersionUID = 1L;

    //Atributos
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name="USERNAME", nullable=false, unique=true)
    private String username;
    @Column(name="PASSWORD", nullable=false)
    private String password;
    @Column(name="NOMBRE", nullable=false)
    private String nombre;
    @Column(name="APELLIDOS", nullable=false)
    private String apellidos;
    @Column(name="CORREO", nullable=false, unique=true)
    private String correo;
    @Enumerated(EnumType.STRING)
    private Rol rol;


    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return List.of(new SimpleGrantedAuthority(rol.name()));
    }
    @Override
    public boolean isAccountNonExpired() {
        return true;
    }
    @Override
    public boolean isAccountNonLocked() {
        return true;
    }
    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }
    @Override
    public boolean isEnabled() {
        return true;
    }
}
