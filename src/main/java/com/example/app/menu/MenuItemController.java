package com.example.app.menu;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping("/api/menu-items")
public class MenuItemController {
	private final MenuItemRepository repository;

	public MenuItemController(MenuItemRepository repository) {
		this.repository = repository;
	}

	@GetMapping
	public List<MenuItem> list() {
		return repository.findAll();
	}

	@PostMapping
	public ResponseEntity<MenuItem> create(@RequestBody MenuItem item) {
		MenuItem saved = repository.save(item);
		return ResponseEntity.created(URI.create("/api/menu-items/" + saved.getId())).body(saved);
	}
}
