package com.sombra.test.training.objects;


import com.sombra.test.training.dao.impl.GoodsDaoImpl;
import com.sombra.test.training.dao.interfaces.GoodsDAO;
import com.sombra.test.training.entities.Goods;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.faces.bean.ManagedBean;
import java.awt.print.Book;
import java.util.List;

@Component
public class LibraryFacade {


    private GoodsDAO goodsDAO = new GoodsDaoImpl();

    private List<Goods> goods = goodsDAO.getGoods();

    public List<Goods> getGoods() {
        return goods;
    }
}
