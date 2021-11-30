package dev.luanfernandes.app.controller;

import dev.luanfernandes.app.entity.Produto;
import dev.luanfernandes.app.service.IProdutoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

import java.util.List;

@RestController
@RequestMapping("estoque")
public class ProdutoController {
    @Autowired
    private IProdutoService produtoService;

    @GetMapping("produto/{id}")
    public ResponseEntity<Produto> getProdutoById(@PathVariable("id") Long id)
    {
        Produto produto = produtoService.getProdutoById(id);
        return new ResponseEntity<>(produto, HttpStatus.OK);
    }
    @GetMapping("produtos")
    public ResponseEntity<List<Produto>> getAllProdutos() {
        List<Produto> lista = produtoService.getAllProdutos();
        return new ResponseEntity<>(lista, HttpStatus.OK);
    }
    @PostMapping("produto")
    public ResponseEntity<Void> addProduto(@RequestBody Produto produto, UriComponentsBuilder builder) {
        Produto savedProduto = produtoService.addProduto(produto);
        HttpHeaders headers = new HttpHeaders();

        headers.setLocation(builder.path("/produto/{id}").buildAndExpand(savedProduto.getId()).toUri());
        return new ResponseEntity<>(headers, HttpStatus.CREATED);
    }
    @PutMapping("produto")
    public ResponseEntity<Produto> updateProduto(@RequestBody Produto produto)
    {
        produtoService.updateProduto(produto);
        return new ResponseEntity<>(produto, HttpStatus.OK);
    }
    @DeleteMapping("produto/{id}")
    public ResponseEntity<Void> deleteArticle(@PathVariable("id") Long id) {
        produtoService.deleteProduto(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
