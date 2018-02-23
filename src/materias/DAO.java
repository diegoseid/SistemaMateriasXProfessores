package materias;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 *
 * @author Diego Seid
 */
public class DAO {
    
    static Connection conexao = null;
    static Statement consulta;
    static ResultSet rs;
    
    public static void testeDaConexao() {
        try {
            conexao = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:XE", "system", "Oracleuni9");
            System.out.println("Conexao com o banco realizada com sucesso.");
        } catch (Exception e) {            
            System.out.println("Falha durante o teste de conexão!");
            e.printStackTrace();
        } finally {
            if (conexao != null) {
                try {
                    conexao.close();
                    System.out.println("Conexão com o banco encerrada com sucesso.");
                } catch (SQLException e) {
                    e.printStackTrace();
                    System.out.println("Falha no encerramento da conexão com o banco!");
                }
            }
        }
    }

   
   public void pesquisar(String chave, String Sql) {
        try {
          Cad_ProfessorController cadp = new Cad_ProfessorController();
          PrincipalController princ = new PrincipalController();
          conexao = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:XE", "system", "Oracleuni9");
            consulta = conexao.createStatement();
            rs = consulta.executeQuery(Sql);    

            while (rs.next()) {                
                   switch(chave){
                   case "Materia":
                       Cad_ProfessorController.BucarDados(rs.getString("MATERIA"));
                       break;
                   case "IDMateria":
                       cadp.IdMateriaP(rs.getInt("IDMATERIA"));
                       break;
                   case "Inicial":
                       //Inserir consulta padrão
                       princ.ListarDados(rs.getString(1), rs.getString(2), rs.getString(3));
                       break;
                   }                                
            }     
            
            consulta.close();
            rs.close();

        } catch (SQLException e) { 
           e.printStackTrace();
        }
    }

    public static void inserir(String sql) {
        try {
           conexao = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:XE", "system", "Oracleuni9");
            consulta = conexao.createStatement();
            consulta.executeUpdate(sql);

            consulta.close();

        } catch (SQLException e) {
            e.printStackTrace();
            System.out.println("Falha ao inserir dados na tabela!");
        }
    }

    public static void atualizar (String titulo, String id) {
        try {
            conexao = DriverManager.getConnection("jdbc:oracle:thin:@54.233.238.228:1251:XE", "system", "yazz");
            PreparedStatement atualizacao = null;
            String comando = "UPDATE tb_usuario_cadastro SET senha = ? WHERE Id_usuario = ?";
            atualizacao = conexao.prepareStatement(comando);
            atualizacao.setString(1,titulo);
            atualizacao.setString(2,id);
            atualizacao.executeUpdate();
            
            conexao.close();

        } catch (SQLException e) {
            //TratamentoDeErro(e);
            System.out.println("Falha ao alterar dados na tabela!");
        }
    }

   
}
