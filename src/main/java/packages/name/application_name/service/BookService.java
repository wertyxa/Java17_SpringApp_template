package packages.name.application_name.service;

import packages.name.application_name.dao.dto.request.BookCreateRequestDto;
import packages.name.application_name.dao.dto.request.BookUpdateRequestDto;
import packages.name.application_name.dao.entity.Book;

import java.util.List;

public interface BookService {
    Book create(BookCreateRequestDto request);
    Book update(BookUpdateRequestDto request);
    Book get();
    List<Book> getAll();
    void delete();
}
