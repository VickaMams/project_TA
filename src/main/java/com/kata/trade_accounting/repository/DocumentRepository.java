package com.kata.trade_accounting.repository;

import com.kata.trade_accounting.model.Document;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Date;

@Repository
public interface DocumentRepository extends JpaRepository<Document, Long> {

    @Modifying
    @Query("update Document set removed = true , dateOfDeletion = null where id = ?1")
    int setRemovedTrue(Long id);

    @Modifying
    @Query("update Document set dateOfDeletion = ?2 where id = ?1")
    int setDateOfDeletion(Long id, Date date);

    @Modifying
    @Query("update Document set dateOfDeletion = null where id = ?1")
    int resetDateOfDeletion(Long id);
}
