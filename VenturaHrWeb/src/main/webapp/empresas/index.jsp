<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Empresa</title>
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
                                        
                                        <p align="center"><font size="2"><b>Vagas publicadas por ${usuario.nome}</b></font></p>

                                <c:if test="${empty vagas}">
                                    <h3>Não há vagas publicadas!</h3>
                                </c:if>

                                <c:if test="${not empty usuarios}">

                                    <table border="1" cellpadding="0" cellspacing="0" style="border-collapse: collapse" bordercolor="#111111" width="100%" id="AutoNumber3">
                                        <tr>
                                            <th width="18%"><font size="2">Cargo</font></th>
                                            <th width="18%"><font size="2">Cidade</font></th>
                                            <th width="18%"><font size="2">Critérios</font></th>
                                            <th width="18%"><font size="2">Perfil</font></th>
                                            <th width="18%"><font size="2">Peso</font></th>

                                        </tr>
                                        <c:forEach var="vaga" items="${vagas}">
                                            <tr>
                                                <td width="18%">${vaga.cargo}</td>
                                                <td width="18%">${vaga.cidade}</td>
                                                <td width="18%">
                                            <c:forEach var="criterio" items="${vaga.criterioList}">
                                                ${criterio.descricao} <br>      
                                            </c:forEach>
                                            </td>
                                            <td width="18%">
                                            <c:forEach var="criterio" items="${vaga.criterioList}">
                                                ${criterio.perfil} <br>      
                                            </c:forEach>
                                            </td>
                                            <td width="18%">
                                            <c:forEach var="criterio" items="${vaga.criterioList}">
                                                ${criterio.peso} <br>      
                                            </c:forEach>
                                            </td>

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
