package com.sombra.test.training.dao.impl;

import com.sombra.test.training.dao.interfaces.GoodsDAO;
import com.sombra.test.training.entities.Goods;
import com.sombra.test.training.entities.Kind;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.MatchMode;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Restrictions;
import org.hibernate.transform.Transformers;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.faces.bean.ManagedBean;
import java.util.List;

@ManagedBean
@Repository
public class GoodsDaoImpl implements GoodsDAO {

    public GoodsDaoImpl() {

    }

    @Transactional
    @Override
    public List<Goods> getGoods() {
        Session session = HibernateUtil.getInstance().getSessionFactory().openSession();
        List<Goods> goods = (List<Goods>)session.createCriteria(Goods.class).setResultTransformer(Criteria.DISTINCT_ROOT_ENTITY).list();
        session.close();
        return goods;
    }

    @Transactional
    @Override
    public List<Goods> getGoods(Kind kind) {
        List<Goods> goods = createGoodList(createGoodCriteria().add(Restrictions.ilike("kind.name", kind.getName(), MatchMode.ANYWHERE)));
        return goods;
    }

    @Transactional
    @Override
    public List<Goods> getGoods(String goodName) {
        List<Goods> goods = createGoodList(createGoodCriteria().add(Restrictions.ilike("g.name", goodName, MatchMode.ANYWHERE)));
        return goods;
    }

    private DetachedCriteria createGoodCriteria() {
        DetachedCriteria goodListCriteria = DetachedCriteria.forClass(Goods.class, "g");
        createAliases(goodListCriteria);
        return goodListCriteria;
    }

    private void createAliases(DetachedCriteria criteria) {
        criteria.createAlias("g.kind", "kind");
    }

    private List<Goods> createGoodList(DetachedCriteria goodListCriteria) {
        Session session = HibernateUtil.getInstance().getSessionFactory().openSession();
        Criteria criteria = goodListCriteria.getExecutableCriteria(session);
        criteria.addOrder(Order.asc("g.name")).setResultTransformer(Transformers.aliasToBean(Goods.class));
        session.close();
        return criteria.list();
    }
}
