package com.tourismSystem.ts.services;

import com.tourismSystem.ts.entities.Transport;
import com.tourismSystem.ts.repositories.TransportRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TransportServiceImpl implements TransportService{
    @Autowired
    private TransportRepository transportRepository;

    @Override
    public List<Transport> getAllTransports() {
        return transportRepository.findAll();
    }
}
