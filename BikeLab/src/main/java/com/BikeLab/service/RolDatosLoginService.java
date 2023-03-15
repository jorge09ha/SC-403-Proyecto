package com.BikeLab.service;

import com.BikeLab.entity.RolDatosLogin;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.BikeLab.repository.RolDatosLoginRepository;

@Service
public class RolDatosLoginService implements IRolDatosLoginService {

    @Autowired
    private RolDatosLoginRepository roleDatosLoginRepository;

    @Override
    public List<RolDatosLogin> getAllRoleDatosLogin() {
        return (List<RolDatosLogin>) roleDatosLoginRepository.findAll();
    }

    @Override
    public RolDatosLogin getRoleDatosLoginById(long id) {
        return roleDatosLoginRepository.findById(id).orElse(null);
    }

    @Override
    public void saveRoleDatosLogin(RolDatosLogin roleDatosLogin) {
        roleDatosLoginRepository.save(roleDatosLogin);
    }

    @Override
    public void deleteRoleDatosLogin(long id) {
        roleDatosLoginRepository.deleteById(id);
    }

}
