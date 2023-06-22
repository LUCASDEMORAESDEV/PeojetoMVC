<%@page import="Models.ProdutosModel"%>
<%@page import="Controllers.*" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; 
              charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <h1>Adicionar Usuario</h1>
        <form action="ServletProdutosCreate" method="post">
            <table>
                <tr>
                    <td>Nome: </td>
                    <td><input type="text" name="nomeProduto"/>
                </tr>
                <tr>
                    <td>PRECO</td>
                    <td><input type="number" name="precoProduto"/>
                </tr>
                <tr>
                    <td><input type="submit" value="ADD User"/></input></td>
                </tr>
            </table>
        </form>
    </body>
</html>
