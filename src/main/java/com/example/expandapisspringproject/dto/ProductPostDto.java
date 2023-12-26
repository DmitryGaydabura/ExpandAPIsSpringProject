package com.example.expandapisspringproject.dto;

import com.example.expandapisspringproject.dao.pojo.ProductRecord;
import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;

import java.util.List;

public class ProductPostDto {

    private String table;

    @JsonProperty("records")
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
