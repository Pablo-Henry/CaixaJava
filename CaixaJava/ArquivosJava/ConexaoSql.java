
package logicasjava;

import java.sql.*;
import java.util.Scanner;



public class ConexaoSql {
    
    static String servidor = "//DESKTOP-BU9D4VU\\SQLEXPRESS:1433"; //TBS0676762W11-1\SQLEXPRESS
    static String bancoDeDados = "caixa_java";
    private static final String CONNECTION_URL = 
            "jdbc:sqlserver:" + servidor + ";databaseName=" + bancoDeDados +
            ";integratedSecurity=true;trustServerCertificate=true;encrypt=true;";
    
    
    public static void procedure(String dado, double dado2, int dado3) {  
        int i = 1;
        int i2 = 2;

        
        String sqlChamadaProcedureProdutos = "{call P_INSERCAO_PRODUTOS(?, ?)}";
        String sqlChamadaProcedureEstoque = "{call P_INSERCAO_ESTOQUE(?)}";
        // realiza a conexão com o banco de dados                               // cria a variavel que recebe o parametros para realizar as ordens a procedure
        try(Connection conn = DriverManager.getConnection (CONNECTION_URL); 
                CallableStatement etms = conn.prepareCall(sqlChamadaProcedureProdutos); 
                CallableStatement etm = conn.prepareCall(sqlChamadaProcedureEstoque); 
                )
        {
            
            System.out.println("conexão estabelecida com sucesso!");
            
            // parametros da procedure EX: P_ATV_PROCEDURE_CLIENTE'João Silva', '(11) 9999-8888' , 'joao@email.com'
            etms.setString(i, dado);
            etms.setDouble(i2 , dado2);
            etm.setInt(i, dado3);
            

            
            
            etms.execute(); // manda um sinal para o banco executar a procedure
            etm.execute();
        }    
        catch (SQLException e) { 
            System.out.println("Erro de SQL:  " + e.getMessage());
        }
    }
    
    
        public static void procedureVendas(int dado, int dado2, int dado3) {  
        int i = 1;
        int i2 = 2;
        int i3 = 3;
        

        
        String sqlChamadaProcedureVendas = "{call P_CALCULO_VENDA(?, ?, ?)}";
        // realiza a conexão com o banco de dados                               // cria a variavel que recebe o parametros para realizar as ordens a procedure
        try(Connection conn = DriverManager.getConnection (CONNECTION_URL); 
                CallableStatement etms = conn.prepareCall(sqlChamadaProcedureVendas);)
        {
            
            System.out.println("conexão estabelecida com sucesso!");
            
            // parametros da procedure EX: P_ATV_PROCEDURE_CLIENTE'João Silva', '(11) 9999-8888' , 'joao@email.com'
            etms.setInt(i, dado);
            etms.setInt(i2 , dado2);
            etms.setInt(i3 , dado3);
            

            
            
            etms.execute(); // manda um sinal para o banco executar a procedure
        }    
        catch (SQLException e) { 
            System.out.println("Erro de SQL:  " + e.getMessage());
        }
    }
        
    public static void procedureVendasGet(int idProduto, String[] resultado) {  
       
        String sql = "SELECT p.id_prod, p.nome_prod, p.valor_prod, e.qtd_prod " +
                 "FROM tbl_produtos p " +
                 "LEFT JOIN tbl_estoque e ON p.id_prod = e.id_prod_fk " +
                 "WHERE p.id_prod = ?";
       
        
//        String sqlChamadaProcedureVendas = "{call P_CALCULO_VENDA(?, ?, ?)}";

        // realiza a conexão com o banco de dados                               // cria a variavel que recebe o parametros para realizar as ordens a procedure
        try (Connection conn = DriverManager.getConnection(CONNECTION_URL);
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            
            stmt.setInt(1, idProduto);
            ResultSet rs = stmt.executeQuery();
            
            if (rs.next()) {
                int id = rs.getInt("id_prod");
                String nome = rs.getString("nome_prod");
                double valor = rs.getDouble("valor_prod");
                int quantidade = rs.getInt("qtd_prod");
                
                String idConvertido = Integer.toString(id);
                String valorConvertido = Double.toString(valor);
                String quantidadeConvertido = Integer.toString(quantidade);
                
                resultado[0] = idConvertido;
                resultado[1] = nome;
                resultado[2] = valorConvertido;
                resultado[3] = quantidadeConvertido;
                
                System.out.println(resultado);
                
            } else {
                System.out.println("Produto não encontrado!");
                return;
            }
            
        } catch (SQLException e) {
            System.out.println("Erro de SQL ao buscar produto: " + e.getMessage());
            return;
        }
    }
   
    
    
    public static void main (String[]args){
        
//        procedure("Produto", 2, 2);

           String[] resultado = new String[4];

           procedureVendasGet(1, resultado);
          
//           System.out.println("ID: " + resultado[0]);
//           System.out.println("Nome: " + resultado[1]);
//           System.out.println("Valor: " + resultado[2]);
//           System.out.println("Estoque: " + resultado[3]);

             String id = resultado[0];
             String nome = resultado[1];
             String valor = resultado[2];
             String estoque = resultado[3];
             
             System.out.println(id);
             System.out.println(nome);
             System.out.println(valor);
             System.out.println(estoque);
        
    }
}

