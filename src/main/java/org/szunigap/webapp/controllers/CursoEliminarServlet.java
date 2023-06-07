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
import java.util.Optional;

@WebServlet("/cursos/eliminar")
public class CursoEliminarServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Connection conn = (Connection) req.getAttribute("conn");
        CursoService service = new CursoServiceImpl(conn);
        Long id;
        try {
            id = Long.parseLong(req.getParameter("id"));
        } catch (NumberFormatException e) {
            id = 0L;
        }
        if (id > 0) {
            Optional<Curso> c = service.porId(id);
            if (c.isPresent()) {
                service.eliminar(id);
                resp.sendRedirect(req.getContextPath() + "/cursos");
            }else {
                resp.sendError(HttpServletResponse.SC_NOT_FOUND, "No existe el producto en la url");
            }
        } else {
            resp.sendError(HttpServletResponse.SC_NOT_FOUND, "Error el id es null, enviarlo como parametro en la url");
        }
    }
}
