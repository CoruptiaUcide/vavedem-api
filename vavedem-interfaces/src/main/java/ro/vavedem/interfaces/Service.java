package ro.vavedem.interfaces;



import javax.transaction.NotSupportedException;
import java.util.List;

public interface Service<T> {

    T findOne(Long id);

    List<T> findAll();

    T save(T model);

    void delete(T model) throws NotSupportedException;

    List<T> findByNume(String nume) throws NotSupportedException;
}
