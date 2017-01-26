package ru.studen.impl;

import ru.studen.services.IRoleService;

/**
 * Created in project students on 26.01.17
 */
public class RoleServiceClient
{
	private IRoleService roleService;

	public void setRoleService(IRoleService s)
	{
		this.roleService = s;
	}

	public IRoleService getRoleService()
	{
		return roleService;
	}
}
