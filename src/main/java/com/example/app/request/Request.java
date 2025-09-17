package com.example.app.request;

import jakarta.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "requests")
public class Request {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@Column(nullable = false)
	private String title;

	@Column(length = 4000)
	private String details;

	@Column(nullable = false)
	private LocalDateTime createdAt = LocalDateTime.now();

	public Request() {}

	public Request(String title, String details) {
		this.title = title;
		this.details = details;
	}

	public Long getId() { return id; }
	public String getTitle() { return title; }
	public void setTitle(String title) { this.title = title; }
	public String getDetails() { return details; }
	public void setDetails(String details) { this.details = details; }
	public LocalDateTime getCreatedAt() { return createdAt; }
	public void setCreatedAt(LocalDateTime createdAt) { this.createdAt = createdAt; }
}
