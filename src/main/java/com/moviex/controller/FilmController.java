package com.moviex.controller;

import com.moviex.dto.model.*;
import com.moviex.dto.response.FilmCategoryResponseDto;
import com.moviex.dto.response.FilmHomeResponseDto;
import com.moviex.dto.response.FilmResponseDto;
import com.moviex.dto.response.ServerResponseDto;
import com.moviex.model.Film;
import com.moviex.model.FilmEpisodeServer;
import com.moviex.service.FilmEpisodeService;
import com.moviex.service.FilmService;
import com.moviex.service.ServerService;
import com.moviex.service.repository.FilmEpisodeServerRepository;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping(value = "/film")
@Api(value = "/film", description = "API phim")
public class FilmController {

    @Autowired
    private FilmService filmService;

    @Autowired
    private FilmEpisodeService filmEpisodeService;

    @Autowired
    private ServerService serverService;

    @Autowired
    private FilmEpisodeServerRepository filmEpisodeServerRepository;

    @GetMapping("/list")
    @ApiOperation(
            value = "Danh sach phim moi nhat"
    )
    public FilmResponseDto list(
            @RequestParam(name = "page", defaultValue = "0", required = false) Long page,
            @RequestParam(name = "limit", defaultValue = "10", required = false) Long limit) {
        List<FilmDto> listData = new ArrayList<>();
        FilmResponseDto responseDto = new FilmResponseDto();

        filmService.findAllWithPagination(page, limit).forEach(v -> toModel(v, listData));

        responseDto.setData(listData);

        return responseDto;
    }

    @GetMapping("/home")
    @ApiOperation(
            value = "Danh sach phim de cu, phim chieu rap, phim le, phim bo, phim hoat hinh"
    )
    public FilmHomeResponseDto home() {
        List<FilmHomeDto> listData = new ArrayList<>();
        FilmHomeResponseDto responseDto = new FilmHomeResponseDto();

        filmHomeCategory(16L, "Phim đề cử", listData);
        filmHomeCategory(1L, "Phim chiếu rạp", listData);
        filmHomeCategory(2L, "Phim lẻ mới", listData);
        filmHomeCategory(3L, "Phim bộ mới", listData);
        filmHomeCategory(11L, "Phim hoạt hình mới", listData);

        responseDto.setData(listData);

        return responseDto;
    }

    @GetMapping("/listIMDB")
    @ApiOperation(
            value = "Danh sach phim theo IMDB"
    )
    public FilmCategoryResponseDto listIMDB(
            @RequestParam(name = "page", defaultValue = "0", required = false) Long page,
            @RequestParam(name = "limit", defaultValue = "10", required = false) Long limit) {
        List<FilmCategoryDto> listData = new ArrayList<>();
        FilmCategoryResponseDto responseDto = new FilmCategoryResponseDto();

        filmService.findAllIMDBWithPagination(page, limit).forEach(v -> toModelCategory(v, listData));

        responseDto.setData(listData);

        return responseDto;
    }

    @GetMapping("/listByCategory")
    @ApiOperation(
            value = "Danh sach phim theo the loai"
    )
    public FilmCategoryResponseDto listByCategory(
            @RequestParam(name = "categoryId", defaultValue = "0", required = false) Long categoryId,
            @RequestParam(name = "page", defaultValue = "0", required = false) Long page,
            @RequestParam(name = "limit", defaultValue = "10", required = false) Long limit) {
        List<FilmCategoryDto> listData = new ArrayList<>();
        FilmCategoryResponseDto responseDto = new FilmCategoryResponseDto();

        filmService.findByCategoryWithPagination(categoryId, page, limit).forEach(v -> toModelCategory(v, listData));

        responseDto.setData(listData);

        return responseDto;
    }

    @GetMapping("/detail")
    @ApiOperation(
            value = "Chi tiet phim"
    )
    public FilmResponseDto detail(
            @RequestParam(name = "filmId", defaultValue = "0", required = false) Long filmId) {
        List<FilmDto> listData = new ArrayList<>();
        FilmResponseDto responseDto = new FilmResponseDto();

        Film film  = filmService.findFilmByFilmId(filmId);

        if (film != null) {
            toModel(film, listData);
        }

        responseDto.setData(listData);

        return responseDto;
    }

    @GetMapping("/search")
    @ApiOperation(
            value = "Tim kiem phim"
    )
    public FilmCategoryResponseDto search(
            @RequestParam(name = "query", defaultValue = "", required = false) String query,
            @RequestParam(name = "page", defaultValue = "0", required = false) Long page,
            @RequestParam(name = "limit", defaultValue = "10", required = false) Long limit) {
        List<FilmCategoryDto> listData = new ArrayList<>();
        FilmCategoryResponseDto responseDto = new FilmCategoryResponseDto();

        filmService.searchKeywordWithPagination(query, page, limit).forEach(v -> toModelCategory(v, listData));

        responseDto.setData(listData);

        return responseDto;
    }

