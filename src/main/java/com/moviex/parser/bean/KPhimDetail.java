package com.moviex.parser.bean;

import java.util.List;
import java.util.Map;

public class KPhimDetail {
    private List<Map<String, String>> listDirector;
    private List<Map<String, String>> listActor;
    private List<Map<String, String>> listEpisode;
    private List<Map<String, String>> listCountry;

    public List<Map<String, String>> getListDirector() {
        return listDirector;
    }

    public void setListDirector(List<Map<String, String>> listDirector) {
        this.listDirector = listDirector;
    }

    public List<Map<String, String>> getListActor() {
        return listActor;
    }

    public void setListActor(List<Map<String, String>> listActor) {
        this.listActor = listActor;
    }

    public List<Map<String, String>> getListEpisode() {
        return listEpisode;
    }

    public void setListEpisode(List<Map<String, String>> listEpisode) {
        this.listEpisode = listEpisode;
    }

    public List<Map<String, String>> getListCountry() {
        return listCountry;
    }

    public void setListCountry(List<Map<String, String>> listCountry) {
        this.listCountry = listCountry;
    }
}
