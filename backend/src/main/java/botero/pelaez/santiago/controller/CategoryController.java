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
import botero.pelaez.santiago.model.Category;
import botero.pelaez.santiago.repository.CategoryRepository;

@CrossOrigin(origins = "http://localhost:3000")
@RestController
@RequestMapping("/api/category")
public class CategoryController {

	@Autowired
	private CategoryRepository categoryRepository;

	@PostMapping("/")
	public Category addCategory(@RequestBody Category category) {
		categoryRepository.save(category);
		return category;
	}

	@PutMapping("/")
	public Category updateCategory(@RequestBody Category category) {
		categoryRepository.save(category);
		return category;
	}
	
	@DeleteMapping("/{id}")
	public String deteteCategory(@PathVariable int id) throws ExistException {
		categoryRepository.findById(id)
				.orElseThrow(() -> new ExistException("The category with id (" + id + ") doesn't exist"));
		
		categoryRepository.deleteById(id);
		
		return "The category with id (" + id + ") was deleted";
	}

	@GetMapping("/getAll")
	public List<Category> getCategories() {
		return categoryRepository.findAll();
	}

	@GetMapping("/findById/{id}")
	public Category getCategory(@PathVariable int id) throws ExistException {
		return categoryRepository.findById(id)
				.orElseThrow(() -> new ExistException("The category with id (" + id + ") doesn't exist"));
	}

}