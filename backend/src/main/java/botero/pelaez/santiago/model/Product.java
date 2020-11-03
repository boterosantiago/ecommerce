package botero.pelaez.santiago.model;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "producto")
public class Product {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;

	@Column(name = "name")
	private String name;

	@Column(name = "description")
	private String description;

	@Column(name = "weight")
	private double weight;

	@Column(name = "usd")
	private double usd;

	@ManyToOne
	private Category category;

	@ElementCollection
	private List<String> photos;

	public Product(String name, String description, double weight, double usd, Category category,
			List<String> photos) {
		super();
		this.name = name;
		this.description = description;
		this.weight = weight;
		this.usd = usd;
		this.category = category;
		this.photos = photos;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public double getWeight() {
		return weight;
	}

	public void setWeight(double weight) {
		this.weight = weight;
	}

	public double getUsd() {
		return usd;
	}

	public void setUsd(double usd) {
		this.usd = usd;
	}

	public Category getCategory() {
		return category;
	}

	public void setCategory(Category category) {
		this.category = category;
	}

	public List<String> getPhotos() {
		return photos;
	}

	public void setPhotos(List<String> photos) {
		this.photos = photos;
	}

	public int getId() {
		return id;
	}

}