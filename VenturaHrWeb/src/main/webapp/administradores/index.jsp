<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Administrador</title>
    </head>

    <link href="https://fonts.googleapis.com/icon?family=Material+Icons" rel="stylesheet">
    <body bgcolor="#CCCCCC">
        <div align="center">
            <center>
                <table border="0" cellpadding="10" cellspacing="0" style="border-collapse: collapse" bordercolor="#111111" width="780" id="AutoNumber1" bgcolor="#FFFFFF">
                    <tr>
                        <td width="100%" bgcolor="#808080"><b><font size="4" color="#FFFFFF">VenturaHR (cabeçalho)</font></b></td>
                    </tr>
                    <tr>
                        <td width="100%">
                            <table border="1" cellpadding="5" cellspacing="0" style="border-collapse: collapse" bordercolor="#111111" width="100%" id="AutoNumber2">
                                <tr>
                                    <td width="500" valign="top">
                                        <p align="center"><font size="2"><b>Olá Administrador ${usuario.nome}</b></font></p>

                                        <c:if test="${empty usuarios}">
                                            <h3>Não há usuários cadastrados!</h3>
                                        </c:if>

                                        <c:if test="${not empty usuarios}">

                                            <table border="1" cellpadding="0" cellspacing="0" style="border-collapse: collapse" bordercolor="#111111" width="100%" id="AutoNumber3">
                                                <tr>
                                                    <th width="27%"><font size="2">Nome</font></th>
                                                    <th width="52%"><font size="2">E-mail</font></th>
                                                    <th width="21%"><font size="2">Tipo</font></th>
                                                    
                                                </tr>
                                                <c:forEach var="user" items="${usuarios}">
                                                <tr>
                                                    <td width="27%">${user.nome}</td>
                                                    <td width="52%">${user.email}</td>
                                                    <td width="21%">${user.tipo}</td>                                                   
                                                </tr>
                                                </c:forEach>
                                                
                                            </table>
                                        </c:if>
                                    </td>

                                </tr>
                            </table>
                        </td>
                    </tr>
                    <tr>
                        <td width="100%" bgcolor="#808080"><b><font size="4" color="#FFFFFF">(rodape)</font></b></td>
                    </tr>
                </table>
            </center>
        </div>


    </body>
</html>

