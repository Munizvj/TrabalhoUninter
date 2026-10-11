package com.trabalhoUninter.mapper;

import com.trabalhoUninter.dto.clienteDTO.ClienteRequestDTO;
import com.trabalhoUninter.dto.clienteDTO.ClienteResponseDTO;
import com.trabalhoUninter.model.Cliente;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface ClienteMapper {

    Cliente toEntity(ClienteRequestDTO dto);

    ClienteResponseDTO toDto(Cliente cliente);

}
