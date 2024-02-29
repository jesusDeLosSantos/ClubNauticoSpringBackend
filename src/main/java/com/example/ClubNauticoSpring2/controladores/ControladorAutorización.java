package com.example.ClubNauticoSpring2.controladores;

import com.example.ClubNauticoSpring2.dto.JWTAuthResponseDTO;
import com.example.ClubNauticoSpring2.dto.SignInRequestDTO;
import com.example.ClubNauticoSpring2.dto.SignUpRequestDTO;
import com.example.ClubNauticoSpring2.modelos.Usuario;
import com.example.ClubNauticoSpring2.servicios.IServicioAuth;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/v0/personas")
@CrossOrigin(origins = "http://localhost:4200")
public class ControladorAutorización {
    private IServicioAuth servicioAuth;

    @PostMapping("/register")
    public ResponseEntity<Usuario> signup(@RequestBody SignUpRequestDTO signUpRequestDTO){
        return ResponseEntity.ok(servicioAuth.signup(signUpRequestDTO));
    }

    @PostMapping("/login")
    public ResponseEntity<JWTAuthResponseDTO> signin (@RequestBody SignInRequestDTO signInRequestDTO){
        return ResponseEntity.ok(servicioAuth.signin(signInRequestDTO));
    }
}
