package com.BikeLab.service;

import com.BikeLab.entity.DatosLogin;
import com.BikeLab.entity.Usuario;
import com.BikeLab.repository.DatosLoginRepository;
import com.BikeLab.repository.UsuarioRepository;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UsuarioService implements IUsuarioService {

    @Autowired
    private UsuarioRepository usuarioRepository;
    
    @Autowired
    private DatosLoginRepository datosLoginRepository;
  
    @Override
    public List<Usuario> getAllUsuario() {
        return (List<Usuario>) usuarioRepository.findAll();
    }

    @Override
    public Usuario getUsuarioById(long id) {
        return usuarioRepository.findById(id).orElse(null);
    }

    @Override
    public void saveUsuario(Usuario usuario) {
        usuarioRepository.save(usuario);
    }

    @Override
    public void deleteUsuario(long id) {
        usuarioRepository.deleteById(id);
    }

    @Override
    public DatosLogin getDatosLoginById(long id) {
        return datosLoginRepository.findById(id).orElse(null);
    }

    @Override
    public Usuario getUserById(Long userId) {
    return usuarioRepository.getUserById(userId);
    }

    
}
