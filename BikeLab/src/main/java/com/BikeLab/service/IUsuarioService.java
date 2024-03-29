package com.BikeLab.service;

import com.BikeLab.entity.DatosLogin;
import com.BikeLab.entity.Usuario;
import java.util.List;
import org.springframework.stereotype.Service;

@Service
public interface IUsuarioService {

    public List<Usuario> getAllUsuario();

    public Usuario getUsuarioById(long id);

    public void saveUsuario(Usuario usuario);

    public void deleteUsuario(long id);

    public DatosLogin getDatosLoginById(long id);
    
     public Usuario getUserById(Long userId);
 
}
