package code.model;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;
import java.util.Date;

@Entity
@Table(name = "Transaction")
public class Transaction {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name ="user_id")
    private User user;

    @ManyToOne
    @JoinColumn(name = "bookId")
    private Book book;

    @NotBlank
    @Size(max = 15)
    private Boolean status;

    @NotBlank
    @Size(max = 20)
    private Long deadline;

    @NotBlank
    @Size(max = 20)
    private Date createdAt;

    @NotBlank
    @Size(max = 20)
    private Date returnAt;

    public Transaction() {
    }

    public Transaction(User user, Book book, @NotBlank @Size(max = 20) Long deadline) {
        this.user = user;
        this.book = book;
        this.status = true;
        this.deadline = deadline;
        this.createdAt = new Date();
        this.returnAt = new Date(this.createdAt.getTime() + (this.deadline * 1000 * 60 * 60 * 24));
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Book getBook() {
        return book;
    }

    public void setBook(Book book) {
        this.book = book;
    }

    public Boolean getStatus() {
        return status;
    }

    public void setStatus(Boolean status) {
        this.status = status;
    }

    public Long getDeadline() {
        return deadline;
    }

    public void setDeadline(Long deadline) {
        this.deadline = deadline;
    }

    public Date getReturnAt() {
        return returnAt;
    }

    public void setReturnAt(Date returnAt) {
        this.returnAt = returnAt;
    }
}
