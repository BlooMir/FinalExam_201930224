package com.example.finalexam_201930224.controller;

import com.example.finalexam_201930224.dto.product.ChangeProductDTO;
import com.example.finalexam_201930224.dto.product.ProductDTO;
import com.example.finalexam_201930224.dto.product.ProductResponseDTO;
import com.example.finalexam_201930224.entity.Product;
import com.example.finalexam_201930224.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/product")
public class ProductController {

    private final ProductService productService;

    @Autowired
    public ProductController(ProductService productService) {
        this.productService = productService;
    }

    @PostMapping()
    @PreAuthorize("hasRole('ROLE_ADMIN')")
    public ResponseEntity<ProductResponseDTO> createProduct(@RequestBody ProductDTO productDTO) {
        ProductResponseDTO productResponseDTO = productService.saveProduct(productDTO);
        return ResponseEntity.status(HttpStatus.OK).body(productResponseDTO);
    }

    @PutMapping()
    @PreAuthorize("hasRole('ROLE_ADMIN')")
    public ResponseEntity<ProductResponseDTO> changeProductName(@RequestBody ChangeProductDTO changeProductDTO) throws Exception{
        ProductResponseDTO productResponseDTO = productService.changeProductName(changeProductDTO.getNumber(), changeProductDTO.getName());
        return ResponseEntity.status(HttpStatus.OK).body(productResponseDTO);
    }

    @DeleteMapping()
    @PreAuthorize("hasRole('ROLE_ADMIN')")
    public ResponseEntity<String> deleteProduct(Long number) throws Exception{
        productService.deleteProduct(number);
        return ResponseEntity.status(HttpStatus.OK).body("정상적으로 삭제되었습니다.");
    }
    @GetMapping("/list")
    public List<Product> listProductAll(){
        return productService.listProductAll();
    }

    @GetMapping("listOrderByPrice")
    public List<Product> listProductAllOrderByPrice(){
        return productService.listProductAllOrderByPriceDesc();
    }

    @GetMapping("/byName")
    public List<Product> listProductByName(String name){
        return productService.ProductFindByName(name);
    }

    @GetMapping("/")
    public ResponseEntity<ProductResponseDTO> getProduct(Long number) {
        ProductResponseDTO productResponseDTO = productService.getProduct(number);
        return ResponseEntity.status(HttpStatus.OK).body(productResponseDTO);
    }
}
