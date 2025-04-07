package com.example.Spring.Services;

import com.example.Spring.Pedido;
import com.example.Spring.Repository.PedidoRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PedidoService {

    private final PedidoRepository repository;

    public PedidoService(PedidoRepository repository) {
        this.repository = repository;
    }

    public List<Pedido> listarTodos() {
        return repository.findAll();
    }

    public Optional<Pedido> buscarPorId(Long id) {
        return repository.findById(id);
    }

    public Pedido salvar(Pedido pedido) {
        return repository.save(pedido);
    }

    public Pedido atualizar(Long id, Pedido pedidoAtualizado) {
        Pedido existente = repository.findById(id)
                .orElseThrow(() -> new RuntimeException("Pedido não encontrado"));

        existente.setData(pedidoAtualizado.getData());
        existente.setStatus(pedidoAtualizado.getStatus());
        existente.setCliente(pedidoAtualizado.getCliente());
        existente.setProdutos(pedidoAtualizado.getProdutos());

        return repository.save(existente);
    }

    public void deletar(Long id) {
        repository.deleteById(id);
    }
}
