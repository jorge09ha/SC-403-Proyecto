package com.BikeLab.service;

import com.BikeLab.entity.Evento;
import com.BikeLab.repository.EventoRepository;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class EventoService implements IEventoService {

    @Autowired
    private EventoRepository eventoRepository;

    @Override
    public List<Evento> getAllEvento() {
        return (List<Evento>) eventoRepository.findAll();
    }

    @Override
    public Evento getEventoById(long id) {
        return eventoRepository.findById(id).orElse(null);
    }

    @Override
    public void saveEvento(Evento evento) {
        eventoRepository.save(evento);
    }

    @Override
    public void deleteEvento(long id) {
        eventoRepository.deleteById(id);
    }

}
