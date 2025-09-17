package com.example.app.request;

import java.math.BigDecimal;
import java.util.List;

public class PlaceOrderParams extends Params {
	public static class Item {
		private String sku;
		private int qty;

		public Item() {}

		public String getSku() {
			return sku;
		}

		public void setSku(String sku) {
			this.sku = sku;
		}

		public int getQty() {
			return qty;
		}

		public void setQty(int qty) {
			this.qty = qty;
		}
	}

	private List<Item> items;
	private BigDecimal total;

	public PlaceOrderParams() {}

	public List<Item> getItems() {
		return items;
	}

	public void setItems(List<Item> items) {
		this.items = items;
	}

	public BigDecimal getTotal() {
		return total;
	}

	public void setTotal(BigDecimal total) {
		this.total = total;
	}
}

