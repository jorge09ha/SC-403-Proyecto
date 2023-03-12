package com.BikeLab.service;

import com.BikeLab.entity.DatosLogin;
import java.util.List;
import org.springframework.stereotype.Service;

@Service
public interface IDatosLoginService {

    public List<DatosLogin> getAllDatosLogin();

    public DatosLogin getDatosLoginById(long id);

    public void saveDatosLogin(DatosLogin datosLogin);

    public void deleteDatosLogin(long id);

}
