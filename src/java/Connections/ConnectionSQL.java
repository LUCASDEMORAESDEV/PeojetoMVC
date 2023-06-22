//Pasta aonde está o arquivo
package Connections;
//Dependencias para funcionamento das funções

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
/**
 *
 * @author andre
 */
public class ConnectionSQL {
    //ClassDriver - Obter a conexão com o driver do sql
    // final serve para não deixar ser alterado por nenhuma outra subclasse as variaveis.

    private final String classDriver = "com.mysql.cj.jdbc.Driver";
    //url para se conectar com o banco do localhost - tem que ter o mesmo nome do banco de dados.
    private final String url = "jdbc:mysql://localhost/ProdutosBase";
    //usuario para conectar no banco de dados.
    private final String user = "root";
    //senha para conectar no banco de dados.
    private final String pass = "";
    //Criando a conexão sql - provavelmente vai dar erro;
    //Tem que importar java.sql.Connection;

    public Connection connection() {
        Connection con = null;
        //Tenta fazer a conexão com o banco.
        try {
            //carregar o driver
            Class.forName(classDriver);
            //obter a conexão com a url e logando com o usuario e senha
            con = DriverManager.getConnection(url, user, pass);
        } //Caso falhe a conexão irá printar o erro.
        catch (ClassNotFoundException | SQLException e) {
            System.out.println(e.getMessage());
        }
        return con;
    }
    //Função para desligar a conexão com o banco

    public void TurnOffConnection(Connection con) {
        try {
            con.close();
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }
}
