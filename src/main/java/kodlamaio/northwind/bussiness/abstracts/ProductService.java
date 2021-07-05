package kodlamaio.northwind.bussiness.abstracts;

import java.util.List;

import kodlamaio.northwind.entities.concrets.Product;

public interface ProductService {
	List<Product> getAll();
	
}
