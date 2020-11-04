package botero.pelaez.santiago;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import botero.pelaez.santiago.model.Product;
import botero.pelaez.santiago.model.User;
import botero.pelaez.santiago.repository.ProductRepository;
import botero.pelaez.santiago.repository.UserRepository;

@SpringBootApplication
public class BackendApplication implements CommandLineRunner {

	public static void main(String[] args) {
		SpringApplication.run(BackendApplication.class, args);
	}
	
	@Autowired
	private UserRepository userRepository;
	
	@Autowired
	private ProductRepository productRepository;

	@Override
	public void run(String... args) throws Exception {
		this.userRepository.save(new User("321", "321", "321@gmail.com", false));
		this.userRepository.save(new User("123", "123", "123@gmail.com", false));
		this.userRepository.save(new User("admin", "admin", "sanbope15@gmail.com", true));
		this.productRepository.save(new Product("Computer", "i5/8Ram/1TbHDD/GTX960 4Gb", 2, 1000, null, null));
	}

}
