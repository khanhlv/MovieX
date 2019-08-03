package com.moviex.service;

import com.moviex.model.*;
import com.moviex.parser.bean.KPhimDetail;
import com.moviex.service.repository.*;
import org.apache.commons.lang3.StringUtils;
import org.apache.commons.lang3.math.NumberUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.Map;

@Service
public class CrawlerService {

    @Autowired
    private FilmRepository filmRepository;

    @Autowired
    private FilmEpisodeRepository filmEpisodeRepository;

    @Autowired
    private FilmEpisodeServerRepository filmEpisodeServerRepository;

    @Autowired
    private ActorRepository actorRepository;

    @Autowired
    private CategoryRepository categoryRepository;

    @Autowired
    private DirectorRepository directorRepository;

    @Autowired
    private FilmCategoryRepository filmCategoryRepository;

    @Autowired
    private FilmDirectorRepository filmDirectorRepository;

    @Autowired
    private FilmActorRepository filmActorRepository;

    public void addFilm(KPhimDetail kPhimDetail, Long categoryId){
        Film film = new Film();
        film.setFilmNameVN(kPhimDetail.getFilmNameVN());
        film.setFilmNameEN(kPhimDetail.getFilmNameEN());
        film.setFilmImageThumb(kPhimDetail.getFilmImageThumb());
        film.setFilmImageMedium(kPhimDetail.getFilmImageMedium());
        film.setFilmDescription(StringUtils.substring(kPhimDetail.getFilmDescription(), 0, 2000));
        film.setFilmSource(kPhimDetail.getSourceLink());
        film.setFilmView(1L);
        film.setFilmCountry(StringUtils.join(kPhimDetail.getMapCountry().values(), ";"));
        film.setFilmEpisode(NumberUtils.toLong(kPhimDetail.getFilmEpisode(), 0));
        film.setFilmIMDB(1L);
        film.setFilmTime(NumberUtils.toLong(kPhimDetail.getFilmTime(), 0));
        film.setFilmYear(2019L);
        film.setFilmStatus(1L);
        film.setStatus(1L);
        film.setCreatedDate(new Date());
        film.setCreatedUserId(1L);

        filmRepository.save(film);

        FilmCategory filmCategory = new FilmCategory();
        filmCategory.setFilmId(film.getFilmId());
        filmCategory.setCategoryId(categoryId);

        filmCategoryRepository.save(filmCategory);

        // Episode
        int filmEpisodeOrder = 0;
        if (kPhimDetail.getMapEpisode().size() > 0) {
            for (Map.Entry<String, String> entry : kPhimDetail.getMapEpisode().entrySet()) {
                FilmEpisode filmEpisode = new FilmEpisode();
                filmEpisode.setFilmId(film.getFilmId());
                filmEpisode.setFilmEpisodeName(entry.getKey());
                filmEpisode.setFilmEpisodeOrder(Long.valueOf(filmEpisodeOrder++));
                filmEpisode.setFilmEpisodeView(1L);
                filmEpisode.setStatus(1L);

                filmEpisodeRepository.save(filmEpisode);

                FilmEpisodeServer filmEpisodeServer = new FilmEpisodeServer();
                filmEpisodeServer.setFilmEpisodeId(filmEpisode.getFilmEpisodeId());
                filmEpisodeServer.setEpisodePart(1L);
                filmEpisodeServer.setServerId(1L);
                filmEpisodeServer.setStatus(1L);
                filmEpisodeServer.setFilmEpisodeServerHD(entry.getValue());

                filmEpisodeServerRepository.save(filmEpisodeServer);
            }
        }

        // Actor
        kPhimDetail.getMapActor().forEach((k, v) -> {
            Actor actor = new Actor();
            actor.setActorName(k);
            actor.setActorDescription(k);
            actor.setActorView(1L);
            actor.setStatus(1L);
            actor.setActorSource(v);
            actor.setCreatedDate(new Date());
            actor.setCreatedUserId(1L);

            actorRepository.save(actor);

            FilmActor filmActor = new FilmActor();
            filmActor.setCharacterName(k);
            filmActor.setActorId(actor.getActorId());
            filmActor.setFilmId(film.getFilmId());

            filmActorRepository.save(filmActor);
        });

        // Director
        kPhimDetail.getMapDirector().forEach((k, v) -> {
            Director director = new Director();
            director.setDirectorImage(k);
            director.setDirectorDescription(k);
            director.setDirectorView(1L);
            director.setStatus(1L);
            director.setDirectorSource(v);
            director.setCreatedDate(new Date());
            director.setCreatedUserId(1L);

            directorRepository.save(director);

            FilmDirector filmDirector = new FilmDirector();
            filmDirector.setDirectorId(director.getDirectorId());
            filmDirector.setFilmId(film.getFilmId());

            filmDirectorRepository.save(filmDirector);
        });
    }
}
