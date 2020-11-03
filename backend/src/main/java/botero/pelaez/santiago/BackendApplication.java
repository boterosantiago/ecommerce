package botero.pelaez.santiago;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import botero.pelaez.santiago.model.User;
import botero.pelaez.santiago.repository.UserRepository;

@SpringBootApplication
public class BackendApplication implements CommandLineRunner {

	public static void main(String[] args) {
		SpringApplication.run(BackendApplication.class, args);
	}
	
	@Autowired
	private UserRepository userRepository;

	@Override
	public void run(String... args) throws Exception {
		this.userRepository.save(new User("wachu", "juan123", "wachu@gmail.com", false));
		this.userRepository.save(new User("123", "123", "123@gmail.com", true));
	}

}
