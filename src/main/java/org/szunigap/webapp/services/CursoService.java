package org.szunigap.webapp.services;

import org.szunigap.webapp.models.Curso;

import java.util.List;
import java.util.Optional;

public interface CursoService {
    List <Curso> listar();
    List <Curso> porNombre(String nombre);
    void guardar(Curso curso);

    void eliminar(Long id);
    Optional<Curso> porId(Long id);
}
