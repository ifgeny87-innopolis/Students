package ru.studen.services;

import ru.studen.pojo.RolePojo;

import java.util.List;

/**
 * Created in project students on 26.01.17
 */
public interface IRoleService
{
	RolePojo findByName(String arg);

	List<RolePojo> getAll();
}
