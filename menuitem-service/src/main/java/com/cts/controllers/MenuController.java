package com.cts.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.cts.models.MenuItem;
import com.cts.services.MenuItemService;

@RestController
public class MenuController {
	
	@Autowired
	private MenuItemService menuItemService;
	
	@GetMapping("/")
	public List<MenuItem> getMenuItems(){
		List<MenuItem> menus =  menuItemService.getMenuItems();
		return menus;
	}
	
	@PostMapping("/add")
	public MenuItem addMenuItem(@RequestBody MenuItem menu) {
		MenuItem menuItem = menuItemService.addMenuItem(menu);
		return menuItem;
		
	}

}
