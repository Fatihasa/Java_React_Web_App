package kodlamaio.northwind.api.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import kodlamaio.northwind.bussiness.abstracts.ProductService;
import kodlamaio.northwind.core.utilities.results.DataResult;
import kodlamaio.northwind.core.utilities.results.Result;
import kodlamaio.northwind.entities.concrets.Product;
import kodlamaio.northwind.entities.dtos.ProductWithCategoryDto;

@RestController
@RequestMapping("/api/products")
public class ProductsController {
	
	private ProductService productService;
	
	@Autowired
	public ProductsController(ProductService productService) {
		super();
		this.productService = productService;
	}

	@GetMapping("/getall")
	public DataResult<List<Product>> getAll(){
		
		return this.productService.getAll();
	}
	
	@PostMapping("/add")
	public Result add(@RequestBody Product product) {
		
		return this.productService.add(product);
	}
	
	@GetMapping("/getByProductName")
	public DataResult<Product> getByProductName(@RequestParam String productName){
		
		return this.productService.getByProductName(productName);
	}
	
	@GetMapping("/getMyProductNameAndCategoryId")
	public DataResult<Product> getMyProductNameAndCategoryId(@RequestParam("productName") String productName,@RequestParam("categoryId") int productId){
		
		return this.productService.getMyProductNameAndCategoryId(productName, productId);
	}
	
	
	@GetMapping("/getByProductNameContains")
	public DataResult<List<Product>> getByProductNameContains(@RequestParam String productName){
		
		return this.productService.getByProductNameContains(productName); 
	}
	
	@GetMapping("/getAllByPage")
	public DataResult<List<Product>> getAll(int pageNo, int pageSize){
		
		return this.productService.getAll(pageNo-1, pageSize);
	}
	
	@GetMapping("/getAllSortedDesc")
	public DataResult<List<Product>> getAllSorted() {
		
		return this.productService.getAllSorted();
	}
	
	@GetMapping("/getByCategoryIn")
	public DataResult<List<Product>> getByCategoryIn(@RequestParam("categoryId") List<Integer> categories){
		
		return this.productService.getByCategoryIdIn(categories);
	}
	
	@GetMapping("/getByProductNameOrCategory")
	public DataResult<List<Product>> getByProductNameOrCategory_CategoryId(@RequestParam("productName") String productName,@RequestParam("categoryId") int productId){
		
		return this.productService.getMyProductNameOrCategoryId(productName, productId);
	}
	
	@GetMapping("/NameStartsWith")
	public DataResult<List<Product>> getByProductNameStartsWith(@RequestParam("productName") String productName){
		
		return this.productService.getByProductNameStartsWith(productName);
	}
	
	@GetMapping("/getByNameAndCategory")
	public DataResult<List<Product>> getByNameAndCategory(@RequestParam("productName") String productName,@RequestParam("categoryId") int productId){
		
		return this.productService.getByNameAndCategory(productName, productId);
	}
	
	@GetMapping("/getProductWithCategoryDetails")
	public DataResult<List<ProductWithCategoryDto>> getProductWithCategoryDetails(){
		
		return this.productService.getProductWithCategoryDetails();
	}


}
