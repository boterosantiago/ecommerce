package botero.pelaez.santiago;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import botero.pelaez.santiago.model.Category;
import botero.pelaez.santiago.model.Product;
import botero.pelaez.santiago.model.User;
import botero.pelaez.santiago.repository.CategoryRepository;
import botero.pelaez.santiago.repository.ProductRepository;
import botero.pelaez.santiago.repository.UserRepository;

@SpringBootApplication
public class BackendApplication implements CommandLineRunner {

	public static void main(String[] args) {
		SpringApplication.run(BackendApplication.class, args);
	}

	@Autowired
	private UserRepository userRepository;

//	@Autowired
//	private CategoryRepository categoryRepository;

	@Autowired
	private ProductRepository productRepository;

	@Override
	public void run(String... args) throws Exception {
		this.userRepository.save(new User("321", "321", "321@gmail.com", false));
		this.userRepository.save(new User("123", "123", "123@gmail.com", false));
		this.userRepository.save(new User("admin", "admin", "sanbope15@gmail.com", true));
		
		//Category category = new Category("Technology", "C:\\Users\\sanbope\\Pictures\\computer.jpg", null, null, null);
		Product product = new Product("Computer", "i5/8Ram/1TbHDD/GTX960 4Gb", 2, 10, 1000, null, null);
		//category.addProduct(product);
				
		//this.categoryRepository.save(category);
		this.productRepository.save(product);
		this.productRepository.save(new Product("Printer1", "HP", 8, 6, 300, null, null));
		this.productRepository.save(new Product("Printer2", "HP", 8, 6, 300, null, null));
		this.productRepository.save(new Product("Printer3", "HP", 8, 6, 300, null, null));
		this.productRepository.save(new Product("Printer4", "HP", 8, 6, 300, null, null));
		this.productRepository.save(new Product("Printer5", "HP", 8, 6, 300, null, null));
		this.productRepository.save(new Product("Printer6", "HP", 8, 6, 300, null, null));
		this.productRepository.save(new Product("Printer7", "HP", 8, 6, 300, null, null));
		this.productRepository.save(new Product("Printer8", "HP", 8, 6, 300, null, null));
		this.productRepository.save(new Product("Printer9", "HP", 8, 6, 300, null, null));
		this.productRepository.save(new Product("Printer10", "HP", 8, 6, 300, null, null));
		this.productRepository.save(new Product("Printer11", "HP", 8, 6, 300, null, null));
		this.productRepository.save(new Product("Printer12", "HP", 8, 6, 300, null, null));
		this.productRepository.save(new Product("Printer13", "HP", 8, 6, 300, null, null));
		this.productRepository.save(new Product("Printer14", "HP", 8, 6, 300, null, null));
		this.productRepository.save(new Product("Printer15", "HP", 8, 6, 300, null, null));
		this.productRepository.save(new Product("Printer16", "HP", 8, 6, 300, null, null));
		this.productRepository.save(new Product("Printer17", "HP", 8, 6, 300, null, null));
		this.productRepository.save(new Product("Printer18", "HP", 8, 6, 300, null, null));
		this.productRepository.save(new Product("Printer19", "HP", 8, 6, 300, null, null));
	}

}
