package com.navin.backend.e_market.service;

import com.navin.backend.e_market.Repository.ProductRepo;
import com.navin.backend.e_market.entity.Product;
import com.navin.backend.e_market.exception.ProductNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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

        if(products==null)
        {
            throw new ProductNotFoundException("no product");
        }
        return products;
    }

    @Override
    public Product updateRate(long proId, Product updatedProduct) {

        Product existProduct=productRepo.findById(proId)
                                        .orElseThrow(()->new ProductNotFoundException("Product not found"));

      existProduct.setProductName(updatedProduct.getProductName());
      existProduct.setProductType(updatedProduct.getProductType());
      existProduct.setPrice(updatedProduct.getPrice());
      productRepo.save(existProduct);

      return updatedProduct;
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
}
