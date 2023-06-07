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

@WebServlet("/cursos/buscar")
public class BuscarServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Connection conn = ((Connection) req.getAttribute("conn"));
        CursoService service = new CursoServiceImpl(conn);
        String nombre = req.getParameter("nombre");
        List<Curso> cursos = service.porNombre(nombre);

        req.setAttribute("titulo", "Proyecto: filtrando cursos");
        req.setAttribute("cursos", cursos);
        getServletContext().getRequestDispatcher("/lista.jsp").forward(req,resp);
    }
}
