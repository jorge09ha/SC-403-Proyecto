package com.BikeLab.service;

import com.BikeLab.entity.RoleDatosLogin;
import java.util.List;
import org.springframework.stereotype.Service;

@Service
public interface IRoleDatosLoginService {

    public List<RoleDatosLogin> getAllRoleDatosLogin();

    public RoleDatosLogin getRoleDatosLoginById(long id);

    public void saveRoleDatosLogin(RoleDatosLogin roleDatosLogin);

    public void deleteRoleDatosLogin(long id);

}
