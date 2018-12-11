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

    private Boolean status;

    private Long deadline;

    private Date createdAt;

    private Date returnAt;

    public Transaction() {
    }

    public Transaction(User user, Book book, Long deadline) {
        this.user = user;
        this.book = book;
        this.status = true;
        this.deadline = deadline;
        this.createdAt = new Date();
        /*this.returnAt = new Date(this.createdAt.getTime() + (this.deadline * 1000 * 60 * 60 * 24));*/
    }

    public Transaction(Request request){
        this.user = request.getUser();
        this.book = request.getBook();
        this.status = true;
        this.deadline = request.getDeadline();
        this.createdAt = new Date();
        /*this.returnAt = new Date(this.createdAt.getTime() + (this.deadline * 1000 * 60 * 60 * 24));*/
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
