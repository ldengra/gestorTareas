package com.ldengra.gestorTareas.repository;

import com.ldengra.gestorTareas.entity.TareaEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TareaRepository extends JpaRepository<TareaEntity,Long> {
}
