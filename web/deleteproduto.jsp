
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
        <h1>TEM CERTEZA?</h1>

        <%
            String id = request.getParameter("id");
            ProdutosModel produto = ProdutoController.getProdutoById(Integer.parseInt(id));
        %>
        <form action="ServletProdutoDelete" method="get">
            <input type="hidden" name="id" value="<%=produto.getIdProduto()%>"/>
            <table>
                <tr>
                    <td><input type="submit"  value="Delete User"/></input></td>
                </tr>
            </table>
        </form>

    </body>
</html>