/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lk.ijse.registration.dao.custom.impl;

import lk.ijse.registration.dao.custom.QueryDAO;
import org.hibernate.Session;

import javax.persistence.EntityManager;

/**
 *
 * @author SSNLIVE
 */
public class QueryDAOImpl implements QueryDAO{

    private Session session;

    @Override
    public void setEntityManager(EntityManager entityManager) {

    }
}
