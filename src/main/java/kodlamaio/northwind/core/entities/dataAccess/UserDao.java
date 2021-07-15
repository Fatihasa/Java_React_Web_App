package kodlamaio.northwind.core.entities.dataAccess;

import org.springframework.data.jpa.repository.JpaRepository;

public interface UserDao extends JpaRepository<User, Integer> {

	User findByEmail(String email);
}
