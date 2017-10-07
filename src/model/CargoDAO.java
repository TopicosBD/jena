/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import negocio.Cargo;
import util.HibernateUtil;

import java.util.List;
import org.hibernate.HibernateException;
import org.hibernate.Session;

public class CargoDAO extends HibernateUtil {
    
    private Cargo cargo = new Cargo();

    public CargoDAO() {
    }
    
    public CargoDAO(Cargo cargo) {
        this.cargo = cargo;
    }

    public Cargo getCargo() {
        return cargo;
    }

    public void setCargo(Cargo cargo) {
        this.cargo = cargo;
    } 
    
    /**
     * Buscar por um cargo
     * @param cargo_id
     * @return 
     */
    public Cargo getCargo(int cargo_id) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        session.beginTransaction();
        Cargo cargo = (Cargo) session.get(Cargo.class, cargo_id);
        session.flush();
        session.close();
        return cargo;
    }
    
}
