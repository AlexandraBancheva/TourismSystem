package com.tourismSystem.ts.common;

import com.tourismSystem.ts.entities.Transport;
import com.tourismSystem.ts.repositories.TransportRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;

public class TransportDataLoader implements CommandLineRunner {
    @Autowired
    private TransportRepository transportRepository;

    @Override
    public void run(String... args) throws Exception {
        loadTransportData();
    }

    private void loadTransportData(){
        if (transportRepository.count() == 0){
            Transport indiviualTransport = new Transport("Индивидуален");
            Transport airTransport = new Transport("Самолетен");
            Transport busTransport = new Transport("Автобусен");
            transportRepository.save(indiviualTransport);
            transportRepository.save(airTransport);
            transportRepository.save(busTransport);
        }
    }
}
