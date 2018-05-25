package io.ceolin.ms.repository;

import org.springframework.data.mongodb.repository.ReactiveMongoRepository;

import io.ceolin.ms.domain.Movie;

public interface MovieRepository extends ReactiveMongoRepository<Movie, String>{

}
