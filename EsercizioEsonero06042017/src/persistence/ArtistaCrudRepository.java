package persistence;

import java.util.List;

import model.Artista;

public interface ArtistaCrudRepository {
	public Artista save(Artista artista);
	public Artista findOne(Long id);
	public List<Artista> findAll();
	public void delete(Artista artista);
	public void deleteAll();
}
