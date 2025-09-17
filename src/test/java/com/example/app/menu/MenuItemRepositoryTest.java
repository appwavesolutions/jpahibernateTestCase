package com.example.app.menu;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import java.math.BigDecimal;

import static org.assertj.core.api.Assertions.assertThat;

@DataJpaTest
class MenuItemRepositoryTest {
	@Autowired
	private MenuItemRepository repository;

	@Test
	void saveAndLoad() {
		MenuItem burger = new MenuItem("Burger", MenuItemType.FOOD, new BigDecimal("9.99"));
		MenuItem saved = repository.save(burger);
		assertThat(saved.getId()).isNotNull();
		assertThat(repository.findById(saved.getId())).isPresent();
	}
}
