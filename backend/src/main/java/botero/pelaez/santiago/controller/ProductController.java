package botero.pelaez.santiago.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import botero.pelaez.santiago.exceptions.ExistException;
import botero.pelaez.santiago.model.Product;
import botero.pelaez.santiago.repository.ProductRepository;

@CrossOrigin(origins = "http://localhost:3000")
@RestController
@RequestMapping("/api/product")
public class ProductController {

	@Autowired
	private ProductRepository productRepository;

	@PostMapping("/")
	public Product addProduct(@RequestBody Product product) {
		productRepository.save(product);
		return product;
	}

	@PutMapping("/")
	public Product updateProduct(@RequestBody Product product) {
		productRepository.save(product);
		return product;
	}
	
	@DeleteMapping("/{id}")
	public String deteteProduct(@PathVariable int id) throws ExistException {
		productRepository.findById(id)
				.orElseThrow(() -> new ExistException("The product with id (" + id + ") doesn't exist"));
		
		productRepository.deleteById(id);
		
		return "The product with id (" + id + ") was deleted";
	}

	@GetMapping("/getAll")
	public List<Product> getProducts() {
		return productRepository.findAll();
	}

	@GetMapping("/findById/{id}")
	public Product getProduct(@PathVariable int id) throws ExistException {
		return productRepository.findById(id)
				.orElseThrow(() -> new ExistException("The product with id (" + id + ") doesn't exist"));
	}

}