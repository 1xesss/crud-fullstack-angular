package com.prueba1.crudfullstack.crud_fullstack_angular.repository;

import com.prueba1.crudfullstack.crud_fullstack_angular.entity.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UsuarioRepository extends JpaRepository<Usuario, Long> {
    Usuario findByNombreUsuario(String nombreUsuario);
}
