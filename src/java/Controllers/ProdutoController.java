//Pasta dos controllers
package Controllers;

/**
 *
 * @author andre
 */
//Pacotes necessarios para usar o banco e outras funções
import Models.ProdutosModel;
import java.util.List;
import Connections.ConnectionSQL;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class ProdutoController {
//Função para mostrar todos os Usuarios cadastrados no banco

    public static List<ProdutosModel> getAllProduto() {
        //Criar a conexão
        Connection con = null;
        ConnectionSQL connection = new ConnectionSQL();
        //Uma forma de você fazer uma inserção no banco mais segura, onde você prepara os parametros para serem inseridos.
        PreparedStatement pS;
        //Uma interface utilizada pra guardar dados vindos de um banco de dados.
        ResultSet rS;
        //Comando sql para selecionar todos os usuarios do banco
        String sql = "select * from Produtos";
        //Lista para guardar os usuarios do banco
        List ProdutoList = new ArrayList();
        try {
            //Pegar conexao com o banco
            con = connection.connection();
            pS = con.prepareStatement(sql);
            rS = pS.executeQuery();
            //para percorrer o resultset
            while (rS.next()) {
                //Atributos do banco, rS.getInt("id_user"), pega o resultado do banco e transforma em inteiro;
                //O que está dentro do get.Int("NOME DO ATRIBUTO NO BANCO") Tem que ser igual o nome que está no banco de dados.
                int id = rS.getInt("id");
                String nomeProduto = rS.getString("nome");
                int Preco = rS.getInt("preco");
                //Criando um novo usuario a partir dos valores no banco
                ProdutosModel produto = new ProdutosModel(id, nomeProduto, Preco);
                //Adicionando na nossa lista de usuarios
                ProdutoList.add(produto);
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        } finally {
            connection.TurnOffConnection(con);
        }
        //Retorna a lista com todos os usuarios do banco
        return ProdutoList;
    }

    public static ProdutosModel getProdutoById(int id) {
        ProdutosModel produtos = null;
        //Criar a conexão
        Connection con = null;
        ConnectionSQL connection = new ConnectionSQL();
        //Uma forma de você fazer uma inserção no banco mais segura, onde você prepara os parametros para serem inseridos.
        PreparedStatement pS;
        //Uma interface utilizada pra guardar dados vindos de um banco de dados.
        ResultSet rS;
        //Comando sql para selecionar todos os usuarios do banco
        String sql = "SELECT * FROM Produtos WHERE id=" + id;
        //Lista para guardar os usuarios do banco
        try {
            //Pegar conexao com o banco
            con = connection.connection();
            pS = con.prepareStatement(sql);
            rS = pS.executeQuery();
            //para percorrer o resultset
            while (rS.next()) {
                //Atributos do banco, rS.getInt("id_user"), pega o resultado do banco e transforma em inteiro;
                //O que está dentro do get.Int("NOME DO ATRIBUTO NO BANCO") Tem que ser igual o nome que está no banco de dados.
                String nomeProduto = rS.getString("nome");
                int preco = rS.getInt("preco");
                //Criando um novo usuario a partir dos valores no banco
                produtos = new ProdutosModel(id, nomeProduto, preco);
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        } finally {
            connection.TurnOffConnection(con);
        }
        //Retorna a lista com todos os usuarios do banco
        return produtos;
    }

    public static int updateProduto(ProdutosModel produto) {
        int status = 0;
        Connection con = null;
        ConnectionSQL connection = new ConnectionSQL();
        //Uma forma de você fazer uma inserção no banco mais segura, onde você prepara os parametros para serem inseridos.
        PreparedStatement pS;
        //Comando sql para selecionar todos os usuarios do banco
        String sql = "UPDATE Produtos SET nome =?, preco=? WHERE id=?";
        try {
            //Pegar conexao com o banco
            con = connection.connection();
            pS = con.prepareStatement(sql);
            //para alterar o nome o 1 é o primeiro "?", o 2 é o segundo "?" e o 3 é o terceiro "?"
            pS.setString(1, produto.getNomeProduto());
            pS.setInt(2, produto.getPrecoProduto());
            pS.setInt(3, produto.getIdProduto());
            status = pS.executeUpdate();
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        } finally {
            connection.TurnOffConnection(con);
        }
        //Retorna a lista com todos os usuarios do banco
        return status;
    }

    public static int createProduto(ProdutosModel produto) {
        int status = 0;
        Connection con = null;
        ConnectionSQL connection = new ConnectionSQL();
        //Uma forma de você fazer uma inserção no banco mais segura, onde você prepara os parametros para serem inseridos.
        PreparedStatement pS;
        //Comando sql para selecionar todos os usuarios do banco
        String sql = "INSERT INTO Produtos (nome,preco) VALUES (?,?)";
        try {
            //Pegar conexao com o banco
            con = connection.connection();
            pS = con.prepareStatement(sql);
            //para alterar o nome
            pS.setString(1, produto.getNomeProduto());
            pS.setInt(2, produto.getPrecoProduto());
            status = pS.executeUpdate();
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        } finally {
            connection.TurnOffConnection(con);
        }
        //Retorna a lista com todos os usuarios do banco
        return status;
    }

    public static int deleteProduto(int id) {
        int status = 0;
        Connection con = null;
        ConnectionSQL connection = new ConnectionSQL();
        //Uma forma de você fazer uma inserção no banco mais segura, onde você prepara os parametros para serem inseridos.
        PreparedStatement pS;
        //Comando sql para selecionar todos os usuarios do banco
        String sql = "DELETE FROM Produtos WHERE id=" + id;
        try {
            //Pegar conexao com o banco
            con = connection.connection();
            pS = con.prepareStatement(sql);
            //para alterar o nome
            status = pS.executeUpdate();
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        } finally {
            connection.TurnOffConnection(con);
        }
        //Retorna a lista com todos os usuarios do banco
        return status;
    }
}
