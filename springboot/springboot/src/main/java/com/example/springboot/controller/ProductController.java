package com.example.springboot.controller;

import com.example.springboot.dtos.ProductRecordDto;
import com.example.springboot.models.ProductModel;
import com.example.springboot.repositories.ProductRepository;
import jakarta.validation.Valid;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

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
    // no No corpo vai ter uma lista de ProductModelo
    public ResponseEntity<List<ProductModel>> getAllProducts(){
        return ResponseEntity.status(HttpStatus.OK).body(productRepository.findAll());

    }


}
