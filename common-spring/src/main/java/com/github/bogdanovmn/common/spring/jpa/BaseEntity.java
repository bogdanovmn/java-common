package com.github.bogdanovmn.common.spring.jpa;


import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;

@MappedSuperclass
public abstract class BaseEntity {
	@Id
	@GeneratedValue(
		strategy= GenerationType.AUTO,
		generator="native"
	)
	@GenericGenerator(
		name = "native",
		strategy = "native"
	)
	@Access(AccessType.PROPERTY)
	protected Integer id;

	public BaseEntity(Integer id) {
		this.id = id;
	}

	public BaseEntity() {}

	public Integer getId() {
		return id;
	}

	public BaseEntity setId(Integer id) {
		this.id = id;
		return this;
	}
}
