package com.trabalhoUninter.mapper;

import com.trabalhoUninter.dto.pedidoDTO.PedidoRequestDTO;
import com.trabalhoUninter.dto.pedidoDTO.PedidoResponseDTO;
import com.trabalhoUninter.model.Pedido;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface PedidoMapper {

    Pedido toEntity(PedidoRequestDTO dto);

    PedidoResponseDTO toDto(Pedido pedido);

}
