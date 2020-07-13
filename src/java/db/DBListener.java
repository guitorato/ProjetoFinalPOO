/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package db;

import controller.DisciplinaController;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

/**
 * Web application lifecycle listener.
 *
 * @author guih_
 */
public class DBListener implements ServletContextListener {

    public static final String URL = "jdbc:sqlite:C:\\Users\\guih_\\projeto.db";
    public static String exceptionMessage = null;

    @Override
    public void contextInitialized(ServletContextEvent sce) {
          try {
            Class.forName("org.sqlite.JDBC");
            Connection conn = DriverManager.getConnection(URL);
            Statement sts = conn.createStatement();
            String SQL = "CREATE TABLE IF NOT EXISTS disciplina("
                    + "nome VARCHAR(100) NOT NULL,"
                    + "dia VARCHAR(50) NOT NULL,"
                    + "hora VARCHAR(10) NOT NULL,"
                    + "total_aulas INTEGER NOT NULL,"
                    + "nota REAL NOT NULL,"
                    + "codigo VARCHAR(10) NOT NULL" + ")";
            sts.executeUpdate(SQL);

            if (new DisciplinaController().buscar().isEmpty()) {
                sts.executeUpdate("INSERT INTO disciplina (codigo, nome, dia, hora, total_aulas, nota)"
                        + "VALUES ('IBD002' , 'Banco de Dados', 'Terça-Feira', '13:10', 4, 0 )");

                sts.executeUpdate("INSERT INTO disciplina (codigo, nome, dia, hora, total_aulas, nota)"
                        + "VALUES ('IES300' , 'Engenharia de Software III', 'Quinta-Feira', '15:00', 4, 0 )");

                sts.executeUpdate("INSERT INTO disciplina (codigo, nome, dia, hora, total_aulas, nota)"
                        + "VALUES ('IHC001' , 'Interação Humano Computador', 'Quarta-Feira', '16:50', 2, 0 )");

                sts.executeUpdate("INSERT INTO disciplina (codigo, nome, dia, hora, total_aulas, nota)"
                        + "VALUES ('ILP007' , 'Programação Orientada a Objetos', 'Segunda-Feira', '13:10', 4, 0 )");

                sts.executeUpdate("INSERT INTO disciplina (codigo, nome, dia, hora, total_aulas, nota)"
                        + "VALUES ('ISG003' , 'Segurança da Informação', 'Sexta-Feira', '16:50', 2, 0 )");

                sts.executeUpdate("INSERT INTO disciplina (codigo, nome, dia, hora, total_aulas, nota)"
                        + "VALUES ('ISO200' , 'Sistemas Operacionais II ', 'Terça-Feira e Quarta-Feira', '16:50 e 13:10', 4, 0 )");
            }
            sts.close();
            conn.close();

        } catch (Exception ex) {
            exceptionMessage = ex.getMessage();
        }
        
        
    }

    @Override
    public void contextDestroyed(ServletContextEvent sce) {
    }
}
