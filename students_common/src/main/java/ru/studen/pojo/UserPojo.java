package ru.studen.pojo;

import java.util.Arrays;

/**
 * Created in project students on 26.01.17
 */
public class UserPojo
{
	private final Long id;

	private final String name;

	private final String hashPassword;

	private final RolePojo[] roles;

	public UserPojo(Long id, String name, String hashPassword, RolePojo[] roles)
	{
		this.id = id;
		this.name = name;
		this.hashPassword = hashPassword;
		this.roles = roles;
	}

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

	public RolePojo[] getRoles()
	{
		return Arrays.copyOf(roles, roles.length);
	}
}
