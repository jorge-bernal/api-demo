package me.jorgebernal.api_demo.daos;

import me.jorgebernal.api_demo.documents.Book;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface BookDao extends MongoRepository<Book, String> {
}
