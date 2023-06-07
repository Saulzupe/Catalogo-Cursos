package org.szunigap.webapp.services;

import org.szunigap.webapp.models.Curso;
import org.szunigap.webapp.repositories.CursoRepositorioImpl;
import org.szunigap.webapp.repositories.Repositorio;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;
import java.util.Optional;

public class CursoServiceImpl implements CursoService{
    private Repositorio <Curso> repositorio;

    public CursoServiceImpl(Connection connection) {
        this.repositorio = new CursoRepositorioImpl(connection);
    }

    @Override
    public List<Curso> listar() {
        try {
            return repositorio.listar();
        } catch (SQLException e) {
            throw new ServiceJdbException(e.getMessage() + e.getCause());
        }
    }

    @Override
    public List<Curso> porNombre(String nombre) {
        try {
            return repositorio.porNombre(nombre);
        } catch (SQLException e) {
            throw new ServiceJdbException(e.getMessage(), e.getCause());
        }
    }

    @Override
    public void guardar(Curso curso) {
        try{
            repositorio.guardar(curso);
        }catch ( SQLException throwables){
            throw  new ServiceJdbException(throwables.getMessage(), throwables.getCause());
        }
    }

    @Override
    public void eliminar(Long id) {
        try {
            repositorio.eliminar(id);
        } catch (SQLException throwables) {
            throw  new ServiceJdbException(throwables.getMessage(), throwables.getCause());
        }
    }

    @Override
    public Optional<Curso> porId(Long id) {
        try{
            return Optional.ofNullable(repositorio.porId(id));
        }catch (SQLException e) {
            throw new ServiceJdbException(e.getMessage(), e.getCause());
        }
    }
}
