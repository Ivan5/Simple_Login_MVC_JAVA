/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import model.LoginBean;

public class Login extends HttpServlet {

   

    //Controlador recibe  la peticion de tipo POST
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        //Se reciben los datos enviados desde el formulario por el usuario
        String name= request.getParameter("name");
        String password= request.getParameter("password");
        
        LoginBean bean = new LoginBean();
        bean.setName(name);
        bean.setPassword(password);
        
        //Procesamos los datos
        boolean status = bean.validate();
        
        //Compartimos el objeto para utilizarlo en la vista
        request.setAttribute("user", bean);
        
        //Dependiendo de lo que se haya validado se envia la respuesta(redirecciona)
        if (status) {
            RequestDispatcher rd = request.getRequestDispatcher("success.jsp");
            rd.forward(request, response);
        }else{
            RequestDispatcher rd = request.getRequestDispatcher("error.jsp");
            rd.forward(request, response);
        }
    }

    
}
