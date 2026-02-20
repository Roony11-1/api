package com.api.api_bot.comidas.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.api.api_bot.comidas.domain.Product;
import com.api.api_bot.comidas.service.ProductService;

import lombok.RequiredArgsConstructor;

@RestController
@RequiredArgsConstructor
@RequestMapping("/product/v1")
public class ProductController 
{
    private final ProductService _productService;

    @PostMapping
    public ResponseEntity<Product> save(@RequestBody Product product)
    {
        Product productSaved = _productService.save(product);

        return ResponseEntity.ok(productSaved);
    }
}
