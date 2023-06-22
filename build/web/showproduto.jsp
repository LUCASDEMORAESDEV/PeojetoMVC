<%@page import="java.util.List"%>
<%@page import="Models.ProdutosModel"%>
<%@page import="Controllers.*" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body> 
        <%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
        <h1>os usuarios estarão aqui</h1>
        <%
            List<ProdutosModel> listProdutos = ProdutoController.getAllProduto();
            request.setAttribute("listProdutos", listProdutos);
        %>
        <table>
            <tr>
                <th>ID</th>
                <th>Name</th>
                <th>PRECO</th>
            </tr>
            <c:forEach items="${listProdutos}" var="Produto">
                <tr>
                    <td>${Produto.getIdProduto()} </td>
                    <td>${Produto.getNomeProduto()} </td>
                    <td>${Produto.getPrecoProduto()} </td>
                    <td><a href="editproduto.jsp?id=${Produto.getIdProduto()}">EDIT</a></td>
                    <td><a href="deleteproduto.jsp?id=${Produto.getIdProduto()}">DELETE</a></td>
                </tr>
            </c:forEach>
        </table>
        <br>
        <a>Add User</a>
    </body>
</html