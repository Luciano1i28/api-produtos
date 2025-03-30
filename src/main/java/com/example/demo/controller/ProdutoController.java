package com.example.demo.controller;

import com.example.demo.entity.Produto;
import com.example.demo.service.ProdutoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import javax.validation.Valid;

import java.util.List;

@RestController
@RequestMapping("/produtos")
public class ProdutoController {

    @Autowired
    private ProdutoService service;

    @GetMapping("/listar")
    public List<Produto> listarTodos() {
        return service.listarTodos();
    }

    @GetMapping("/listar/{id}")
    public Produto listarPorId(@PathVariable Long id) {
        return service.listarPorId(id).orElseThrow(() -> new RuntimeException("Produto não encontrado"));
    }

    @PostMapping("/criar")
    public Produto criar(@Valid @RequestBody Produto produto) {
        return service.criar(produto);
    }

    @PutMapping("/atualizar/{id}")
    public Produto atualizar(@PathVariable Long id, @Valid @RequestBody Produto produto) {
        return service.atualizar(id, produto);
    }

    @PutMapping("/estoque/{id}")
    public Produto atualizarEstoque(@PathVariable Long id, @RequestBody double estoque) {
        return service.atualizarEstoque(id, estoque);
    }

    @DeleteMapping("/excluir/{id}")
    public void excluir(@PathVariable Long id) {
        service.excluir(id);
    }
}