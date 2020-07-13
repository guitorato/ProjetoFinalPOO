<%-- 
    Document   : consulta
    Created on : 13/07/2020, 12:19:03
    Author     : guih_
--%>
<%@page import="model.Disciplina" %>
<%@page import="controller.DisciplinaController" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>

<%
    Disciplina disc = new Disciplina();
    if (request.getParameter("codigo") != null) {
        disc = new controller.DisciplinaController().buscaDisciplina(String.valueOf(request.getParameter("codigo")));
    }

    if (request.getParameter("salvar") != null) {

        new controller.DisciplinaController().atualizaNota(Double.valueOf(request.getParameter("notaFinal")), String.valueOf(request.getParameter("codigo")));
        response.sendRedirect("listar.jsp");
    }
%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Controle de Notas - Consulta</title>
        <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css" integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm" crossorigin="anonymous">

    </head>
    <body>
        <h1>Dados da Disciplina</h1>

        <hr>

        <form>

            <p> Codigo: <strong> <%=disc.getCodigo()%> </strong> <br><br>
                Nome: <strong><%=disc.getNome()%></strong><br> <br>
                Horario:  <strong><%=disc.getHora()%></strong><br> <br>
                Dia da Semana: <strong><%=disc.getDia()%></strong><br> <br>
                Quantidade de Aula <strong><%=disc.getTotal_aulas()%></strong><br> </p>
            <p>Nota final:
                <input type="number" name="notaFinal" step="0.1" min="0" max="10" value="<%=disc.getNota()%>"/>
            </p>

            <input type="hidden" name="codigo" value="<%=disc.getCodigo()%>" />
            <input class="btn btn-primary" type="submit" value="salvar" name="salvar" />
            <a href="listar.jsp" class="btn btn-warning"> Voltar </a>


        </form>

    </body>
</html>
