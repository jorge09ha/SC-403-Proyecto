package com.BikeLab.service;

import com.BikeLab.entity.Canton;
import com.BikeLab.repository.CantonRepository;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CantonService implements ICantonService {

    @Autowired
    private CantonRepository cantonRepository;

    @Override
    public List<Canton> getAllCanton() {
        return (List<Canton>) cantonRepository.findAll();
    }

    @Override
    public Canton getCantonById(long id) {
        return cantonRepository.findById(id).orElse(null);
    }

    @Override
    public void saveCanton(Canton canton) {
        cantonRepository.save(canton);
    }

    @Override
    public void deleteCanton(long id) {
        cantonRepository.deleteById(id);
    }

}
