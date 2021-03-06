package persistence;

import java.util.List;

import model.Product;

public interface ArtistaCrudRepository {
	public Product save(Product artista);
	public Product findOne(Long id);
	public List<Product> findAll();
	public void delete(Product artista);
	public void deleteAll();
}
