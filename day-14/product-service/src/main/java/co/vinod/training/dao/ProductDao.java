package co.vinod.training.dao;

import co.vinod.training.entity.Product;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

// An object of some class, created on the fly (at the runtime) that implements ProductDao is
// kept in the spring container. That class uses JPA EntityManager and EntityTransaction for
// all DB related activities.
@Repository
public interface ProductDao extends PagingAndSortingRepository<Product, Integer> {

    // findByXxx function -> return type can be either T or Iterable<T>
    // xxx --> a field in the T object
    public Iterable<Product> findByDiscontinued(Integer discontinued);

    @Query("from Product where unitPrice between ?1 and ?2")
    public Iterable<Product> findProductsByPriceRange(Double min, Double max);
}
