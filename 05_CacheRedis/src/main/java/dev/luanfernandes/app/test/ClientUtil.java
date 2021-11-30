package dev.luanfernandes.app.test;

import dev.luanfernandes.app.entity.Produto;
import org.springframework.http.*;
import org.springframework.web.client.RestTemplate;

import java.net.URI;

public class ClientUtil {
    public void getProdutoByIdDemo(long id) {
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);
        RestTemplate restTemplate = new RestTemplate();
        String url = "http://localhost:8080/spring-app/estoque/produto/{id}";
        HttpEntity<String> requestEntity = new HttpEntity<>(headers);
        ResponseEntity<Produto> responseEntity = restTemplate.exchange(url,
                HttpMethod.GET, requestEntity,
                Produto.class, id);
        Produto produto = responseEntity.getBody();
        System.out.println(produto);
    }
    public void getAllProdutosDemo() {
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);
        RestTemplate restTemplate = new RestTemplate();
        String url = "http://localhost:8080/spring-app/estoque/produtos";
        HttpEntity<String> requestEntity = new HttpEntity<>(headers);
        ResponseEntity<Produto[]> responseEntity = restTemplate.exchange(url,
                HttpMethod.GET, requestEntity,
                Produto[].class);
        Produto[] produtos = responseEntity.getBody();
        for (Produto produto : produtos) {
            System.out.println(produto);
        }
    }
    public void addProdutoDemo(Produto objProduto) {
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);
        RestTemplate restTemplate = new RestTemplate();
        String url = "http://localhost:8080/spring-app/estoque/produto";
        HttpEntity<Produto> requestEntity = new HttpEntity<Produto>(objProduto,
                headers);
        URI uri = restTemplate.postForLocation(url, requestEntity);
        System.out.println(uri.getPath());
    }
    public void updateProdutoDemo(Produto objProduto) {
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);
        RestTemplate restTemplate = new RestTemplate();
        String url = "http://localhost:8080/spring-app/estoque/produto";
        HttpEntity<Produto> requestEntity = new HttpEntity<>(objProduto, headers);

        restTemplate.put(url, requestEntity);
    }
    public void deleteProdutoDemo(long id) {
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);
        RestTemplate restTemplate = new RestTemplate();
        String url = "http://localhost:8080/spring-app/estoque/produto/{id}";
        HttpEntity<Produto> requestEntity = new HttpEntity<>(headers);
        restTemplate.exchange(url, HttpMethod.DELETE, requestEntity, Void.class,
                id);
    }
    public static void main(String[] args) {
        ClientUtil util = new ClientUtil();
        Produto objProduto = new Produto(2L, "Pera");
        util.addProdutoDemo(objProduto);
        //objProduto.nome = "Laranja";
        //util.updateProdutoDemo(objProduto);
        //util.deleteProdutoDemo(1);
        //util.getProdutoByIdDemo(1);
        //util.getAllProdutosDemo();
    }
}
