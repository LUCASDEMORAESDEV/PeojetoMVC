<%@page import="Models.ProdutosModel"%>
<%@page import="Controllers.ProdutoController" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Editar Usuario</title>
    </head>
    <body>
        <h1>Editar Usuario</h1>

        <%
            String id = request.getParameter("id");
            ProdutosModel produto = ProdutoController.getProdutoById(Integer.parseInt(id));
        %>
        <form action="ServletProdutoUpdate" method="post">
            <input type="hidden" name="id" value="<%=produto.getIdProduto()%>"/>
            <table>
                <tr>
                    <td>Nome: </td>
                    <td><input type="text" name="nomeProduto" value="<%=produto.getNomeProduto()%>"/>
                    <td>Email: </td>
                    <td><input type="text" name="precoProduto" value="<%=produto.getPrecoProduto()%>"/>
                </tr>
                <tr>
                    <td><input type="submit"  value="Edit User"/></input></td>
                </tr>
            </table>
        </form>

    </body>
</html>
