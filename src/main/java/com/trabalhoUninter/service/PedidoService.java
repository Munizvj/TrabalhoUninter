package com.trabalhoUninter.service;

import com.trabalhoUninter.dto.pedidoDTO.PedidoRequestDTO;
import com.trabalhoUninter.dto.pedidoDTO.PedidoResponseDTO;
import com.trabalhoUninter.mapper.PedidoMapper;
import com.trabalhoUninter.model.Pedido;
import com.trabalhoUninter.repository.ClienteRepository;
import com.trabalhoUninter.repository.PedidoRepository;
import com.trabalhoUninter.repository.ProdutoRepository;
import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class PedidoService {

    private final PedidoMapper mapper;
    private final PedidoRepository pedidoRepository;
    private final ClienteRepository clienteRepository;
    private final ProdutoRepository produtoRepository;

    public PedidoResponseDTO criarPedido(PedidoRequestDTO request) {
        Pedido pedido = mapper.toEntity(request);

        if (!clienteRepository.existsById(pedido.getClienteId())) {
            throw new RuntimeException("Cliente não encontrado");
        }

        if (!produtoRepository.existsById(pedido.getProdutoId())) {
            throw new RuntimeException("Produto não encontrado");
        }

        Pedido pedidoSalvo = pedidoRepository.save(pedido);

        return mapper.toDto(pedidoSalvo);
    }

    public PedidoResponseDTO buscarPorId(Long id) {
        Pedido pedido = pedidoRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Pedido não encontrado"));

        return mapper.toDto(pedido);
    }

    public List<PedidoResponseDTO> buscarTodos() {

        List<PedidoResponseDTO> listaPedidos = pedidoRepository.findAll()
                .stream()
                .map(mapper::toDto)
                .toList();

        return listaPedidos;
    }

    public void excluir(Long id) {
        Pedido pedido = pedidoRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Pedido não encontrado"));

        pedidoRepository.delete(pedido);
    }

}
