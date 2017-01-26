package ru.studen.entities;

import javax.persistence.*;

/**
 * Created in project students on 21.01.17
 */
@Entity
@Table(name="role")
public class RoleEntity
{
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@Column(name = "name")
	private String name;

	public Long getId()
	{
		return id;
	}

	public String getName()
	{
		return name;
	}

	public void setName(String name)
	{
		this.name = name;
	}
}
