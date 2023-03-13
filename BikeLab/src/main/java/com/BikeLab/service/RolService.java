package com.BikeLab.service;

import com.BikeLab.entity.Rol;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.BikeLab.repository.RolRepository;

@Service
public class RolService implements IRolService {

    @Autowired
    private RolRepository roleRepository;

    @Override
    public List<Rol> getAllRole() {
        return (List<Rol>) roleRepository.findAll();
    }

    @Override
    public Rol getRoleById(long id) {
        return roleRepository.findById(id).orElse(null);
    }

    @Override
    public void saveRole(Rol role) {
        roleRepository.save(role);
    }

    @Override
    public void deleteRole(long id) {
        roleRepository.deleteById(id);
    }

}
