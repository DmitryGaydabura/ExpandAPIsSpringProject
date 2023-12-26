package com.example.expandapisspringproject.dao.pojo;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;

import java.util.List;

public class Product {




    private String table;

    private List<ProductRecord> list;

    public String getTable() {
        return table;
    }

    public void setTable(String table) {
        this.table = table;
    }

    public List<ProductRecord> getList() {
        return list;
    }

    public void setList(List<ProductRecord> list) {
        this.list = list;
    }
}
