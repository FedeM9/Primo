package persistence;

import java.util.*;

import model.Opera;

public interface OperaCrudRepository {
	public Opera save(Opera opera);
	public Opera findOne(Long id);
	public List<Opera> findAll();
	public void delete(Opera opera);
	public void deleteAll();
}
