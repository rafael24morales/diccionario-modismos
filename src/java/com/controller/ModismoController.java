/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.controller;

import com.dao.ModismoDao;
import com.utileria.Modismo;
import java.io.IOException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author rafaelm
 */
@WebServlet("/ModismoController")
public class ModismoController extends HttpServlet{
    
    private static final String LISTAR_PALABRAS = "VISTAS/listaPalabras.jsp";
    private static final String AGREGAR = "VISTAS/agregar.jsp";
    private ModismoDao dao;
    
    public ModismoController(){
        dao = new ModismoDao();
    }
    
    
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
        String forward = "";
        
        String accion = request.getParameter("accion");
        
        if(accion.equals("listaPalabras")){
            forward = LISTAR_PALABRAS;
           
            dao = new ModismoDao();
            request.setAttribute("palabras", dao.read());
        }
        
        else if(accion.equals("editar")){
            forward = AGREGAR;
            int palabraId = Integer.parseInt(request.getParameter("palabraId"));
            
            Modismo modismo = dao.readById(palabraId);
            
            request.setAttribute("palabra", modismo);
            
        }
        else{
            forward = AGREGAR;
            System.out.println("NOENTRAAA");
            System.out.println(forward);
                
        }
        
        
        RequestDispatcher view = request.getRequestDispatcher(forward);
        view.forward(request, response);
    }
   
    
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
        Modismo modismo = new Modismo();
        
        String palabraId = request.getParameter("palabraId");
        String palabra = request.getParameter("palabra");
        String definicion = request.getParameter("definicion");
        String region = request.getParameter("region");

        modismo.setPalabra(palabra);
        modismo.setDefinicion(definicion);
        modismo.setRegion(region);
        
        if(palabraId == null || palabraId.isEmpty()){
              dao.create(modismo);
        }else{
            modismo.setIdPalabra(Integer.parseInt(palabraId));
            dao.update(modismo);
        }
        
       
        RequestDispatcher view = request.getRequestDispatcher(LISTAR_PALABRAS);
        request.setAttribute("palabras", dao.read());
        view.forward(request, response);
    }
    
    
}

