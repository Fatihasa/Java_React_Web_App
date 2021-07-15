package kodlamaio.northwind.bussiness.abstracts;

import kodlamaio.northwind.core.entities.dataAccess.User;
import kodlamaio.northwind.core.utilities.results.DataResult;
import kodlamaio.northwind.core.utilities.results.Result;

public interface UserService {

	Result add(User user);
	
	DataResult<User> findByEmail(String email);
	
	
}
