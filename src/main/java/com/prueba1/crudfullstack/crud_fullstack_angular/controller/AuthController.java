package com.prueba1.crudfullstack.crud_fullstack_angular.controller;

import com.prueba1.crudfullstack.crud_fullstack_angular.entity.Usuario;
import com.prueba1.crudfullstack.crud_fullstack_angular.service.AuthService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
@RequestMapping("/login")
@CrossOrigin( origins = "http://localhost:4200")
public class AuthController {

    private AuthService authService;

    public AuthController(AuthService authService) {
        this.authService = authService;
    }
    @PostMapping("/inicio")
    public ResponseEntity<String> login(@RequestBody Map<String, String> loginData) {
        String nombreUsuario = loginData.get("nombreUsuario");
        String contrasenia = loginData.get("contrasenia");
        String token = authService.login(nombreUsuario, contrasenia);
        if (!"Credenciales inválidas".equals(token)) {
            return ResponseEntity.ok(token); // Devuelve el JWT
        } else {
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED)
                    .body("Credenciales inválidas");
        }
    }
    @PostMapping("/crear")
    public Usuario crear(@RequestBody Usuario usuario, @RequestParam String nombreRol) {
        return authService.crearUsuario(usuario, nombreRol);
    }
}
