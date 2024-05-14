package com.example.springboot.controllers;

import com.example.springboot.dtos.APIRecordDto;
import com.example.springboot.models.APIModel;
import com.example.springboot.repositories.APIRepository;

import jakarta.validation.Valid;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.linkTo;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.methodOn;

//Código dos métodos CRUD para o banco de dados
@RestController
public class APIController {
	
	@Autowired
	APIRepository productRepository;
	
	//Método GET
	@GetMapping("/APIs")
	public ResponseEntity<List<APIModel>> getAllProducts(){
		List<APIModel> productsList = productRepository.findAll();
		if(!productsList.isEmpty()) {
			for(APIModel product : productsList) {
				UUID id = product.getIdProduct();
				product.add(linkTo(methodOn(APIController.class).getOneProduct(id)).withSelfRel());
			}
		}
		return ResponseEntity.status(HttpStatus.OK).body(productsList);
	}

	//Método GET com ID
	@GetMapping("/APIs/{id}")
	public ResponseEntity<Object> getOneProduct(@PathVariable(value="id") UUID id){
		Optional<APIModel> productO = productRepository.findById(id);
		if(productO.isEmpty()) {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Product not found.");
		}
		productO.get().add(linkTo(methodOn(APIController.class).getAllProducts()).withRel("Products List"));
		return ResponseEntity.status(HttpStatus.OK).body(productO.get());
	}
	
	//Método POST
	@PostMapping("/APIs")
	public ResponseEntity<APIModel> saveProduct(@RequestBody @Valid APIRecordDto productRecordDto) {
		var productModel = new APIModel();
		BeanUtils.copyProperties(productRecordDto, productModel);
		return ResponseEntity.status(HttpStatus.CREATED).body(productRepository.save(productModel));
	}
	
	//Método DELETE
	@DeleteMapping("/APIs/{id}")
	public ResponseEntity<Object> deleteProduct(@PathVariable(value="id") UUID id) {
		Optional<APIModel> productO = productRepository.findById(id);
		if(productO.isEmpty()) {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Product not found.");
		}
		productRepository.delete(productO.get());
		return ResponseEntity.status(HttpStatus.OK).body("Product deleted successfully.");
	}
	
	//Método POST
	@PutMapping("/APIs/{id}")
	public ResponseEntity<Object> updateProduct(@PathVariable(value="id") UUID id,
													  @RequestBody @Valid APIRecordDto productRecordDto) {
		Optional<APIModel> productO = productRepository.findById(id);
		if(productO.isEmpty()) {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Product not found.");
		}
		var productModel = productO.get();
		BeanUtils.copyProperties(productRecordDto, productModel);
		return ResponseEntity.status(HttpStatus.OK).body(productRepository.save(productModel));
	}

}
