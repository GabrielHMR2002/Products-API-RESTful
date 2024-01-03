package com.example.springboot.controller;

import com.example.springboot.dtos.ProductRecordDto;
import com.example.springboot.models.ProductModel;
import com.example.springboot.repositories.ProductRepository;
import jakarta.validation.Valid;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@RestController
public class ProductController {

    @Autowired
    ProductRepository productRepository;

    @PostMapping("/products")

    //        TIPO DE RETORNO
    public ResponseEntity<ProductModel> saveProduct(@RequestBody @Valid ProductRecordDto productRecord){


        //Ao ínves de ter que declarar o tipo dessa instância dos dois lados utilizamos o var
        //para fazer essa definição apenas do lado direito
        // ProductModel productModel = new ProductModel();
        //inicia o productModel
        var productModel = new ProductModel();

        //RECEBE O productRecord que vai ser convertido em productModel
        // BeanUtils.copyProperties(O QUE VAI SER CONVERTIDO, TIPO QUE VAI SER CONVERTIDO);
        BeanUtils.copyProperties(productRecord, productModel);

        // COMO ESTAMOS CRIANDO UM RECURSO NA BASE DE DADOS PRESCIAMOS ENVIAR PARA O CLIENTE QUE ESSE
        // RECURSO FOI CRIADO, ASSIM USAMOS O HttpStatus.CREATED) QUE É O 201 E NO CORPO DA RESPOSTA ENVIAMOS O QUE FOI SALVO
        //                                               UTILIZANDO DO productRepository onde tem  METOOD SAVE .save()
        return ResponseEntity.status(HttpStatus.CREATED).body(productRepository.save(productModel));
    }

    @GetMapping("/products")
    //No corpo vai ter uma lista de ProductModelo
    public ResponseEntity<List<ProductModel>> getAllProducts(){
        return ResponseEntity.status(HttpStatus.OK).body(productRepository.findAll());

    }

    /*<Object>: Isso indica que o corpo da resposta pode ser de qualquer tipo.
     O Object é um tipo genérico, o que significa que você pode usar ResponseEntity para encapsular a resposta de diferentes tipos de objetos.*/
    @GetMapping("/products/{id}")
    public ResponseEntity<Object> getOneProduct(@PathVariable(value = "id") UUID id) {
        Optional<ProductModel> product0 = productRepository.findById(id);
        if(product0.isEmpty()){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Product not found");

        }

        return ResponseEntity.status(HttpStatus.OK).body(product0.get());

    }

}
