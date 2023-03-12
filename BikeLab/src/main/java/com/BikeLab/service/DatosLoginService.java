package com.BikeLab.service;

import com.BikeLab.entity.DatosLogin;
import com.BikeLab.repository.DatosLoginRepository;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class DatosLoginService implements IDatosLoginService {

    @Autowired
    private DatosLoginRepository datosLoginRepository;

    @Override
    public List<DatosLogin> getAllDatosLogin() {
        return (List<DatosLogin>) datosLoginRepository.findAll();
    }

    @Override
    public DatosLogin getDatosLoginById(long id) {
        return datosLoginRepository.findById(id).orElse(null);
    }

    @Override
    public void saveDatosLogin(DatosLogin datosLogin) {
        datosLoginRepository.save(datosLogin);
    }

    @Override
    public void deleteDatosLogin(long id) {
        datosLoginRepository.deleteById(id);
    }

}
