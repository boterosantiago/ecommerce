package botero.pelaez.santiago.controller;

import java.util.List;

import javax.mail.MessagingException;

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
import botero.pelaez.santiago.model.User;
import botero.pelaez.santiago.repository.Email;
import botero.pelaez.santiago.repository.UserRepository;

@CrossOrigin(origins = "http://localhost:3000")
@RestController
@RequestMapping("/api/user")
public class UserController {

	@Autowired
	private UserRepository userRepository;

	@PostMapping("/")
	public User addUser(@RequestBody User user) {
		userRepository.save(user);
		return user;
	}

	@PutMapping("/")
	public User updateUser(@RequestBody User user) {
		userRepository.save(user);
		return user;
	}

	@DeleteMapping("/{id}")
	public String deteteUser(@PathVariable int id) throws ExistException {
		userRepository.findById(id)
				.orElseThrow(() -> new ExistException("The user with id (" + id + ") doesn't exist"));

		userRepository.deleteById(id);

		return "The user with id (" + id + ") was deleted";
	}

	@GetMapping("/getAll")
	public List<User> getUsers() {
		return userRepository.findAll();
	}

	@GetMapping("/findById/{id}")
	public User getUser(@PathVariable int id) throws ExistException {
		return userRepository.findById(id)
				.orElseThrow(() -> new ExistException("The user with id (" + id + ") doesn't exist"));
	}

	@GetMapping("/findByUser/{user}")
	public User getUser(@PathVariable String user) throws ExistException {
		List<User> users = getUsers();
		if (users != null) {
			for (User u : users) {
				if (u.getUser().equalsIgnoreCase(user)) {
					return u;
				}
			}
		}
		throw new ExistException("The user with user (" + user + ") doesn't exist");
	}

	@GetMapping("/getId/{user}")
	public int getId(@PathVariable String user) throws ExistException {
		List<User> users = getUsers();
		if (users != null) {
			for (User u : users) {
				if (u.getUser().equalsIgnoreCase(user)) {
					return u.getId();
				}
			}
		}
		throw new ExistException("The user with user (" + user + ") doesn't exist");
	}

	@GetMapping("/findByEmail/{email}")
	public User findByEmail(@PathVariable String email) throws ExistException {
		List<User> users = getUsers();
		if (users != null) {
			for (User u : users) {
				if (u.getEmail().equalsIgnoreCase(email)) {
					return u;
				}
			}
		}
		throw new ExistException("The user with email (" + email + ") doesn't exist");
	}

	@GetMapping("/login/{user}/{password}")
	public String login(@PathVariable String user, @PathVariable String password) throws ExistException {
		User u = getUser(user);
		if (u.isAdmin()) {
			if (u.getPassword().equals(password)) {
				String code = getRandomCode(8);

				Email email = new Email();
				try {
					email.send(u.getEmail(), "Ecommerce authentication", "Code: " + code);

					return code;
				} catch (MessagingException e) {
					System.err.println(e.getMessage());
					return "error";
				}

			}
		}
		return u.getPassword().equals(password) ? "true" : "false";
	}

	private String getRandomCode(int lenght) {
		String code = "";

		for (int i = 0; i < lenght; i++) {
			switch (getRandom(1, 3)) {
			case 1:
				code += "" + ((char) getRandom(48, 57));
				break;
			case 2:
				code += "" + ((char) getRandom(65, 90));
				break;
			case 3:
				code += "" + ((char) getRandom(97, 122));
				break;
			default:
				code += "k";
				break;
			}
		}

		return code;
	}

	private int getRandom(int min, int max) {
		return (int) (Math.random() * ((max + 1) - min)) + min;
	}

}