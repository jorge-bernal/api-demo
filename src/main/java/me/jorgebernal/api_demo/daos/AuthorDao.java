package me.jorgebernal.api_demo.daos;

import me.jorgebernal.api_demo.documents.Author;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface AuthorDao extends MongoRepository<Author, String> {
}
