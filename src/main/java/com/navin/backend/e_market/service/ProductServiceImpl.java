package com.navin.backend.e_market.service;

import com.navin.backend.e_market.Repository.ProductRepo;
import com.navin.backend.e_market.entity.Product;
import com.navin.backend.e_market.entity.ProductPatch;
import com.navin.backend.e_market.exception.ProductNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Comparator;
import java.util.List;

@Service
public class ProductServiceImpl implements ProductService
{
    @Autowired
    ProductRepo productRepo;


    @Override
    public List<Product> getAll()
    {
        List<Product> products=productRepo.findAll();

        if(products.isEmpty())
        {
            throw new ProductNotFoundException("no product");
        }
        return products;
    }

    @Override
    public Product updateProduct(long proId, Product updatedProduct) {
        return productRepo.findById(proId)
                .map(existingProduct -> {
                    existingProduct.setPrice(updatedProduct.getPrice());
                    existingProduct.setProductName(updatedProduct.getProductName());
                    existingProduct.setProductType(updatedProduct.getProductType());
                    return existingProduct;
                }).map(productRepo::save)
                .orElseThrow(() -> new ProductNotFoundException("Product not found"));
    }

    @Override
    public Product addProduct(Product product) {
        return productRepo.save(product);
    }

    @Override
    public String deleteProduct(long productId)
    {

        Product product=productRepo.findById(productId)
                                   .orElseThrow(()->new ProductNotFoundException("no such product"));
        productRepo.delete(product);
        return "product deleted";
    }

    @Override
    public Product getById(long id)
    {
        return productRepo.findById(id)
                          .orElseThrow(()->new ProductNotFoundException("product not there"));
    }

    @Override
    public List<Product> getProductByType(String type) {
        return productRepo.findByProductType(type)
                          .orElseThrow(()->new ProductNotFoundException("product not there"));
    }
    @Override
    public Product getProductByName(String name) {
        return productRepo.findByProductName(name);
    }
    @Override
    public List<Product> getSortedProductByName() {

        return productRepo.findAll()
                .stream()
                .filter(p->p.getPrice()>10 && p.getPrice()<100)
                .filter(p->p.getId()>1 && p.getId()<100)
                .sorted(Comparator.comparing(Product::getProductName))
                .toList();
    }

    @Override
    public Product patchProduct(Long id, ProductPatch productPatch) {
        return productRepo.findById(id)
                .map(product ->{
                product.setPrice(productPatch.price());
                return product;
                }).orElseThrow();
    }
}
