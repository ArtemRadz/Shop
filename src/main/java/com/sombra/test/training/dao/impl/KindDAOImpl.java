package com.sombra.test.training.dao.impl;

import com.sombra.test.training.dao.interfaces.KindDAO;
import com.sombra.test.training.entities.Kind;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.faces.bean.ManagedBean;
import java.util.List;

@ManagedBean
@Repository
public class KindDAOImpl implements KindDAO {

    @Transactional
    @Override
    public List<Kind> getKinds() {
        Session session = HibernateUtil.getInstance().getSessionFactory().openSession();
        List<Kind> kinds = session.createCriteria(Kind.class).list();
        session.close();
        return kinds;
    }
}
