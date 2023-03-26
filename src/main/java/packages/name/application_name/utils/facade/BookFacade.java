package packages.name.application_name.utils.facade;

import packages.name.application_name.dao.dto.response.BookGetResponseDto;
import packages.name.application_name.dao.entity.Book;

public interface BookFacade {
    BookGetResponseDto toDto(Book book);
}
