/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.dao;

import com.connection.DBUtil;
import com.utileria.Modismo;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author rafaelm
 */
public class ModismoDao implements CRUD{

    private Connection connection;
 
    public ModismoDao(){
        connection = DBUtil.getConnection();
    }
    
    
    @Override
    public void create(Modismo modismo) {
       try{
           PreparedStatement preparedStatement =
 connection.prepareStatement("INSERT INTO modismo(palabra,definicion,zona) values ( ? , ? , ?)");
           preparedStatement.setString(1, modismo.getPalabra());
           preparedStatement.setString(2, modismo.getDefinicion());
           preparedStatement.setString(3, modismo.getRegion());
           
           preparedStatement.executeUpdate();
           
       }catch(Exception ex){
           ex.printStackTrace();
       }
    }

    @Override
    public List read() {
        List<Modismo> listaModismos = new ArrayList<>();
        try{
            Statement statement = connection.createStatement();
            ResultSet rs = statement.executeQuery("SELECT * FROM modismo");
            while(rs.next()){
                Modismo modismo = new Modismo();
                modismo.setIdPalabra(rs.getInt("id_palabra"));
                modismo.setPalabra(rs.getString("palabra"));
                modismo.setDefinicion(rs.getString("definicion"));
                modismo.setRegion(rs.getString("zona"));
                listaModismos.add(modismo);
            }
            
            
        } catch (SQLException ex) {
            ex.printStackTrace();
        }return listaModismos;
        
    }

    @Override
    public boolean update(Modismo modismo) {
        try {
            PreparedStatement preparedStatement = connection.prepareStatement("update modismo set palabra=?, definicion=?, zona=? where id_palabra=?");
            preparedStatement.setString(1, modismo.getPalabra());
            preparedStatement.setString(2, modismo.getDefinicion());
            preparedStatement.setString(3, modismo.getRegion());
            preparedStatement.setInt(4, modismo.getIdPalabra());
            
            return preparedStatement.executeUpdate() != 0 ;
            

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
        
    }

    @Override
    public void delete(int id_palabra) {
       try {
            PreparedStatement preparedStatement = connection.prepareStatement("delete from modismo where id_palabra=?");
            preparedStatement.setInt(1, id_palabra);
            preparedStatement.executeUpdate();
            
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public Modismo readById(int palabraId) {
        Modismo modismo = new Modismo();
        try{
            PreparedStatement preparedStatement = connection.prepareStatement("SELECT * FROM modismo WHERE id_palabra=?");
            preparedStatement.setInt(1, palabraId);
            ResultSet rs = preparedStatement.executeQuery();
            if(rs.next()){
                modismo.setIdPalabra(rs.getInt("id_palabra"));
                modismo.setPalabra(rs.getString("palabra"));
                modismo.setDefinicion(rs.getString("definicion"));
                modismo.setRegion(rs.getString("zona"));
            }
            
        }catch(Exception ex){
            ex.printStackTrace();
        }
        return modismo;
    }
    
    
    
}
