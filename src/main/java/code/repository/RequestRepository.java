package code.repository;

import code.model.Request;
import code.model.Transaction;
import code.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface RequestRepository extends JpaRepository<Request, Long> {

    @Query("SELECT a from  Request a where  a.user = user")
    List<Request> findByName(User user);

    List<Request> findFirstByUserIdAndBookId(Long userid, Long bookid);
    List<Request> findByBookId(Long id);

}
