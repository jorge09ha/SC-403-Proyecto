package com.BikeLab.service;

import com.BikeLab.entity.Rol;
import java.util.List;
import org.springframework.stereotype.Service;

@Service
public interface IRolService {

    public List<Rol> getAllRole();

    public Rol getRoleById(long id);

    public void saveRole(Rol role);

    public void deleteRole(long id);

}
