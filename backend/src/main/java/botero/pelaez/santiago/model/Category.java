package botero.pelaez.santiago.model;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "categoria")
public class Category {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;

	@Column(name = "name")
	private String name;

	@Column(name = "photo")
	private String photo;

	@OneToOne
	private Category father;

	@OneToOne(mappedBy = "father")
	private Category child;

	@OneToMany(mappedBy = "category")
	List<Product> products;

	public Category(String name, String photo, Category father, Category child, List<Product> products) {
		super();
		this.name = name;
		this.photo = photo;
		this.father = father;
		this.child = child;
		this.products = products;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPhoto() {
		return photo;
	}

	public void setPhoto(String photo) {
		this.photo = photo;
	}

	public Category getFather() {
		return father;
	}

	public void setFather(Category father) {
		this.father = father;
	}

	public Category getChild() {
		return child;
	}

	public void setChild(Category child) {
		this.child = child;
	}

	public List<Product> getProducts() {
		return products;
	}

	public void setProducts(List<Product> products) {
		this.products = products;
	}

	public int getId() {
		return id;
	}

}