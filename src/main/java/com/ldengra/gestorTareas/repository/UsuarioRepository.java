package com.ldengra.gestorTareas.repository;

import com.ldengra.gestorTareas.entity.UsuarioEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UsuarioRepository extends JpaRepository<UsuarioEntity, Long> {
}
