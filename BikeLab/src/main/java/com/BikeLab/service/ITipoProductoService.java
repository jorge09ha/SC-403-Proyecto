package com.BikeLab.service;

import com.BikeLab.entity.TipoProducto;
import java.util.List;
import org.springframework.stereotype.Service;

@Service
public interface ITipoProductoService {

    public List<TipoProducto> getAllTipoProducto();

    public TipoProducto getTipoProductoById(long id);

    public void saveTipoProducto(TipoProducto tipoProducto);

    public void deleteTipoProducto(long id);

}
