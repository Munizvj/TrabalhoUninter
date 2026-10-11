package com.trabalhoUninter.service;

import com.trabalhoUninter.dto.produtoDTO.ProdutoRequestDTO;
import com.trabalhoUninter.dto.produtoDTO.ProdutoResponseDTO;
import com.trabalhoUninter.mapper.ProdutoMapper;
import com.trabalhoUninter.model.Produto;
import com.trabalhoUninter.repository.ProdutoRepository;
import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ProdutoService {

    private final ProdutoRepository repository;
    private final ProdutoMapper mapper;

    @Transactional
    public ProdutoResponseDTO criarProduto(ProdutoRequestDTO request) {
        Produto produto = mapper.toEntity(request);

        Produto produtoSalvo = repository.save(produto);

        return mapper.toDto(produtoSalvo);
    }

    public ProdutoResponseDTO buscarProdutoPorId(Long id) {
        Produto produto = repository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Produto não encontrado"));

        return mapper.toDto(produto);
    }

    public List<ProdutoResponseDTO> buscarTodosProdutos() {
        List<ProdutoResponseDTO> listaProdutos = repository.findAll()
                .stream()
                .map(mapper::toDto)
                .toList();

        return listaProdutos;
    }

    public Void excluir(Long id) {
        Produto produto = repository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException());

        repository.delete(produto);
        return null;
    }

}
