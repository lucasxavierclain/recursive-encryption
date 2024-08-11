package com.example.recursive.encryption.controllers;


import com.example.recursive.encryption.services.CipherService;

import io.swagger.v3.oas.annotations.Operation;

import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/encrypt")
@Tag(name = "cipher-api")
public class CipherController {

    @Autowired
    private CipherService cipherService;

    @Operation(summary = "Encrypt data",  method = "POST")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Successfully encrypted"),
            @ApiResponse(responseCode = "500", description = "Problem encrypting")
    })
    @PostMapping
    public ResponseEntity<Object> encrypt(@RequestBody Object encryptValue) {
        return ResponseEntity.ok(cipherService.validateObject( encryptValue));
    }
}