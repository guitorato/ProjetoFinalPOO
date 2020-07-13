<%-- 
    Document   : registre
    Created on : 12/07/2020, 17:39:18
    Author     : guih_
--%>

<%@page import="controller.DisciplinaController"%>
<%@page import="model.Disciplina"%>
<%@page import="db.DBListener"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<%
    String error = null;
    DisciplinaController dc = new DisciplinaController();
    if(request.getParameter("add") != null){
        String codigo = request.getParameter("codigo");
        String nome = request.getParameter("nome");
        String dia = request.getParameter("dia");
        String hora = request.getParameter("hora");
        int total_aulas = Integer.parseInt(request.getParameter("total_aulas"));
        double nota = Double.parseDouble(request.getParameter("nota"));
        
        dc.addDisciplina(codigo, nome, dia, hora, nota, total_aulas);
        
        response.sendRedirect("listar.jsp");
          
        }  
%>

<html>
   <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Cadastrar Nova Disciplina</title>
         <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css" 
               integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm" 
               crossorigin="anonymous">
    </head>
    <body>
        <h1>Nova Disciplina</h1>
        
         <br>
        <a class="btn btn-secondary" href="index.jsp">Home </a>
        
        <hr>
      
        <form method="post">
       
            <div class="form-group">
                <label>Código:</label>
                <input type="text" class="form-control" name="codigo" /><br />
            </div>
            
            <div class="form-group">
                <label>Disciplina:</label>
                <input type="text" class="form-control" name="nome" /><br />
            </div>
            
            <div class="form-group">
                <label>Dia:</label>
               <input type="text" class="form-control" name="dia" /><br />
            </div>
            
            <div class="form-group">
               <label>Hora:</label>
               <input type="text" class="form-control" name="hora" /><br />
            </div>
            
            <div class="form-group">
                <label>Total de aulas(DIA):</label>
               <input type="number" class="form-control" name="total_aulas" /><br />
            </div>
            <div class="form-group">
                <label>Nota:</label>
                <input type="number" class="form-control" name="nota" /><br />
            </div>
     
            <input class="btn btn-primary" type="submit" name="add" value="Adicionar"/><br />
         
            <br>
            <hr>
            
        </form>
    </body>
</html> 
