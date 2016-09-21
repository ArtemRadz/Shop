package com.sombra.test.training.entities;

import java.io.Serializable;
import java.util.Arrays;

public class Goods implements Serializable{
    private long id;
    private String name;
    private long price;
    private Kind kind;
    private byte[] image;
    private String descr;

    public Goods() {}

    public Goods(long id, String name, long price, Kind kind, byte[] image, String descr) {
        this.id = id;
        this.name = name;
        this.price = price;
        this.kind = kind;
        this.image = image;
        this.descr = descr;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public long getPrice() {
        return price;
    }

    public void setPrice(long price) {
        this.price = price;
    }

    public Kind getKind() {
        return kind;
    }

    public void setKind(Kind kind) {
        this.kind = kind;
    }

    public byte[] getImage() {
        return image;
    }

    public void setImage(byte[] image) {
        this.image = image;
    }

    public String getDescr() {
        return descr;
    }

    public void setDescr(String descr) {
        this.descr = descr;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Goods goods = (Goods) o;

        if (id != goods.id) return false;
        if (price != goods.price) return false;
        if(!kind.equals(goods.kind)) return false;
        if (name != null ? !name.equals(goods.name) : goods.name != null) return false;
        if (!Arrays.equals(image, goods.image)) return false;
        if (descr != null ? !descr.equals(goods.descr) : goods.descr != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = (int) (id ^ (id >>> 32));
        result = 31 * result + (name != null ? name.hashCode() : 0);
        result = 31 * result + (int) (price ^ (price >>> 32));
        result = 31 * result + kind.hashCode();
        result = 31 * result + Arrays.hashCode(image);
        result = 31 * result + (descr != null ? descr.hashCode() : 0);
        return result;
    }
}
