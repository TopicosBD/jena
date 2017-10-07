/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import negocio.Funcionario;
import util.HibernateUtil;
import java.util.List;
import org.hibernate.Session;

public class FuncionarioDAO extends HibernateUtil{
    
    private Funcionario funcionario = new Funcionario();

    public FuncionarioDAO() {
    }
    
    public FuncionarioDAO(Funcionario funcionario) {
        this.funcionario = funcionario;
    }

    public Funcionario getFuncionario() {
        return funcionario;
    }

    public void setFuncionario(Funcionario funcionario) {
        this.funcionario = funcionario;
    }
    
    /**
    * Busca as funcionários, limitando o resultado pelo parâmetro quantidade
    *
    * @param quantidade
    * @return
    */
    public List<Funcionario> getFuncionario(int quantidade) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        session.beginTransaction();
        List funcionarios = session.createCriteria(Funcionario.class).setMaxResults(quantidade).list();
        session.flush();
        session.close();
        return funcionarios;
    }
    
}

