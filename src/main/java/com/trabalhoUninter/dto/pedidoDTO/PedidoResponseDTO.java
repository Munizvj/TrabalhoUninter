package com.trabalhoUninter.dto.pedidoDTO;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class PedidoResponseDTO {

    private Long id;
    private Long clienteId;
    private Long produtoId;
    private Integer quantidade;

}
