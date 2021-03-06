package com.moviex.parser;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.moviex.common.Const;
import com.moviex.common.UserAgent;
import com.moviex.parser.bean.KPhimDetail;
import com.moviex.parser.bean.KPhimList;
import com.moviex.parser.bean.KPhimSource;
import org.apache.commons.lang3.StringUtils;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import org.springframework.stereotype.Component;
import org.springframework.util.DigestUtils;

import java.util.*;
import java.util.stream.Collectors;

@Component
public class KPhim {
    public List<KPhimSource> start(String url) throws Exception {
        Document document = Jsoup.connect(url)
                .userAgent(UserAgent.getUserAgent())
                .timeout(Const.TIMEOUT).get();

        Elements els = document.select(".kphim-servers .server-name");

        Element eltBtn = els.get(0).select(".btn-dark").get(0);

//        System.out.println(eltBtn.attr("vid"));
//        System.out.println(eltBtn.attr("sid"));
        String vid = eltBtn.attr("vid");
        String sid = eltBtn.attr("sid");

        List<Element> li = document.select("script").stream().filter(v -> v.toString().contains("_linkHref")).collect(Collectors.toList());
        String mid = li.get(0).toString().replaceAll("\\s+", "");
        mid = mid.substring(mid.indexOf("ver='") + 5,mid.indexOf("';varfirstServerID"));

//        System.out.println(mid);

        //kphi + vid + ver + bo_diz_ca_nha_may_thang_get + sid
        Map<String, String> data = new HashMap<>();
        data.put("vid", vid);
        data.put("sid", sid);
        data.put("mid", mid);

        String md5 = DigestUtils.md5DigestAsHex(String.format("kphi%s%sbo_diz_ca_nha_may_thang_get%s",vid,mid,sid).getBytes());
        md5 = md5.substring(2);
        String urlPlay = "http://www.kphim.tv/player/"+ vid + mid +"/" + sid + mid + "/" + md5;
        Document documentFilm = Jsoup.connect(urlPlay).data(data).post();

        String film = documentFilm.toString().replaceAll("\\s+", "");
        String keyIndexOf = "jwplayer('hkplayer" + sid + "').setup({sources:";
//        System.out.println(film);
        film = film.substring(film.indexOf(keyIndexOf) + keyIndexOf.length(), film.indexOf("tracks:[]") - 1).replaceAll("\\s+", "");

        List<KPhimSource> listKPhim = new Gson().fromJson(film, new TypeToken<List<KPhimSource>>(){}.getType());
//        System.out.println(listKPhim.size());
//        listKPhim.forEach(v -> {
//            System.out.println(v.getFile());
//            System.out.println(v.getLabel());
//            System.out.println(v.getType());
//            System.out.println("------------------------------");
//        });

        return listKPhim;
    }

    public List<KPhimList> readList(String url) throws Exception {
        List<KPhimList> phimLists = new ArrayList<>();
        Document document = Jsoup.connect(url)
                .userAgent(UserAgent.getUserAgent())
                .timeout(Const.TIMEOUT).get();

        Elements elements = document.select("#ketquatimkiem .search-movie-item .inner");
        elements.stream().forEach(v -> {
            KPhimList kPhimList = new KPhimList();
            kPhimList.setTitle(StringUtils.trim(v.select(".text-nowrap").text()));
            kPhimList.setLink(StringUtils.trim(v.attr("href")));
            kPhimList.setImage(v.select("img").attr("src"));
            phimLists.add(kPhimList);

            System.out.println(kPhimList.getTitle());
            System.out.println(kPhimList.getLink());
            System.out.println(kPhimList.getImage());
        });

        System.out.println(elements.size());

        return phimLists;
    }

