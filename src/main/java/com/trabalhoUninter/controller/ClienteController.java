package com.trabalhoUninter.controller;

import com.trabalhoUninter.dto.clienteDTO.ClienteRequestDTO;
import com.trabalhoUninter.dto.clienteDTO.ClienteResponseDTO;
import com.trabalhoUninter.service.ClienteService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/cliente")
@RequiredArgsConstructor
public class ClienteController {

    private final ClienteService service;

    @PostMapping
    public ResponseEntity<ClienteResponseDTO> cadastrarCliente(@RequestBody ClienteRequestDTO requestDTO) {
        ClienteResponseDTO response = service.cadastrarCliente(requestDTO);

        return ResponseEntity.status(HttpStatus.CREATED).body(response);
    }

    @GetMapping("/{id}")
    public ResponseEntity<ClienteResponseDTO> buscarClientePorId(@PathVariable Long id) {
        ClienteResponseDTO response = service.buscarClientePorId(id);

        return ResponseEntity.ok().body(response);
    }

    @GetMapping
    public ResponseEntity<List<ClienteResponseDTO>> buscarTodosClientes() {
        List<ClienteResponseDTO> lista = service.buscarTodosClientes();

        return ResponseEntity.ok().body(lista);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> excluirCliente(@PathVariable Long id) {
        service.excluirCliente(id);

        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    }

}
