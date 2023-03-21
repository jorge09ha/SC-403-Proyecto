package com.BikeLab.service;

import com.BikeLab.entity.TipoProducto;
import com.BikeLab.repository.TipoProductoRepository;
import com.BikeLab.service.ITipoProductoService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TipoProductoService implements ITipoProductoService {

    @Autowired
    private TipoProductoRepository tipoProductoRepository;

    @Override
    public List<TipoProducto> getAllTipoProducto() {
        return (List<TipoProducto>) tipoProductoRepository.findAll();
    }

    @Override
    public TipoProducto getTipoProductoById(long id) {
        return tipoProductoRepository.findById(id).orElse(null);
    }

    @Override
    public void saveTipoProducto(TipoProducto tipoProducto) {
        tipoProductoRepository.save(tipoProducto);
    }

    @Override
    public void deleteTipoProducto(long id) {
        tipoProductoRepository.deleteById(id);
    }

}
