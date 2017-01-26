package ru.studen.services;

import org.springframework.beans.factory.annotation.Autowired;
import ru.studen.entities.RoleEntity;
import ru.studen.entities.UserEntity;
import ru.studen.pojo.RolePojo;
import ru.studen.pojo.UserPojo;
import ru.studen.repositories.UserRepository;

import java.util.ArrayList;
import java.util.List;

/**
 * Created in project students on 26.01.17
 */
public class UserService implements IUserService
{
	@Autowired
	private UserRepository userRepository;

	public UserPojo findByName(String arg)
	{
		return toPojo(userRepository.findOneByName(arg));
	}

	@Override
	public List<UserPojo> getAll()
	{
		Iterable<UserEntity> es = userRepository.findAll();
		List<UserPojo> users = new ArrayList<>();

		for (UserEntity e : es) {
			users.add(toPojo(e));
		}

		return users;
	}

	private UserPojo toPojo(UserEntity arg)
	{
		return (arg == null)
				? null
				: new UserPojo(arg.getId(), arg.getName(), arg.getHashPassword(),
				null);
	}
}
