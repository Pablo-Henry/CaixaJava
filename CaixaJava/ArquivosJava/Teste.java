/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package logicasjava;
import java.sql.*;

public class Teste {
    

public class ProcedureComSaidaSimplificada {

    private static final String CONNECTION_URL = "jdbc:sua_url_aqui";
    private static final String USER = "seu_usuario";
    private static final String PASSWORD = "sua_senha";

    public static void main(String[] args) {

        String sqlChamada = "{call obter_saldo_por_id(?, ?)}";
        double saldo = 0.0;

        try (Connection conn = DriverManager.getConnection(CONNECTION_URL, USER, PASSWORD);
             CallableStatement stmt = conn.prepareCall(sqlChamada)) {

            stmt.setInt(1, 45);

            stmt.registerOutParameter(2, Types.DOUBLE);

            stmt.execute();

            saldo = stmt.getDouble(2);

            System.out.println("O saldo da conta é: R$" + saldo);

        } catch (SQLException e) {
            System.err.println("Erro de SQL: " + e.getMessage());
        }
    }
}
}
