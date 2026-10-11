package com.trabalhoUninter.service;

import com.trabalhoUninter.dto.clienteDTO.ClienteRequestDTO;
import com.trabalhoUninter.dto.clienteDTO.ClienteResponseDTO;
import com.trabalhoUninter.mapper.ClienteMapper;
import com.trabalhoUninter.model.Cliente;
import com.trabalhoUninter.repository.ClienteRepository;
import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

@Service
@RequiredArgsConstructor
public class ClienteService {

    private final ClienteMapper mapper;
    private final ClienteRepository repository;

    public ClienteResponseDTO cadastrarCliente(ClienteRequestDTO request) {
        Cliente cliente = mapper.toEntity(request);

        cliente.setClienteDesde(LocalDate.now());

        Cliente clienteSalvo = repository.save(cliente);

        return mapper.toDto(clienteSalvo);

    }

    public ClienteResponseDTO buscarClientePorId(Long id) {
        Cliente cliente = repository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Cliente não encontrado"));

        return mapper.toDto(cliente);

    }

    public List<ClienteResponseDTO> buscarTodosClientes() {
        List<ClienteResponseDTO> listaClientes = repository.findAll()
                .stream()
                .map(mapper::toDto)
                .toList();

        return listaClientes;
    }

    public void excluirCliente(Long id) {
        Cliente cliente = repository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Cliente não encontrado"));

        repository.delete(cliente);
    }
}
