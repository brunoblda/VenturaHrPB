
package br.edu.infnet.app.vagas;

import br.edu.infnet.domain.vagas.Criterio;
import br.edu.infnet.domain.vagas.Vaga;
import br.edu.infnet.infra.vagas.VagaService;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author bruno
 */
@WebServlet(name = "VagaController", urlPatterns = {"/vaga"})
public class VagaController extends HttpServlet {

    
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        HttpSession session = request.getSession();
        
        String op = request.getParameter("op");
        if(op.equals("cadastrarVaga")){
            
            Vaga vaga = new Vaga();
            vaga.setCargo(request.getParameter("cargo"));
            vaga.setCidade(request.getParameter("cidade"));
            vaga.setTipoContratacao(request.getParameter("tipoContratacao"));
            
            session.setAttribute("vaga", vaga);
            
            List<Criterio> criterios = (List<Criterio>) session.getAttribute("criterios");
            if(criterios == null){
                criterios = new ArrayList<>(); 
            }
            Criterio criterio = new Criterio();
            
            criterio.setDescricao(request.getParameter("descricao"));
            criterio.setPerfil(Integer.parseInt(request.getParameter("perfil")));
            criterio.setPeso(Integer.parseInt(request.getParameter("peso")));
            
            criterios.add(criterio);
            
        } else if (op.equals("Cadastrar")){
            
            Vaga vaga = (Vaga) session.getAttribute("vaga");
            
            List<Criterio> criterios = (List<Criterio>) session.getAttribute("criterios");
            
            vaga.setCriterioList(criterios);
            
            VagaService vagaService = new VagaService();
            
            Vaga vagaPublicada = vagaService.criarVaga(vaga);
            
            request.setAttribute("vaga", vagaPublicada);
        }
        
        RequestDispatcher rd = request.getRequestDispatcher("usuarios");
        rd.forward(request, response);
    }


    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
