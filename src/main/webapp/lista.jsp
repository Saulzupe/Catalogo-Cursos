<%@page contentType="text/html" pageEncoding="UTF-8" import="java.util.*" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<jsp:include page="layout/header.jsp"/>

        <h1 class ="text-body">${titulo}</h1>
        <p><a class="btn btn-primary my-2" href="${pageContext.request.contextPath}/cursos/form"> Crear [ + ] </a></p>
        <form action="${pageContext.request.contextPath}/cursos/buscar" method="post">
            <input type="text" name="nombre" class="form-control">
            <input type="submit" value="Buscar" class="btn btn-secondary my-2">
        </form>
        <table class="table table-dark table-striped">
            <tr>
                <th>id</th>
                <th> Nombre</th>
                <th> Descripción</th>
                <th> Instructor</th>
                <th> Duración</th>
                <th> Editar </th>
                <th> Eliminar </th>
            </tr>
            <c:forEach items="${cursos}" var="c">
                <tr>
                    <td>${c.id}</td>
                    <td>${c.nombre}</td>
                    <td>${c.descripcion}</td>
                    <td>${c.instructor}</td>
                    <td>${c.duracion}</td>
                    <td><a href="${pageContext.request.contextPath}/cursos/form?id=${c.id}" class="btn btn-warning"> Editar  </a></td>
                    <td><a onclick="return confirm('¿Está seguro que desea eliminar?');"
                            href="${pageContext.request.contextPath}/cursos/eliminar?id=${c.id}" class="btn btn-danger"> Eliminar </a></td>
                </tr>
            </c:forEach>
        </table>

<jsp:include page="layout/footer.jsp" />