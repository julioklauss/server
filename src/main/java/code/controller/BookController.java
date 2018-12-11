package code.controller;

import code.exception.AppException;
import code.model.Book;
import code.payload.CreateBook;
import code.repository.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.Optional;

import static code.model.Message.FailMsg;

@RestController
@RequestMapping("/api")
public class BookController {
    @Autowired
    private BookRepository bookRepository;

    @GetMapping("/book")
//    @PreAuthorize("hasRole('USER')")
    public List<Book> listBook() {
        return bookRepository.findAllByOrderByIdAsc();
    }

    @PostMapping("/book")
    @PreAuthorize("hasRole('ADMIN')")
    public Book createBook(@Valid @RequestBody CreateBook requestBook) {
        Book book = new Book();
        book.setAuthor(requestBook.getAuthor());
        book.setName(requestBook.getName());
        book.setNumber(requestBook.getNumber());
        book.setCurrentNumber(requestBook.getNumber());
        return bookRepository.save(book);
    }

    @PostMapping("/book/{id}/delete")
    @PreAuthorize("hasRole('ADMIN')")
    public void deleteBook(@PathVariable Long id) {
        bookRepository.deleteById(id);
    }

    @GetMapping("book/search")
    public List<Book> search(@RequestParam String key) {
        return bookRepository.findByNameOrAuthor(key, key);
    }

    @GetMapping("book/{id}")
    public Book search(@PathVariable Long id) {
        Book book = bookRepository.findById(id)
                .orElseThrow(() -> new AppException(FailMsg.getMsg()));
        return book;
    }

    @RequestMapping(value = {"/test/", "/test"}, method = RequestMethod.POST)
    public CreateBook test(@Valid @RequestBody CreateBook book) {
        return book;
    }
}
