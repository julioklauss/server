package code.controller.Admin;

import code.model.Book;
import code.model.Request;
import code.model.Transaction;
import code.payload.RequestRequest;
import code.repository.RequestRepository;
import code.repository.TransactionRepository;
import code.response.ApiResponse;
import code.security.CurrentUser;
import code.security.UserPrincipal;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api")
public class VerifyController {

    @Autowired
    AuthenticationManager authenticationManager;

    @Autowired
    RequestRepository requestRepository;

    @Autowired
    TransactionRepository transactionRepository;

    @PostMapping("/admin/verify/{id}")
    @PreAuthorize("hasRole('ADMIN')")
    public ResponseEntity verifyRequest(@PathVariable Long id){

        Optional<Request> request= requestRepository.findById(id);

        request.get().getBook().updateCurrentNumber();

        Transaction transaction = new Transaction(request.get());
        transactionRepository.save(transaction);

        requestRepository.deleteById(id);

        return new ResponseEntity(new ApiResponse(true, "The borrowing request successfully sent"),
                HttpStatus.OK);
    }


    @GetMapping("/request/all")
    @PreAuthorize("hasRole('ADMIN')")
    public List<Request> listRequest() {
        return requestRepository.findAll();
    }

    @GetMapping("/transaction/all")
    @PreAuthorize("hasRole('ADMIN')")
    public List<Transaction> listTransaction() {
        return transactionRepository.findAll();
    }

    @PostMapping("/admin/return/{id}")
    @PreAuthorize("hasRole('ADMIN')")
    public ResponseEntity verifyReturn(@PathVariable Long id){

        Optional<Transaction> transaction= transactionRepository.findById(id);

        transaction.get().setStatus(false);
        transactionRepository.save(transaction.get());

        return new ResponseEntity(new ApiResponse(true, "The borrowing request successfully sent"),
                HttpStatus.OK);
    }
}
