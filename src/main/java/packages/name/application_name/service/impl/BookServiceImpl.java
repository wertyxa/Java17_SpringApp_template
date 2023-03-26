package packages.name.application_name.service.impl;

import org.springframework.stereotype.Service;
import packages.name.application_name.dao.dto.request.BookCreateRequestDto;
import packages.name.application_name.dao.dto.request.BookUpdateRequestDto;
import packages.name.application_name.dao.entity.Book;
import packages.name.application_name.service.BookService;

import java.util.List;
import java.util.UUID;

@Service
public class BookServiceImpl implements BookService {
    @Override
    public Book create(BookCreateRequestDto request) {
        return null;
    }

    @Override
    public Book update(BookUpdateRequestDto request) {
        return null;
    }

    @Override
    public Book get() {
        return new Book(UUID.randomUUID(), "Author", 100, 1, 10, "Super Book", "This book the best");
    }

    @Override
    public List<Book> getAll() {
        return null;
    }

    @Override
    public void delete() {

    }
}
