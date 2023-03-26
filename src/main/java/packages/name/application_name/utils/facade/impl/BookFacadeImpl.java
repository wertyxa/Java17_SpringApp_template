package packages.name.application_name.utils.facade.impl;

import org.springframework.stereotype.Component;
import packages.name.application_name.dao.dto.response.BookGetResponseDto;
import packages.name.application_name.dao.entity.Book;
import packages.name.application_name.utils.facade.BookFacade;

@Component
public class BookFacadeImpl implements BookFacade {
    @Override
    public BookGetResponseDto toDto(Book book) {
        //you code
        return null;
    }
}
