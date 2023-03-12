package com.BikeLab.service;

import com.BikeLab.entity.RoleDatosLogin;
import com.BikeLab.repository.RoleDatosLoginRepository;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class RoleDatosLoginService implements IRoleDatosLoginService {

    @Autowired
    private RoleDatosLoginRepository roleDatosLoginRepository;

    @Override
    public List<RoleDatosLogin> getAllRoleDatosLogin() {
        return (List<RoleDatosLogin>) roleDatosLoginRepository.findAll();
    }

    @Override
    public RoleDatosLogin getRoleDatosLoginById(long id) {
        return roleDatosLoginRepository.findById(id).orElse(null);
    }

    @Override
    public void saveRoleDatosLogin(RoleDatosLogin roleDatosLogin) {
        roleDatosLoginRepository.save(roleDatosLogin);
    }

    @Override
    public void deleteRoleDatosLogin(long id) {
        roleDatosLoginRepository.deleteById(id);
    }

}
