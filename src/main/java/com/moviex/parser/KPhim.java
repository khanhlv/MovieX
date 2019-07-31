package com.moviex.parser;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.moviex.common.Const;
import com.moviex.common.UserAgent;
import com.moviex.parser.bean.KPhimList;
import com.moviex.parser.bean.KPhimSource;
import org.apache.commons.lang3.StringUtils;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import org.springframework.stereotype.Component;

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

        Map<String, String> data = new HashMap<>();
        data.put("vid", vid);
        data.put("sid", sid);
        data.put("mid", mid);
        Document documentFilm = Jsoup.connect("http://www.kphim.tv/player/"+ vid + mid +"/" + sid + mid + "/" + new Date().getTime()).data(data).post();

        String film = documentFilm.toString().replaceAll("\\s+", "");
        String keyIndexOf = "jwplayer('hkplayer" + sid + "').setup({sources:";
//        System.out.println(film);
        film = film.substring(film.indexOf(keyIndexOf) + keyIndexOf.length(), film.indexOf("tracks:[]") - 1).replaceAll("\\s+", "");

        List<KPhimSource> listKPhim = new Gson().fromJson(film, new TypeToken<List<KPhimSource>>(){}.getType());
//        System.out.println(listKPhim.size());
        listKPhim.forEach(v -> {
            System.out.println(v.getFile());
            System.out.println(v.getLabel());
            System.out.println(v.getType());
            System.out.println("------------------------------");
        });

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

        return phimLists;
    }

    public void readDetail(String url) throws Exception {
        Document document = Jsoup.connect(url)
                .userAgent(UserAgent.getUserAgent())
                .timeout(Const.TIMEOUT).get();

        Elements elements = document.select(".movie-info-sidebar .common-list");
        Elements elementsActor = document.select(".actor-info a");
        Elements elementsEpisodes = document.select(".episodes a");

        elementsActor.stream().forEach(v -> {
            System.out.println(v.attr("href"));
            System.out.println(StringUtils.trim(v.text()));
        });

        elements.stream().forEach(v -> {
            if (StringUtils.equals(v.select("span").text(), "Đạo Diễn:")) {
                System.out.println(v.select("a").attr("href"));
                System.out.println(StringUtils.trim(v.select("a").text()));
            }

            if (StringUtils.equals(v.select("span").text(), "Quốc Gia:")) {
                System.out.println(v.select("a").attr("href"));
                System.out.println(StringUtils.trim(v.select("a").text()));
            }
        });

        elementsEpisodes.stream().forEach(v -> {
            System.out.println(v.attr("href"));
            System.out.println(StringUtils.trim(v.text()));
        });
    }

    public static void main(String[] args) throws Exception {
//        new KPhim().readList("http://www.kphim.tv/theloai/phim-truyen-hinh-han-quoc-z1.html");
        new KPhim().readDetail("http://www.kphim.tv/phim-nguoi-giam-sat-vietsub.html");
    }
}
