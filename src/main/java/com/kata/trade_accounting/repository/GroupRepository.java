package com.kata.trade_accounting.repository;

import com.kata.trade_accounting.model.Group;
import org.springframework.data.jpa.repository.JpaRepository;


public interface GroupRepository  extends JpaRepository<Group, Long> {
}
