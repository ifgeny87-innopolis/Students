package ru.studen.services;

import org.springframework.security.core.userdetails.User;
import ru.studen.pojo.RolePojo;
import ru.studen.pojo.UserPojo;

import java.util.List;

/**
 * Created in project students on 26.01.17
 */
public interface IUserService
{
	UserPojo findByName(String arg);

	List<UserPojo> getAll();
}
