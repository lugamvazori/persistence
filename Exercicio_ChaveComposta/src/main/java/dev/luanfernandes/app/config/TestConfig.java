package dev.luanfernandes.app.config;


import dev.luanfernandes.app.entity.*;
import dev.luanfernandes.app.repository.ClienteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;

import java.util.Date;

@Configuration
public class TestConfig implements CommandLineRunner {

    @Autowired
    ClienteRepository clienteRepository;

    @Override
    public void run(String... args) {

        // Defnindo o cliente
        Cliente cliente = new Cliente(10L,"Fiap");

        // Definindo o endereço
        Endereco endereco = new Endereco("Lins de Vasconcelos","São Paulo","01538-001",cliente);

        // Defnindo o pedido
        PedidosPK pkpedido = new PedidosPK(100,"Livros");
        Pedido pedido = new Pedido(new Date(),pkpedido,cliente);

        // Adicionando Itens
        pedido.addItem(new Item(2));
        pedido.addItem(new Item(3));

        cliente.addEndereco(endereco);
        cliente.addPedido(pedido);

        clienteRepository.save(cliente);

    }

}
