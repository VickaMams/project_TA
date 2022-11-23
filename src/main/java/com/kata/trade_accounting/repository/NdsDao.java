package com.kata.trade_accounting.repository;


import com.kata.trade_accounting.model.Nds;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface NdsDao extends JpaRepository<Nds, Long> {

}
