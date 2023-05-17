package ecom.service;



import ecom.domain.Book;
import ecom.repository.BookRepository;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.time.LocalDate;
import java.util.List;
import java.util.logging.Logger;

@Service
@Transactional
public class BookService {

    private Logger logger = Logger.getLogger(StudentService.class.getName());

    private BookRepository bookRepository;

    public BookService(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }

    public List<Book> list() {
        return bookRepository.list();
    }

    public Book get(Long id) {
        return bookRepository.get(id);
    }

    public boolean create(Book book) {
        return bookRepository.create(book);
    }


    public boolean update(Book book) {
        return bookRepository.update(book);
    }

    public boolean delete(Long id) {
        return bookRepository.delete(get(id));
    }
}
