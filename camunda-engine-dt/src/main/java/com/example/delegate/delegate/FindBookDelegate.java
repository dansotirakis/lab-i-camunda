package com.example.delegate.delegate;

import com.example.delegate.clients.BookProducerClient;
import com.example.delegate.domain.Book.Book;
import lombok.AllArgsConstructor;
import org.camunda.bpm.engine.delegate.DelegateExecution;
import org.camunda.bpm.engine.delegate.JavaDelegate;
import org.springframework.stereotype.Component;

@AllArgsConstructor
@Component("findBookDelegate")
public class FindBookDelegate implements JavaDelegate {

    private BookProducerClient bookProducerClient;

    @Override
    public void execute(DelegateExecution delegateExecution) throws Exception {
        Book book = new Book();
        book.setId((int) delegateExecution.getVariable("book_id"));
        Book bookReturn = bookProducerClient.finBook(book.getId());
        delegateExecution.setVariable("book_name", bookReturn.getName());
        delegateExecution.setVariable("book_price", bookReturn.getPrice());

    }
}