    public KPhimDetail readDetail(String url) throws Exception {
        KPhimDetail kPhimDetail = new KPhimDetail();
        kPhimDetail.setSourceLink(url);

        Document document = Jsoup.connect(url)
                .userAgent(UserAgent.getUserAgent())
                .timeout(Const.TIMEOUT).get();

        Elements elements = document.select(".movie-info-sidebar .common-list");
        Elements elementsActor = document.select(".actor-info a");
        Elements elementsEpisodes = document.select(".episodes a");
        Elements elementsDescription = document.select(".gioi-thieu-phim");
        Elements elementsName = document.select(".movie-info-top");

        Map<String, String> mapActor = new LinkedHashMap<>();
        Map<String, String> mapCountry = new LinkedHashMap<>();
        Map<String, String> mapDirector = new LinkedHashMap<>();
        Map<String, String> mapEpisode = new LinkedHashMap<>();

        elementsActor.stream().forEach(v -> {
            mapActor.put(StringUtils.trim(v.text()), v.attr("href"));
//
//            System.out.println(v.attr("href"));
//            System.out.println(StringUtils.trim(v.text()));
        });

        elements.stream().forEach(v -> {
            if (StringUtils.equals(v.select("span").text(), "Đạo Diễn:")) {
                mapDirector.put(StringUtils.trim(v.select("a").text()), v.select("a").attr("href"));

//                System.out.println(v.select("a").attr("href"));
//                System.out.println(StringUtils.trim(v.select("a").text()));
            }

            if (StringUtils.equals(v.select("span").text(), "Tổng số tập:")) {
                kPhimDetail.setFilmEpisode(StringUtils.trim(v.select("a").text()));
            }

            if (StringUtils.equals(v.select("span").text(), "Quốc Gia:")) {
                String country = StringUtils.trim(v.select("a").text());
                mapCountry.put(country, country);

//                System.out.println(v.select("a").attr("href"));
//                System.out.println(StringUtils.trim(v.select("a").text()));
            }
        });

        elementsEpisodes.stream().forEach(v -> {
            mapEpisode.put(StringUtils.trim(v.text()), v.attr("href"));

//            System.out.println(v.attr("href"));
//            System.out.println(StringUtils.trim(v.text()));
        });

        kPhimDetail.setMapActor(mapActor);
        kPhimDetail.setMapDirector(mapDirector);
        kPhimDetail.setMapEpisode(mapEpisode);
        kPhimDetail.setMapCountry(mapCountry);
        kPhimDetail.setFilmDescription(StringUtils.trim(elementsDescription.text()));
        kPhimDetail.setFilmNameVN(StringUtils.trim(elementsName.select(".movie-title").text()));
        kPhimDetail.setFilmNameEN(StringUtils.trim(elementsName.select(".movie-meta").text()));
        kPhimDetail.setFilmImageThumb(StringUtils.trim(document.select("meta[property=og:image]").attr("content")));
        kPhimDetail.setFilmImageMedium(kPhimDetail.getFilmImageThumb());

        return kPhimDetail;
    }

    public static void main(String[] args) throws Exception {
//        new KPhim().start("http://www.kphim.tv/xem-phim/lop-hoc-gia-doi-ep-1-vietsub.html");

//        new KPhim().readList("http://www.kphim.tv/theloai/phim-truyen-hinh-han-quoc-z1.html"); // Category=14
//        new KPhim().readList("http://www.kphim.tv/theloai/truyen-hinh-thuc-te-z2.html"); // Category=10
//        new KPhim().readList("http://www.kphim.tv/theloai/phim-truyen-hinh-trung-quoc-z3.html"); // Category=13

//        KPhimDetail kPhimDetail = new KPhim().readDetail("http://www.kphim.tv/phim-pinocchio-vietsub.html");
//
//        kPhimDetail.getMapActor().forEach((v, k) -> {
//            System.out.println(v);
//        });
//
//        kPhimDetail.getMapCountry().forEach((v, k) -> {
//            System.out.println(v);
//        });
//
//        kPhimDetail.getMapDirector().forEach((v, k) -> {
//            System.out.println(v);
//        });
//
//        kPhimDetail.getMapEpisode().forEach((v, k) -> {
//            System.out.println(k);
//        });


    }
}
