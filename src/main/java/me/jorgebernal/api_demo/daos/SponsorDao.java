package me.jorgebernal.api_demo.daos;

import me.jorgebernal.api_demo.documents.Sponsor;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface SponsorDao extends MongoRepository<Sponsor, String> {
}
