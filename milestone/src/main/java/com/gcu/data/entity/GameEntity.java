package com.gcu.data.entity;

import java.math.BigDecimal;

import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Column;
import org.springframework.data.relational.core.mapping.Table;

@Table("games")
public class GameEntity {
	
	@Id
	private long id;
	
	@Column("NAME")
	private String name;
	
	@Column("PRICE")
	private BigDecimal price;
	
	@Column("CATEGORY")
	private String category;
	
	@Column("DESCRIPTION")
	private String description;
	
	public GameEntity() {
		super();
	}
	
	public GameEntity(String name,
					  BigDecimal price,
					  String category,
					  String description) {
		this.name = name;
		this.price = price;
		this.category = category;
		this.description = description;
		
		
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public BigDecimal getPrice() {
		return price;
	}

	public void setPrice(BigDecimal price) {
		this.price = price;
	}

	public String getCategory() {
		return category;
	}

	public void setCategory(String category) {
		this.category = category;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

}
