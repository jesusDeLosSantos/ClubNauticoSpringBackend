package com.example.ClubNauticoSpring2.repositorios;

import com.example.ClubNauticoSpring2.modelos.Rol;
import com.example.ClubNauticoSpring2.modelos.Usuario;
import org.springframework.data.repository.CrudRepository;

import java.util.Optional;

public interface IRepositorioUsuario extends CrudRepository<Usuario, Long> {

    Optional<Usuario> findByUsername(String username);
    Usuario findByRol(Rol rol);
}