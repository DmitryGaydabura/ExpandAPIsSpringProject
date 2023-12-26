package com.example.expandapisspringproject.dao.repository;

import com.example.expandapisspringproject.dao.pojo.ProductRecord;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface ProductRecordRepository extends JpaRepository<ProductRecord, Integer> {

    @Query(value = "SELECT COUNT(*) " +
            "FROM information_schema.tables " +
            "WHERE table_schema = 'users' " +
            "AND table_name = ?1", nativeQuery = true)
    Integer checkIfTableExists(String tableName);


    @Query(value = "INSERT INTO ?1 (entryDate, itemCode, itemName, itemQuantity, status)\n" +
            "VALUES (?2, ?3, ?4, ?5, ?6);", nativeQuery = true)
    void addProductRecordToExistingTable(String tableName,
                                         String itemCode,
                                         String entryDate,
                                         String itemName,
                                         String itemQuantity,
                                         String status);
}
