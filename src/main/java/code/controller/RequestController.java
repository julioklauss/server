package code.controller;

import code.exception.AppException;
import code.model.Book;
import code.model.Request;
import code.model.User;
import code.repository.BookRepository;
import code.repository.RequestRepository;
import code.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static code.model.Message.FailMsg;

@RestController
@RequestMapping("/api/request")
public class RequestController {
    @Autowired
    private RequestRepository requestRepository;
    @Autowired
    private UserRepository userRepository;
    @Autowired
    private BookRepository bookRepository;
    @GetMapping("/list")
//    @PreAuthorize("hasRole('USER')")
    public List<Request> listRequest() {
        return requestRepository.findAll();
    }

    @GetMapping("/create")
//    @PreAuthorize("hasRole('USER')")
    public Request createRequest(@RequestParam Long bookId, @RequestParam Long userId) {
        Request request = new Request();
        Book book = bookRepository.findById(bookId)
                .orElseThrow(() -> new AppException(FailMsg.getMsg()));
        request.setBook(book);

        User user = userRepository.findById(userId)
                .orElseThrow(() -> new AppException(FailMsg.getMsg()));
        request.setUser(user);
        request.setStatus(false);

        return requestRepository.save(request);
    }

    @PostMapping("{id}/delete")
    public void deleteBook(@PathVariable Long id) {
        requestRepository.deleteById(id);
    }

    @GetMapping("/test")
    public char test() {
        return 'd';
    }
}
