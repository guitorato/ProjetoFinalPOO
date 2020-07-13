/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import db.DBListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLDataException;
import java.sql.SQLException;
import java.util.ArrayList;
import model.Disciplina;

/**
 *
 * @author guih_
 */
public class DisciplinaController {
    
      public ArrayList<Disciplina> buscar() throws SQLDataException, ClassNotFoundException, SQLException {
        ArrayList<Disciplina> listar = new ArrayList<>();
        String SQL = "Select * from disciplina order by nome";
        Class.forName("org.sqlite.JDBC");
        Connection conn = DriverManager.getConnection(DBListener.URL);
        PreparedStatement pstm = conn.prepareStatement(SQL);

        ResultSet result = pstm.executeQuery();

        while (result.next()) {
            Disciplina disciplina = new Disciplina();
            disciplina.setNome(result.getString("nome"));
            disciplina.setCodigo(result.getString("codigo"));
            disciplina.setDia(result.getString("dia"));
            disciplina.setHora(result.getString("hora"));
            disciplina.setNota(result.getDouble("nota"));
            disciplina.setTotal_aulas(result.getInt("total_aulas"));
            listar.add(disciplina);
        }
        result.close();
        pstm.close();
        conn.close();

        return listar;

    }

    @SuppressWarnings("ConvertToTryWithResources")
    public Disciplina buscaDisciplina(String codigo) throws SQLException, ClassNotFoundException {
        Disciplina disciplina = new Disciplina();
        String query = "SELECT * FROM disciplina WHERE codigo = ?";

        Class.forName("org.sqlite.JDBC");
        Connection conn = DriverManager.getConnection(DBListener.URL);
        PreparedStatement pstm = conn.prepareStatement(query);
        pstm.setString(1, codigo);
        ResultSet result = pstm.executeQuery();

        if (result.next()) {
            disciplina.setNome(result.getString("nome"));
            disciplina.setCodigo(result.getString("codigo"));
            disciplina.setDia(result.getString("dia"));
            disciplina.setHora(result.getString("hora"));
            disciplina.setNota(result.getDouble("nota"));
            disciplina.setTotal_aulas(result.getInt("total_aulas"));

        }

        result.close();
        pstm.close();
        conn.close();

        return disciplina;
    }

    @SuppressWarnings("ConvertToTryWithResources")
    public void atualizaNota(Double notaFinal, String codigo) throws SQLException, ClassNotFoundException {
        String query = "UPDATE disciplina SET nota = ? WHERE codigo = ?";
        Class.forName("org.sqlite.JDBC");
        Connection conn = DriverManager.getConnection(DBListener.URL);
        PreparedStatement pstm = conn.prepareStatement(query);

        pstm.setDouble(1, notaFinal);
        pstm.setString(2, codigo);
        pstm.execute();

        pstm.close();
        conn.close();

    }
    
    @SuppressWarnings("ConvertToTryWithResources")
    public void addDisciplina(String codigo, String nome , String dia , String hora , Double nota , int total_aulas) throws SQLException, ClassNotFoundException {
         Class.forName("org.sqlite.JDBC");
        Connection con = DriverManager.getConnection(DBListener.URL);
        String SQL = "INSERT INTO disciplina (codigo, nome, dia, hora, total_aulas, nota) VALUES (?,?,?,?,?,?)";
        PreparedStatement stmt = con.prepareStatement(SQL);
        stmt.setString(1, codigo);
        stmt.setString(2, nome);
        stmt.setString(3, dia);
        stmt.setString(4, hora);
        stmt.setDouble(5, nota);
        stmt.setInt(6, total_aulas);
        stmt.execute();
        
        stmt.close();
        con.close();
    }
    
}
