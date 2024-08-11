package com.example.recursive.encryption.controllers;

import com.example.recursive.encryption.services.DecipherService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;


import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("/api/v1/decrypt")
@Tag(name = "decipher-api")
public class DecipherController {

    @Autowired
    private DecipherService decipherService;

    @Operation(summary = "Decrypt data", method = "POST")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Decrypted successfully"),
            @ApiResponse(responseCode = "500", description = "Problem decrypting")
    })
    @PostMapping
    public ResponseEntity<Object> decrypt(@RequestBody Object encryptValue) {
        return ResponseEntity.ok(decipherService.validateObject(encryptValue));

    }
}