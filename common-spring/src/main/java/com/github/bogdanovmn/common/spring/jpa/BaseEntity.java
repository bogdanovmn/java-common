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
	protected Long id;

	public BaseEntity(Long id) {
		this.id = id;
	}

	public BaseEntity() {}

	public Long getId() {
		return id;
	}

	public BaseEntity setId(Long id) {
		this.id = id;
		return this;
	}
}
