package com.github.bogdanovmn.common.spring.jpa;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.NoRepositoryBean;

@NoRepositoryBean
public interface BaseEntityRepository<EntityT extends BaseEntity>
	extends JpaRepository<EntityT, Integer> {

}