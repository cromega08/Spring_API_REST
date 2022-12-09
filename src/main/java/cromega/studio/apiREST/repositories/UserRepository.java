package cromega.studio.apiREST.repositories;

import cromega.studio.apiREST.models.User;
import org.springframework.data.repository.CrudRepository;

public interface UserRepository extends CrudRepository<User, Long> {
}
