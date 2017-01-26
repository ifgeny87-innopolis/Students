package ru.studen.entities;

import javax.persistence.*;
import java.util.List;

/**
 * Created in project students on 21.01.17
 */
@Entity
@Table(name = "user")
public class UserEntity
{
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@Column(name = "name")
	private String name;

	@Column(name = "hashPassword")
	private String hashPassword;

	@ManyToMany(fetch = FetchType.EAGER)
	@JoinTable(name = "role2user",
		joinColumns = @JoinColumn(name = "user_id"),
		inverseJoinColumns = @JoinColumn(name = "role_id"))
	private List<RoleEntity> roles;

	// Getters

	public Long getId()
	{
		return id;
	}

	public String getName()
	{
		return name;
	}

	public String getHashPassword()
	{
		return hashPassword;
	}

	public List<RoleEntity> getRoles()
	{
		return roles;
	}

	// Setters

	public void setName(String name)
	{
		this.name = name;
	}

	public void setHashPassword(String hashPassword)
	{
		this.hashPassword = hashPassword;
	}

	public void setRoles(List<RoleEntity> roles)
	{
		this.roles = roles;
	}
}
