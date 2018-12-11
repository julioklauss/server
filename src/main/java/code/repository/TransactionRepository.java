package code.repository;

import code.model.User;
import code.model.Transaction;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TransactionRepository extends JpaRepository<Transaction, Long> {

    @Query("SELECT a from  Transaction  a where  a.user = user")
    List<Transaction> findByName(User user);
}
