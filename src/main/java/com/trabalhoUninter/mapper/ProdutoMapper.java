package com.trabalhoUninter.mapper;

import com.trabalhoUninter.dto.produtoDTO.ProdutoRequestDTO;
import com.trabalhoUninter.dto.produtoDTO.ProdutoResponseDTO;
import com.trabalhoUninter.model.Produto;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface ProdutoMapper {

    Produto toEntity(ProdutoRequestDTO dto);

    ProdutoResponseDTO toDto(Produto produto);

}
