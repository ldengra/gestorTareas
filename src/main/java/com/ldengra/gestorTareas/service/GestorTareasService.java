package com.ldengra.gestorTareas.service;


import com.ldengra.gestorTareas.entity.TareaEntity;
import com.ldengra.gestorTareas.entity.UsuarioEntity;
import com.ldengra.gestorTareas.entity.service.TareaEntityService;
import com.ldengra.gestorTareas.entity.service.UsuarioEntityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class GestorTareasService {

    @Autowired
    TareaEntityService tareaEntityService;
    @Autowired
    UsuarioEntityService usuarioEntityService;
    public void postTarea(TareaEntity tarea){

        tareaEntityService.save(tarea);

    }

    public List<TareaEntity> getListaTareas(){
        List<TareaEntity> listaTareas = new ArrayList<>();
        listaTareas = tareaEntityService.findAll();

        return listaTareas;
    }
    public TareaEntity getTarea(Long id){
        TareaEntity tarea = new TareaEntity();
        tarea = tareaEntityService.findById(id);

        return tarea;
    }

    public void putTarea(Long id, TareaEntity tarea){

        TareaEntity response;

        response = tareaEntityService.findById(id);

        response.setStatus(tarea.getStatus());
        response.setAssignee(tarea.getAssignee());
        response.setTitle(tarea.getTitle());
        response.setDescription(tarea.getDescription());
        response.setDueDate(tarea.getDueDate());
        response.setPriority(tarea.getPriority());

        tareaEntityService.save(response);


    }

    public void deleteTarea(Long id){
        tareaEntityService.deleteById(id);
    }

    public UsuarioEntity getUsuario(Long id){

        UsuarioEntity usuario = new UsuarioEntity();

        usuario = usuarioEntityService.findById(id);

        return usuario;
    }

    public void postUsuario(UsuarioEntity usuario){

        usuarioEntityService.save(usuario);

    }
}
