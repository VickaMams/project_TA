package com.kata.trade_accounting.repository;

import com.kata.trade_accounting.model.SalesChannel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface SalesChannelRepository extends JpaRepository<SalesChannel, Long> {

    @Modifying
    @Query("update SalesChannel set removed = true where id = ?1")
    int setRemovedTrue(Long id);
}
