<%@page contentType="text/html" pageEncoding="UTF-8"  import="java.util.*, org.szunigap.webapp.models.*"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<jsp:include page="layout/header.jsp"/>

<h1 class="text-body">${titulo}</h1>
<p><a href="${pageContext.request.contextPath}/cursos" class="btn btn-primary">Volver</a></p>
<form action="${pageContext.request.contextPath}/cursos/form" method="post">
    <div class="row input-group mb-3">
        <label for="nombre" class="col-form-label col-sm2">Nombre: </label>
        <div class="col-sm-4">
            <input type="text" name="nombre" id="nombre" value="${curso.nombre}" class="form-control">
        </div>
        <c:if test="${errores != null && errores.containsKey('nombre')}">
                  <div class="alert alert-danger" role="alert">${errores.nombre}</div>
          </c:if>
    </div>
    <div class="row  input-group mb-3">
        <label for="instructor" class="col-form-label col-sm2">Instructor: </label>
        <div class="col-sm-4">
            <input type="text" name="instructor" id="instructor" value="${curso.instructor}" class="form-control">
        </div>
          <c:if test="${errores != null && errores.containsKey('instructor')}">
                   <div class="alert alert-danger" role="alert">${errores.instructor}</div>
                </c:if>
    </div>
    <div class="row  input-group mb-3">
        <label for="duracion" class="col-form-label col-sm2">Duración:</label>
        <div class="col-sm-4">
            <input type="text" name="duracion" id="duracion" value="${curso.duracion}" class="form-control">
        </div>
         <c:if test="${errores != null && errores.containsKey('duracion')}">
            <div class="alert alert-danger" role="alert">${errores.duracion}</div>
        </c:if>
    </div>
    <div class="row  input-group mb-3">
        <label for="descripcion" class="col-form-label col-sm2">Descripción: </label>
        <div class="col-sm-4">
            <textarea name="descripcion" id="descripcion"  rows="4" class="form-control">${curso.descripcion}</textarea>
        </div>
          <c:if test="${errores != null && errores.containsKey('descripcion')}">
                    <div class="alert alert-danger" role="alert">${errores.descripcion}</div>
           </c:if>
    </div>

    <div class="btn-group">
        <input type="submit" value="${curso.id != null && curso.id > 0  ? "Editar" : "Crear"}" class="btn btn-success btn-sm">
    </div>
    <input type="hidden" name="id" value="${curso.id}">
</form>

<jsp:include page="layout/footer.jsp" />