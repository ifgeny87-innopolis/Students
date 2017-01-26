package ru.studen.repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Component;
import ru.studen.entities.UserEntity;

/**
 * Created in project students on 21.01.17
 */
@Component
public interface UserRepository extends CrudRepository<UserEntity, Long>
{
	UserEntity findOneByName(String arg);
}
