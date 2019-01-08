/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.dao;

import com.utileria.Modismo;
import java.util.List;
import org.junit.Test;



/**
 *
 * @author rafaelm
 */
public class ModismoDaoTest {
    
    public ModismoDaoTest() {
    }
    /*
   @Test
    public void testCreate(){
        Modismo modismo = new Modismo(0,"bichi","Persona desnuda", "Sinaloa" );
        ModismoDao modismoDao = new ModismoDao();
        modismoDao.create(modismo);
    }
    
    @Test
    public void testUpdate(){
         Modismo modismo = new Modismo(1,"Fierros","Unidad de medida de distancia y tiempo relativo", "Chihuahua" );
        ModismoDao modismoDao = new ModismoDao();
        assertTrue(modismoDao.update(modismo));
    }
    
    @Test
    public void testDelete(){
        ModismoDao modismoDao = new ModismoDao();
        modismoDao.delete(1);
    }*/
    
    @Test
    public void testRead(){
        ModismoDao modismoDao = new ModismoDao();
        List<Modismo> listaModismos = modismoDao.read();
        for(Modismo modismo :listaModismos ){
            System.out.println(modismo.getPalabra());
        }
    }
    
}
