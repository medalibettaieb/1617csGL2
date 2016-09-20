package tn.esprit.cs.g2.services.interfaces;

import java.util.List;

public interface IDaoGeneric<T> {
	void add(T t);

	void delete(int id);

	void update(T t);

	T findById(int id);

	List<T> findAllTs();

}
