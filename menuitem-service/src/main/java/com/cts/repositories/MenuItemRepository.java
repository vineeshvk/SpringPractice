package com.cts.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.cts.models.MenuItem;

public interface MenuItemRepository extends JpaRepository<MenuItem, Integer> {

}
