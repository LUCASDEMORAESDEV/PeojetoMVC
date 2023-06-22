/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package Controllers;

import Models.ProdutosModel;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author andre
 */
@WebServlet(name = "ServletProdutosCreate", urlPatterns = {"/ServletProdutosCreate"})
public class ServletUserCreate extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        String nomeProduto = request.getParameter("nomeProduto");
        int preco = Integer.parseInt(request.getParameter("precoProduto"));
        
        // Crie um objeto UserModel com os dados recebidos
        ProdutosModel produto = new ProdutosModel();
        produto.setNomeProduto(nomeProduto);
        produto.setPrecoProduto(preco);
        // Chame o método no UserController para salvar o usuário no banco de dados
        ProdutoController.createProduto(produto);
        // Redirecione para uma página de sucesso ou exiba uma mensagem de sucesso
        response.sendRedirect("index.jsp");
    }

    @Override
    public String getServletInfo() {
        return "Short description";
    }
}
