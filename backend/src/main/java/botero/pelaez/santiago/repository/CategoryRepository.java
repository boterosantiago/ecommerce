package botero.pelaez.santiago.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import botero.pelaez.santiago.model.Category;

@Repository
public interface CategoryRepository extends JpaRepository<Category, Integer> {

}