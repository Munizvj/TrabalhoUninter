package com.trabalhoUninter.dto.produtoDTO;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ProdutoRequestDTO {

    private String nome;
    private BigDecimal preco;
    private Boolean estoque;

}
