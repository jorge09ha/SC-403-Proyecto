package com.BikeLab.service;

import com.BikeLab.entity.DatosLogin;
import static org.hibernate.bytecode.BytecodeLogging.LOGGER;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

/**
 *
 * @author bperez
 */
@Service
public class UserService implements UserDetailsService {

    @Autowired
    public IDatosLoginService datosLoginService;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        LOGGER.info("Buscando usuario con correo: " + username);
        System.out.println("username: " + username);
        DatosLogin datosLogin = this.datosLoginService.findByEmail(username);
        System.out.println("datosLogin: " + datosLogin);
        if (datosLogin == null) {
            throw new UsernameNotFoundException("Usuario no encontrado");
        }
        Userprincipal userPrincipal = new Userprincipal(datosLogin);
        return userPrincipal;
    }

}