    @GetMapping("/episode")
    @ApiOperation(
            value = "Danh sach tap cua phim"
    )
    public ServerResponseDto episode(
            @RequestParam(name = "filmId", defaultValue = "0", required = false) Long filmId) {
        List<ServerDto> listData = new ArrayList<>();
        ServerResponseDto responseDto = new ServerResponseDto();

        serverService.findAll().forEach(d -> {
            final ServerDto serverDto = new ServerDto();
            serverDto.setId(d.getServerId().toString());
            serverDto.setServerName(d.getServerName().toString());
            List<FilmEpisodeServerDto> listData2 = new ArrayList<>();
            filmEpisodeService.findByFilmId(filmId).forEach(v -> {
                FilmEpisodeServer filmEpisodeServer = filmEpisodeServerRepository.findByFilmEpisodeIdAndAndServerId(v.getFilmEpisodeId(), d.getServerId());

                if (filmEpisodeServer == null) {
                    return;
                }

                final FilmEpisodeServerDto filmEpisodeServerDto = new FilmEpisodeServerDto();
                filmEpisodeServerDto.setId(filmEpisodeServer.getFilmEpisodeServerId().toString());
                filmEpisodeServerDto.setServerId(filmEpisodeServer.getServerId().toString());
                filmEpisodeServerDto.setEpisodePart(filmEpisodeServer.getEpisodePart().toString());
                filmEpisodeServerDto.setFilmEpisodeId(filmEpisodeServer.getFilmEpisodeId().toString());
                filmEpisodeServerDto.setFilmEpisodeServerHD(filmEpisodeServer.getFilmEpisodeServerHD());
                filmEpisodeServerDto.setFilmEpisodeServerSD(filmEpisodeServer.getFilmEpisodeServerSD());

                final FilmEpisodeDto filmDto = new FilmEpisodeDto();
                filmDto.setId(v.getFilmEpisodeId().toString());
                filmDto.setFilmId(v.getFilmId().toString());
                filmDto.setFilmEpisodeName(v.getFilmEpisodeName());
                filmDto.setFilmEpisodeOrder(v.getFilmEpisodeOrder().toString());
                filmDto.setFilmEpisodeView(v.getFilmEpisodeView().toString());

                filmEpisodeServerDto.setFilmEpisodeInfo(filmDto);

                listData2.add(filmEpisodeServerDto);
            });

            serverDto.setData(listData2);

            listData.add(serverDto);
        });

        responseDto.setData(listData);

        return responseDto;
    }

    private void toModel(Film film, List<FilmDto> listData) {
        final FilmDto filmDto = new FilmDto();
        filmDto.setId(film.getFilmId().toString());
        filmDto.setFilmNameVN(film.getFilmNameVN());
        filmDto.setFilmNameEN(film.getFilmNameEN());
        filmDto.setFilmDescription(film.getFilmDescription());
        filmDto.setFilmImageMedium(film.getFilmImageMedium());
        filmDto.setFilmImageThumb(film.getFilmImageThumb());
        filmDto.setFilmIMDB(film.getFilmIMDB().toString());
        filmDto.setFilmView(film.getFilmView().toString());
        filmDto.setFilmResolution(film.getFilmResolution());
        filmDto.setFilmContent(film.getFilmContent());
        filmDto.setFilmCountry(film.getFilmCountry());
        filmDto.setFilmTime(film.getFilmTime().toString());
        filmDto.setFilmTrailer(film.getFilmTrailer());
        filmDto.setFilmYear(film.getFilmYear().toString());
        listData.add(filmDto);
    }

    private void toModelCategory(Film film, List<FilmCategoryDto> listData) {
        final FilmCategoryDto filmDto = new FilmCategoryDto();
        filmDto.setId(film.getFilmId().toString());
        filmDto.setFilmNameVN(film.getFilmNameVN());
        filmDto.setFilmNameEN(film.getFilmNameEN());
        filmDto.setFilmDescription(film.getFilmDescription());
        filmDto.setFilmImageMedium(film.getFilmImageMedium());
        filmDto.setFilmImageThumb(film.getFilmImageThumb());
        filmDto.setFilmIMDB(film.getFilmIMDB().toString());
        filmDto.setFilmView(film.getFilmView().toString());
        listData.add(filmDto);
    }

    private void filmHomeCategory(Long categoryId, String name, List<FilmHomeDto> listData) {
        final FilmHomeDto filmHomeDto = new FilmHomeDto();
        filmHomeDto.setId(categoryId.toString());
        filmHomeDto.setName(name);
        List<FilmCategoryDto> dtoList = new ArrayList<>();
        filmService.findByCategoryWithPagination(categoryId, 0L, 20L).forEach(v -> toModelCategory(v, dtoList));

        filmHomeDto.setMovies(dtoList);

        listData.add(filmHomeDto);
    }

}
