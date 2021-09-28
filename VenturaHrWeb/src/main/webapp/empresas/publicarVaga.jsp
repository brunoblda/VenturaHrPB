<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Publicar Vaga</title>
    </head>
    <link href="https://fonts.googleapis.com/icon?family=Material+Icons" rel="stylesheet">
    <body bgcolor="#CCCCCC">
        <div align="center">
            <center>
                <table border="0" cellpadding="10" cellspacing="0" style="border-collapse: collapse" bordercolor="#111111" width="780" id="AutoNumber1" bgcolor="#FFFFFF">
                    <tr>
                        <td width="100%" bgcolor="#808080"><b><font size="4" color="#FFFFFF">VenturaHR</font></b></td>
                    </tr>
                    <tr>
                        <td width="100%">
                            <table border="1" cellpadding="5" cellspacing="0" style="border-collapse: collapse" bordercolor="#111111" width="100%" id="AutoNumber2">
                                <tr>
                                    <td width="500" valign="top">

                                        <p align="center"><font size="2"><b>Publicar Vaga</b></font></p>

                                        <form action="vaga" method="post">
                                            <input type="hidden" name="op" value="cadastrarVaga">


                                            <table border="1" cellpadding="0" cellspacing="0" style="border-collapse: collapse" bordercolor="#111111" width="100%" id="AutoNumber3">
                                                <tr>
                                                    <td>Cargo:</td>
                                                    <td><input type="text" name="cargo" value="${vaga.cargo}"></td>

                                                </tr>

                                                <tr>
                                                    <td>Cidade:</td>
                                                    <td><input type="text" name="cidade" value="${vaga.cidade}"></td>

                                                </tr>
                                                <tr>
                                                    <td>Forma de Contratação:</td>
                                                    <td><input type="text" name="formaContratacao" value="${vaga.formaContratacao}"></td>
                                                </tr>
                                            </table>

                                            <h3>Critérios:</h3>
                                            <table border="1" cellpadding="0" cellspacing="0" style="border-collapse: collapse" bordercolor="#111111" width="100%" id="AutoNumber3">
                                                <tr>
                                                    <td>Descrição</td>
                                                    <td>Perfil</td>
                                                    <td>Peso</td>
                                                </tr>
                                                <tr>
                                                    <td><input type="text" name="descricao"/></td>
                                                    <td><input type="text" name="perfil"/></td>
                                                    <td><input type="text" name="peso"/></td>
                                                </tr>
                                                <c:forEach var="criterio" items="${criterios}">
                                                    <tr>
                                                        <td>${criterio.descricao}</td>
                                                        <td>${criterio.perfil}</td>
                                                        <td>${criterio.peso}</td>

                                                    </tr>
                                                </c:forEach>

                                            </table>
                                            <input type="submit" name="op" value="Cadastrar" />
                                        </form>

                                    </td>

                                </tr>
                            </table>
                        </td>
                    </tr>
                    <tr>
                        <td width="100%" bgcolor="#808080"><b><font size="4" color="#FFFFFF">VenturaHR</font></b></td>
                    </tr>
                </table>
            </center>
        </div>


    </body>
</html>
