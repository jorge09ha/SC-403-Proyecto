package com.BikeLab.service;

import com.BikeLab.entity.Usuario;
import java.util.List;
import org.springframework.stereotype.Service;

@Service
public interface IUsuarioService {

    public List<Usuario> getAllUsuario();

    public Usuario getUsuarioById(long id);

    public void saveUsuario(Usuario usuario);

    public void deleteUsuario(long id);
    
    public List<Usuario> getAllUser();
    
  public Usuario findByCorreo(String username);
}
