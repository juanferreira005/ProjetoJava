package org.example;

import jakarta.persistence.*;
import java.time.LocalDate;
import org.springframework.web.bind.annotation.CrossOrigin;

import java.util.Random;

@CrossOrigin(origins = "http://127.0.0.1:5500") // Permite apenas o frontend rodando em 127.0.0.1:5500
@Entity
@Table(name = "clientes")
public class Pessoa {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "agencia", nullable = false) // Não pode ser nulo
    private Integer agencia;

    @Column(name = "conta", nullable = false) // Não pode ser nulo
    private String conta;

    @Column(name = "cpf", nullable = false, unique = true)
    private String cpf;

    @Column(name = "nome", nullable = false)
    private String nome;

    @Column(name = "saldo", nullable = true)
    private Double saldo;

    @Column(name = "senha", nullable = false)
    private String senha;

    @Column(name = "data", nullable = false)
    private java.time.LocalDate data;

    public Pessoa() {
        // Gera automaticamente valores para agencia e conta
        this.agencia = gerarAgencia();
        this.conta = gerarConta();
    }

    public Pessoa(String cpf, String nome, Double saldo, String senha, java.time.LocalDate data) {
        this.agencia = gerarAgencia(); // Gerar automaticamente
        this.conta = gerarConta(); // Gerar automaticamente
        this.cpf = cpf;
        this.nome = nome;
        this.saldo = saldo;
        this.senha = senha;
        this.data = data;
    }

    // Métodos para geração automática
    private Integer gerarAgencia() {
        Random random = new Random();
        return 1000 + random.nextInt(9000); // Gera um número de 4 dígitos (1000 a 9999)
    }

    private String gerarConta() {
        Random random = new Random();
        return String.format("%08d", random.nextInt(100000000)); // Gera um número de 8 dígitos
    }

    // Getters e Setters
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getAgencia() {
        return agencia;
    }

    public void setAgencia(Integer agencia) {
        this.agencia = agencia;
    }

    public String getConta() {
        return conta;
    }

    public void setConta(String conta) {
        this.conta = conta;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Double getSaldo() {
        return saldo;
    }

    public void setSaldo(Double saldo) {
        this.saldo = saldo;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    public java.time.LocalDate getData() {
        return data;
    }

    public void setData(java.time.LocalDate data) {
        this.data = data;
    }
}
