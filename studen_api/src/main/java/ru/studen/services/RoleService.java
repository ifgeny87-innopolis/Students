package ru.studen.services;

import org.springframework.beans.factory.annotation.Autowired;
import ru.studen.entities.RoleEntity;
import ru.studen.pojo.RolePojo;
import ru.studen.repositories.RoleRepository;

import java.util.ArrayList;
import java.util.List;

/**
 * Created in project students on 26.01.17
 */
public class RoleService implements IRoleService
{
	@Autowired
	private RoleRepository roleRepository;

	public RolePojo findByName(String arg)
	{
		return toPojo(roleRepository.findOneByName(arg));
	}

	@Override
	public List<RolePojo> getAll()
	{
		Iterable<RoleEntity> es = roleRepository.findAll();
		List<RolePojo> roles = new ArrayList<>();

		for (RoleEntity e : es) {
			roles.add(toPojo(e));
		}

		return roles;
	}

	private RolePojo toPojo(RoleEntity arg)
	{
		return (arg == null)
				? null
				: new RolePojo(arg.getId(), arg.getName());
	}
}
