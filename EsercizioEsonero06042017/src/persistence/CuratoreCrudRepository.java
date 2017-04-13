package persistence;

import java.util.*;

import model.Curatore;

public interface CuratoreCrudRepository {
	public Curatore save(Curatore opera);
	public Curatore findOne(Long id);
	public List<Curatore> findAll();
	public void delete(Curatore opera);
	public void deleteAll();
}
