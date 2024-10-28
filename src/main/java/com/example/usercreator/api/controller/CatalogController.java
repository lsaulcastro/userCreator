package com.example.usercreator.api.controller;

import com.example.usercreator.application.baseDto.GenericResponse;
import com.example.usercreator.application.service.ICatalogService;
import com.example.usercreator.application.service.dto.user.UserResponseDto;
import com.example.usercreator.domain.model.catalog.CatalogEntity;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

/**
 * @author Saul Castro
 * @project userCreator
 * @since 10/27/2024
 */
@RestController
@RequestMapping("/api/catalog")
public class CatalogController {

    private final ICatalogService catalogService;

    public CatalogController(ICatalogService catalogService) {
        this.catalogService = catalogService;
    }

    @PutMapping("/{id}")
    public ResponseEntity<GenericResponse<CatalogEntity>> updateUserEmail(@PathVariable Long id, @RequestBody String value) {
        return new ResponseEntity<>(new GenericResponse<>(HttpStatus.OK, catalogService.update(id, value)), HttpStatus.CREATED);
    }

    @GetMapping()
    public ResponseEntity<GenericResponse<List<CatalogEntity>>> getAll() {
        return new ResponseEntity<>(new GenericResponse<>(HttpStatus.OK, catalogService.findAll()), HttpStatus.CREATED);
    }

}
