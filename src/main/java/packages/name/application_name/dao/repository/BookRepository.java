package packages.name.application_name.dao.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import packages.name.application_name.dao.entity.Book;

import java.util.UUID;

public interface BookRepository extends JpaRepository<Book, UUID> {
}