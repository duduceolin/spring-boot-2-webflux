package io.ceolin.ms.bootstrap;

import java.util.UUID;

import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import io.ceolin.ms.domain.Movie;
import io.ceolin.ms.repository.MovieRepository;
import reactor.core.publisher.Flux;

@Component
public class BootstrapCLR implements CommandLineRunner{

	private final MovieRepository movieRepository;
	
	public BootstrapCLR(MovieRepository movieRepository) {
		this.movieRepository = movieRepository;
	}
	
	@Override
	public void run(String... args) throws Exception {
		//clear old data
		movieRepository.deleteAll().thenMany(
				Flux.just("Filme 01", "Filme 02")
				.map(str -> new Movie(UUID.randomUUID().toString(), str, "dudu"))
				.flatMap(movieRepository::save))
				.subscribe(null, null, () -> {
					
					movieRepository.findAll().subscribe(System.out::println);
				});
		
		
	}

}
