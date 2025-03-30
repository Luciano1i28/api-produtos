package com.example.demo.service;

import com.example.demo.entity.Produto;
import com.example.demo.repository.ProdutoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProdutoService {

    @Autowired
    private ProdutoRepository repository;

    public List<Produto> listarTodos() {
        return repository.findAll();
    }

    public Optional<Produto> listarPorId(Long id) {
        return repository.findById(id);
    }

    public Produto criar(Produto produto) {
        return repository.save(produto);
    }

    public Produto atualizar(Long id, Produto produto) {
        produto.setId(id);
        return repository.save(produto);
    }

    public Produto atualizarEstoque(Long id, double estoque) {
        Produto produto = repository.findById(id).orElseThrow();
        produto.setEstoque(estoque);
        return repository.save(produto);
    }

    public void excluir(Long id) {
        repository.deleteById(id);
    }
}