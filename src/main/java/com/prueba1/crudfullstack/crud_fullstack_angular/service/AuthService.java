package com.prueba1.crudfullstack.crud_fullstack_angular.service;

import com.prueba1.crudfullstack.crud_fullstack_angular.entity.Usuario;

public interface AuthService {
    String login(String nombreUsuario, String contrasenia);
    Usuario crearUsuario (Usuario usuario, String nombreRol);
}
