package com.cts.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cts.models.MenuItem;
import com.cts.repositories.MenuItemRepository;

@Service
public class MenuItemService {

	@Autowired
	private MenuItemRepository menuItemRepository;

	public List<MenuItem> getMenuItems() {
		List<MenuItem> menuItems = menuItemRepository.findAll();
		return menuItems;
	}
	
	public MenuItem addMenuItem(MenuItem menu) {
		MenuItem menuItem = menuItemRepository.save(menu);
		return menuItem;
	}
}
