package com.BikeLab.service;

import com.BikeLab.entity.Carrito;
import com.BikeLab.entity.Evento;
import java.util.List;
import org.springframework.stereotype.Service;

@Service
public interface IEventoService {

    public List<Evento> getAllEvento();

    public Evento getEventoById(long id);

    public void saveEvento(Evento evento);

    public void deleteEvento(long id);

}
