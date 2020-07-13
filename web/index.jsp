<%-- 
    Document   : index
    Created on : 13/07/2020, 12:19:03
    Author     : guih_
--%>
<%@page import="controller.DisciplinaController"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
     <title>Controle de Notas - Inicio</title>
        <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css" integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm" crossorigin="anonymous">
        
    </head>
    <body>
        <h2> Controle de Notas - Avaliação Final POO </h2>
            <hr/>
        <div class="card" style="width: 20rem;">
            <img class="card-img-left" src="https://siga.cps.sp.gov.br/image//K8DWGK5DMTV8LFJ9DHIRZ27QEGPMVP.TMB.JPG" alt="Imagem aluno">
            <div class="card-body">
              <p class="card-text">
                   <p> Nome: <strong>Guilherme Roberto Torato</strong></p>
              </p>
            </div>
            <ul class="list-group list-group-flush">
              <li class="list-group-item">RA: <strong>1290481822019</strong></li>
              <li class="list-group-item">Ciclo: <strong> 4° </strong></li>
              <li class="list-group-item">Total de Disciplinas Matriculadas : 
                  <strong> <%= new DisciplinaController().buscar().size() %> </strong></li>
            </ul>
            <div class="card-body">
              <a href="listar.jsp" class="card-link">Listagem de Disciplinas Matriculadas</a>
            </div>
          </div>
            <br>
            <hr>
    </body>
</html>
