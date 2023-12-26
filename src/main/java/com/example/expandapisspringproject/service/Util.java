package com.example.expandapisspringproject.service;

import com.example.expandapisspringproject.dao.pojo.ProductRecord;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
@Service
public class Util {

    @PersistenceContext
    private EntityManager entityManager;

    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Transactional
    public void addProductRecord(String tableName, ProductRecord record) {
        String sql = "INSERT INTO " + tableName + " (entry_date, item_code, item_name, item_quantity, status) VALUES (:entryDate, :itemCode, :itemName, :itemQuantity, :status)";
        Query query = entityManager.createNativeQuery(sql);
        query.setParameter("entryDate", record.getEntryDate());
        query.setParameter("itemCode", record.getItemCode());
        query.setParameter("itemName", record.getItemName());
        query.setParameter("itemQuantity", record.getItemQuantity());
        query.setParameter("status", record.getStatus());
        query.executeUpdate();
    }

    public void createTable(String table) {

        String sql = "CREATE TABLE IF NOT EXISTS " + table + " ("
                + "entry_date VARCHAR(255), "
                + "item_code VARCHAR(255), "
                + "item_name VARCHAR(255), "
                + "item_quantity VARCHAR(255), "
                + "status VARCHAR(255)"
                + ");";

        jdbcTemplate.execute(sql);
    }
}
