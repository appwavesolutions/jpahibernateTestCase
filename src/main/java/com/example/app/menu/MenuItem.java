package com.example.app.menu;

import jakarta.persistence.*;
import java.math.BigDecimal;

@Entity
@Table(name = "menu_items")
public class MenuItem {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@Column(nullable = false)
	private String name;

	@Column(nullable = false)
	@Enumerated(EnumType.STRING)
	private MenuItemType type;

	@Column(nullable = false)
	private BigDecimal price;

	public MenuItem() {}

	public MenuItem(String name, MenuItemType type, BigDecimal price) {
		this.name = name;
		this.type = type;
		this.price = price;
	}

	public Long getId() { return id; }
	public String getName() { return name; }
	public void setName(String name) { this.name = name; }
	public MenuItemType getType() { return type; }
	public void setType(MenuItemType type) { this.type = type; }
	public BigDecimal getPrice() { return price; }
	public void setPrice(BigDecimal price) { this.price = price; }
}
