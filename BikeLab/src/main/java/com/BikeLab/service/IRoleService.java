package com.BikeLab.service;

import com.BikeLab.entity.Role;
import java.util.List;
import org.springframework.stereotype.Service;

@Service
public interface IRoleService {

    public List<Role> getAllRole();

    public Role getRoleById(long id);

    public void saveRole(Role role);

    public void deleteRole(long id);

}
