package com.BikeLab.service;

import com.BikeLab.entity.Canton;
import java.util.List;
import org.springframework.stereotype.Service;

@Service
public interface ICantonService {

    public List<Canton> getAllCanton();

    public Canton getCantonById(long id);

    public void saveCanton(Canton canton);

    public void deleteCanton(long id);

}
