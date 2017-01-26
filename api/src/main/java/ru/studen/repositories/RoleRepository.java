package ru.studen.repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Component;
import ru.studen.entities.RoleEntity;

/**
 * Created in project students on 22.01.17
 */
@Component
public interface RoleRepository extends CrudRepository<RoleEntity, Long>
{
	RoleEntity findOneByName(String arg);
}
