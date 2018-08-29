package com.mangold.model;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.Date;

/**
 * Created by Bruno on 18/11/2015.
 */
@Getter
@Setter
@MappedSuperclass
@NoArgsConstructor
@EqualsAndHashCode(of = { "id" })
public abstract class BaseEntity {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	private Date creationDate;

	private Date lastModifiedDate;

	public BaseEntity(Long id) {
		this.id = id;
	}

	@PrePersist
	public void prePersist() {
		creationDate = new Date();
	}

	@PreUpdate
	public void preUpdate() {
		lastModifiedDate = new Date();
	}
}