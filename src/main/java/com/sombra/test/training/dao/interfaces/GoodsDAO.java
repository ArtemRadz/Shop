package com.sombra.test.training.dao.interfaces;

import com.sombra.test.training.entities.Goods;
import com.sombra.test.training.entities.Kind;

import java.util.List;

public interface GoodsDAO {
    List<Goods> getGoods();
    List<Goods> getGoods(Kind kind);
    List<Goods> getGoods(String goodName);
}

