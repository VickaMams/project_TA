package com.kata.trade_accounting.repository;

import com.kata.trade_accounting.model.Document;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface DocumentRepository extends JpaRepository<Document, Long> {

    @Modifying
    @Query("update Document set removed = true where id = ?1")
    int setRemovedTrue(Long id);

}
