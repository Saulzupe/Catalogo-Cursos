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
import java.util.List;
@WebServlet({"/index.html", "/cursos"})
public class CursoServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Connection conn = (Connection) req.getAttribute("conn");
        CursoService service = new CursoServiceImpl(conn);
        List<Curso> cursos = service.listar();

        req.setAttribute("titulo", "Listado de cursos");
        req.setAttribute("cursos", cursos);

        getServletContext().getRequestDispatcher("/lista.jsp").forward(req,resp);
    }
}
