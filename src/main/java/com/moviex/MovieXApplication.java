package com.moviex;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class MovieXApplication {

	public static void main(String[] args) {
		SpringApplication.run(MovieXApplication.class, args);
	}

//	@Bean
//	CommandLineRunner init (FilmRepository filmRepository){
//		return args -> {
//			filmRepository.findAll().forEach(film -> {
//				film.setMetaUrl(StringUtil.stripAccents(film.getFilmNameVN(), "-"));
//				film.setMetaTitle(String.format("%s (%s)", film.getFilmNameVN(), film.getFilmNameEN()));
//				film.setMetaDescription(String.format("%s (%s)", film.getFilmNameVN(), film.getFilmNameEN()));
//				film.setMetaKeyword(StringUtil.stripAccents(film.getFilmNameVN()));
//
//				filmRepository.save(film);
//			});
//		};
//	}

}
