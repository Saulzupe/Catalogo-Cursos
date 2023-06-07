package org.szunigap.webapp.controllers;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.szunigap.webapp.models.Curso;
import org.szunigap.webapp.services.CursoService;
import org.szunigap.webapp.services.CursoServiceImpl;

import java.io.IOException;
import java.sql.Connection;
import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

@WebServlet("/cursos/form")
public class CursoFormServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Connection conn = (Connection) req.getAttribute("conn");
        CursoService service = new CursoServiceImpl(conn);
        long id;
        try {
            id = Long.parseLong(req.getParameter("id"));
        } catch (NumberFormatException e) {
            id = 0L;
        }
        Curso curso = new Curso();
        if (id > 0 ) {
            Optional<Curso> c = service.porId(id);
            if (c.isPresent()){
                curso = c.get();
            }
        }
        req.setAttribute("curso", curso);
        req.setAttribute("titulo", id > 0 ? "Editar: curso" : "Crear: curso");
        getServletContext().getRequestDispatcher("/form.jsp").forward(req,resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Connection conn = (Connection) req.getAttribute("conn");
        CursoService service = new CursoServiceImpl(conn);
        String nombre = req.getParameter("nombre");
        String descripcion = req.getParameter("descripcion");
        String instructor = req.getParameter("instructor");

        double duracion;
        try {
            duracion = Double.parseDouble(req.getParameter("duracion"));
        } catch (NumberFormatException e) {
            duracion = 0;
        }
        Map<String, String> errores = new HashMap<>();
        if (nombre == null || nombre.isBlank()) {
            errores.put("nombre", "El campo es requerido");
        }
        if (descripcion == null || descripcion.isBlank()) {
            errores.put("descripcion", "El campo es requerido");
        }
        if (instructor == null || instructor.isBlank()) {
            errores.put("instructor", "El campo es requerido");
        }
        if (duracion == 0) {
            errores.put("duracion", "la duracion es requerida");
        }
        long id;
        try {
            id = Long.parseLong(req.getParameter("id"));
        } catch (NumberFormatException e) {
            id = 0L;
        }
        Curso curso = new Curso();
        curso.setId(id);
        curso.setNombre(nombre);
        curso.setDescripcion(descripcion);
        curso.setInstructor(instructor);
        curso.setDuracion(duracion);
        if (errores.isEmpty()) {
            service.guardar(curso);
            resp.sendRedirect(req.getContextPath() + "/cursos");
        } else {
            req.setAttribute("errores", errores);
            req.setAttribute("curso", curso);
            req.setAttribute("titulo" , id > 0 ? "Editar : curso":"Crear : Curso");
            getServletContext().getRequestDispatcher("/form.jsp").forward(req,resp);
        }
    }
}
