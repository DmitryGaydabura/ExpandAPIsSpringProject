package com.example.expandapisspringproject.service;

import com.example.expandapisspringproject.dao.pojo.Product;
import com.example.expandapisspringproject.dao.pojo.ProductRecord;
import com.example.expandapisspringproject.dao.repository.ProductRecordRepository;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class ProductService {

    @Autowired
    private Util util;

    @Autowired
    private ProductRecordRepository productRecordRepository;



    public void addProduct(Product product) {
        Boolean tableAlreadyExists = checkIfTableExists(product.getTable());
        if (tableAlreadyExists) {

            for (int i = 0; i < product.getList().size(); i++) {
                util.addProductRecord(product.getTable(), product.getList().get(i));
            }
            System.out.println(product.getList().size() + " records added to DB " + product.getTable());
        }else{
            util.createTable(product.getTable());
            for (int i = 0; i < product.getList().size(); i++) {
                util.addProductRecord(product.getTable(), product.getList().get(i));
            }
        }
    }







    private Boolean checkIfTableExists(String tableName) {
        System.out.println(productRecordRepository.checkIfTableExists(tableName));
        return productRecordRepository.checkIfTableExists(tableName) == 1;
    }

}
