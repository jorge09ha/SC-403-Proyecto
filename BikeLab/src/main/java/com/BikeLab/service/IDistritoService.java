package com.BikeLab.service;

import com.BikeLab.entity.Distrito;
import java.util.List;
import org.springframework.stereotype.Service;

@Service
public interface IDistritoService {

    public List<Distrito> getAllDistrito();

    public Distrito getDistritoById(long id);

    public void saveDistrito(Distrito distrito);

    public void deleteDistrito(long id);

}
