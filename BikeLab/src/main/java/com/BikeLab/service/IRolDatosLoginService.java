package com.BikeLab.service;

import com.BikeLab.entity.RolDatosLogin;
import java.util.List;
import org.springframework.stereotype.Service;

@Service
public interface IRolDatosLoginService {

    public List<RolDatosLogin> getAllRoleDatosLogin();

    public RolDatosLogin getRoleDatosLoginById(long id);

    public void saveRoleDatosLogin(RolDatosLogin roleDatosLogin);

    public void deleteRoleDatosLogin(long id);

}
