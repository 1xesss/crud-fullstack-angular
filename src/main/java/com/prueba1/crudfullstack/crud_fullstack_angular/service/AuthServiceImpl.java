package com.prueba1.crudfullstack.crud_fullstack_angular.service;

import com.prueba1.crudfullstack.crud_fullstack_angular.entity.Rol;
import com.prueba1.crudfullstack.crud_fullstack_angular.entity.Usuario;
import com.prueba1.crudfullstack.crud_fullstack_angular.repository.RolRepository;
import com.prueba1.crudfullstack.crud_fullstack_angular.repository.UsuarioRepository;
import org.springframework.security.crypto.password.PasswordEncoder;
import com.prueba1.crudfullstack.crud_fullstack_angular.service.JwtUtil;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Set;

@Service
public class AuthServiceImpl implements AuthService {

    private final UsuarioRepository usuarioRepository;
    private final RolRepository rolRepository;
    private final PasswordEncoder passwordEncoder;
    private final JwtUtil jwtUtil;

    public AuthServiceImpl(UsuarioRepository usuarioRepository, RolRepository rolRepository,
                           PasswordEncoder passwordEncoder,
                           JwtUtil jwtUtil) {
        this.usuarioRepository = usuarioRepository;
        this.rolRepository = rolRepository;
        this.passwordEncoder = passwordEncoder;
        this.jwtUtil = jwtUtil;
    }
    @Override
    public String login(String nombreUsuario, String contrasenia) {
        Usuario usuario = usuarioRepository.findByNombreUsuario(nombreUsuario);

        if (usuario != null && usuario.getContrasenia().equals(contrasenia)) {
            List<String> roles = usuario.getRoles().stream()
                    .map(Rol::getNombre)
                    .toList();
            return jwtUtil.generarToken(usuario.getNombreUsuario(), roles);
        }
        return "Credenciales inválidas";
    }
    @Override
    public Usuario crearUsuario(Usuario usuario, String nombreRol) {
        Rol rol = rolRepository.findByNombre(nombreRol);
        if (rol == null) {
            throw new RuntimeException("Rol no encontrado: " + nombreRol);
        }
        usuario.setRoles(Set.of(rol));
        return usuarioRepository.save(usuario);
    }
}
