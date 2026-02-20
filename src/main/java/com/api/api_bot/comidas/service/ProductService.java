package com.api.api_bot.comidas.service;

import org.springframework.stereotype.Service;

import com.api.api_bot.comidas.domain.Product;
import com.api.api_bot.comidas.repository.ProductRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class ProductService 
{
    private final ProductRepository _productRepository;

    public Product save(Product product)
    {
        return _productRepository.save(product);
    }
}
