package com.trabalhoUninter.controller;

import com.trabalhoUninter.dto.produtoDTO.ProdutoRequestDTO;
import com.trabalhoUninter.dto.produtoDTO.ProdutoResponseDTO;
import com.trabalhoUninter.service.ProdutoService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/produto")
@RequiredArgsConstructor
public class ProdutoController {

    private final ProdutoService service;

    @PostMapping
    public ResponseEntity<ProdutoResponseDTO> cadastrarProduto(@RequestBody ProdutoRequestDTO request) {
        ProdutoResponseDTO response = service.criarProduto(request);

        return ResponseEntity.status(HttpStatus.CREATED).body(response);
    }

    @GetMapping("/{id}")
    public ResponseEntity<ProdutoResponseDTO> buscarProdutoPorId(@PathVariable Long id) {
        ProdutoResponseDTO lista = service.buscarProdutoPorId(id);

        return ResponseEntity.ok(lista);
    }

    @GetMapping
    public ResponseEntity<List<ProdutoResponseDTO>> buscarTodosProdutos() {
        List<ProdutoResponseDTO> response = service.buscarTodosProdutos();

        return ResponseEntity.ok(response);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> excluirProduto(@PathVariable Long id) {
        service.excluir(id);

        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    }

}
