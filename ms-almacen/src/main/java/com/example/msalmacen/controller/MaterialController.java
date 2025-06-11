package com.example.msalmacen.controller;

import com.example.msalmacen.entity.Material;
import com.example.msalmacen.service.MaterialService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/materiales")
@RequiredArgsConstructor
public class MaterialController {

    private final MaterialService service;

    @PostMapping
    public Material guardar(@RequestBody Material material) {
        return service.guardarMaterial(material);
    }

    @GetMapping
    public List<Material> listar() {
        return service.listar();
    }

    @GetMapping("/{id}")
    public Material obtener(@PathVariable Long id) {
        return service.buscarPorId(id).orElse(null);
    }

    @PutMapping("/{id}")
    public Material actualizar(@PathVariable Long id, @RequestBody Material material) {
        return service.actualizar(id, material);
    }

    @DeleteMapping("/{id}")
    public void eliminar(@PathVariable Long id) {
        service.eliminar(id);
    }
}
