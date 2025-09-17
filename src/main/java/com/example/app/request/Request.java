package com.example.app.request;

import jakarta.persistence.*;
import com.vladmihalcea.hibernate.type.json.JsonType;
import org.hibernate.annotations.Type;

@Entity
@Table(name = "requests")
public class Request {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@Column(nullable = false)
	private String type;

	@Type(JsonType.class)
	@Column(columnDefinition = "jsonb")
	private Params params;

	public Request() {}

	public Request(String type, Params params) {
		this.type = type;
		this.params = params;
	}

	public Long getId() { return id; }

	public String getType() { return type; }
	public void setType(String type) { this.type = type; }

	public Params getParams() { return params; }
	public void setParams(Params params) { this.params = params; }
}
