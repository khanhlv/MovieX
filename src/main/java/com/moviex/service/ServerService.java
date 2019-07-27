package com.moviex.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.moviex.model.Server;
import com.moviex.service.repository.ServerRepository;

@Service
public class ServerService {

    @Autowired
    private ServerRepository serverRepository;

    public List<Server> findAll(){

        List<Server> serverList = new ArrayList<>();
        serverRepository.findByStatusOOrderByServerIdAsc(1L).forEach(serverList::add);

        return serverList;
    }
}
