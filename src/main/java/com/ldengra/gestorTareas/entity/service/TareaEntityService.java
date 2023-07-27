package com.ldengra.gestorTareas.entity.service;

import com.ldengra.gestorTareas.entity.TareaEntity;
import com.ldengra.gestorTareas.repository.TareaRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class TareaEntityService {

    private final TareaRepository repository;

    public void save(TareaEntity tarea){
        try{
            repository.save(tarea);
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    public List<TareaEntity> findAll(){
        List<TareaEntity> listaTareas = new ArrayList<>();

        try{
            listaTareas = repository.findAll();
        }catch (Exception e){
            e.printStackTrace();
        }
        return listaTareas;
    }

    public TareaEntity findById(Long id){
        Optional<TareaEntity> optionalTarea =repository.findById(id);


        return optionalTarea.orElseThrow(() -> new NoSuchElementException("La tarea con el ID " + id + " no existe"));
    }

    public void deleteById(Long id){

        repository.deleteById(id);
    }
}
