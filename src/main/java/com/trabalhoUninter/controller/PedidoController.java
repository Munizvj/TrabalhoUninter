package com.trabalhoUninter.controller;

import com.trabalhoUninter.dto.clienteDTO.ClienteResponseDTO;
import com.trabalhoUninter.dto.pedidoDTO.PedidoRequestDTO;
import com.trabalhoUninter.dto.pedidoDTO.PedidoResponseDTO;
import com.trabalhoUninter.service.PedidoService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/pedido")
@RequiredArgsConstructor
public class PedidoController {

    private final PedidoService service;

    @PostMapping
    public ResponseEntity<PedidoResponseDTO> cadastrarPedido(@RequestBody PedidoRequestDTO request) {
        PedidoResponseDTO response = service.criarPedido(request);

        return ResponseEntity.status(HttpStatus.CREATED).body(response);
    }

    @GetMapping("/{id}")
    public ResponseEntity<PedidoResponseDTO> buscarPedidoPorId(@PathVariable Long id) {
        PedidoResponseDTO response = service.buscarPorId(id);

        return ResponseEntity.ok().body(response);
    }

    @GetMapping
    public ResponseEntity<List<PedidoResponseDTO>> buscarTodosPedidos() {
        List<PedidoResponseDTO> lista = service.buscarTodos();

        return ResponseEntity.ok().body(lista);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> excluirPedido(@PathVariable Long id) {
        service.excluir(id);

        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    }

}
