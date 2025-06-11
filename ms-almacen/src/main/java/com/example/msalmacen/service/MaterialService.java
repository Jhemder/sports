package com.example.msalmacen.service;

import com.example.msalmacen.entity.Material;
import com.example.msalmacen.repository.MaterialRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class MaterialService {

    private final MaterialRepository repository;

    public Material guardarMaterial(Material materialNuevo) {
        Optional<Material> existente = repository.findByTipoAndNombreAndColor(
                materialNuevo.getTipo(), materialNuevo.getNombre(), materialNuevo.getColor());

        if (existente.isPresent()) {
            Material existenteMat = existente.get();
            existenteMat.setCantidad(existenteMat.getCantidad() + materialNuevo.getCantidad());
            return repository.save(existenteMat);
        } else {
            return repository.save(materialNuevo);
        }
    }

    public List<Material> listar() {
        return repository.findAll();
    }

    public Optional<Material> buscarPorId(Long id) {
        return repository.findById(id);
    }

    public void eliminar(Long id) {
        repository.deleteById(id);
    }

    public Material actualizar(Long id, Material material) {
        Material existente = repository.findById(id)
                .orElseThrow(() -> new RuntimeException("Material no encontrado"));

        existente.setCantidad(material.getCantidad());
        existente.setMedida(material.getMedida());
        existente.setCostoUnitario(material.getCostoUnitario());
        existente.setProveedor(material.getProveedor());
        return repository.save(existente);
    }
}
