package code.repository;

import code.model.Book;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

/**
 * Created by rajeevkumarsingh on 02/08/17.
 */
@Repository
public interface BookRepository extends JpaRepository<Book, Long> {
    public List<Book> findAllByOrderByIdAsc();
    public List<Book> findByNameOrAuthor(String name, String author);
}
