package com.moviex.controller;

import com.moviex.annotation.AllowAnonymous;
import com.moviex.dto.common.ResponseDto;
import com.moviex.dto.request.CrawlerRequestDto;
import com.moviex.model.Film;
import com.moviex.parser.KPhim;
import com.moviex.parser.bean.KPhimDetail;
import com.moviex.parser.bean.KPhimList;
import com.moviex.service.CrawlerService;
import com.moviex.service.FilmService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.apache.commons.lang3.math.NumberUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/crawler")
@Api(value = "/crawler", description = "API lay du lieu")
public class CrawlerController {

    private static final Logger LOGGER = LoggerFactory.getLogger(CrawlerController.class);

    @Autowired
    private CrawlerService crawlerService;

    @Autowired
    private FilmService filmService;

    @Autowired
    private KPhim kPhim;

    @GetMapping("/index")
    @AllowAnonymous
    public ResponseDto home() {
        return new ResponseDto();
    }

    @PostMapping("/kphim/list")
    @ApiOperation(
            value = "Lay phim theo the loai cua trang KPhim.TV"
    )
    public ResponseDto kPhimList(@RequestBody CrawlerRequestDto requestDto) {
        try {
            List<KPhimList> kPhimList = kPhim.readList(requestDto.getLink());

            if (kPhimList.size() > 0) {
                kPhimList.forEach(v -> {
                    try {
                        LOGGER.info("#GET_LINK: " + v.getLink());
                        Film film = filmService.findByFilmSource(v.getLink());
                        if (film == null) {
                            KPhimDetail kPhimDetail = kPhim.readDetail(v.getLink());

                            crawlerService.addFilm(kPhimDetail, NumberUtils.toLong(requestDto.getCategory()));

                            LOGGER.info("#INSERT_LINK: " + v.getLink());
                        } else {
                            LOGGER.info("#EXISTS_LINK: " + v.getLink());
                        }
                    } catch (Exception ex) {
                        LOGGER.error("ERROR_LINK: " + v.getLink(), ex);
                    }
                });
            }
            return new ResponseDto();
        } catch (Exception ex) {
            LOGGER.error("kPhim", ex);
            return new ResponseDto().withStatus(-1).withError(ex.getMessage());
        }
    }

    @PostMapping("/kphim/detail")
    @ApiOperation(
            value = "Lay thong tin chi tiet cua phim trang KPhim.TV"
    )
    public KPhimDetail kPhimDetail(@RequestBody CrawlerRequestDto requestDto) {
        try {
            KPhimDetail kPhimDetail = kPhim.readDetail(requestDto.getLink());

            return kPhimDetail;
        } catch (Exception ex) {
            LOGGER.error("kPhim", ex);
            return null;
        }
    }
}
