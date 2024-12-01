package org.example;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/pessoas")
public class PessoaController {

    @Autowired
    private PessoaRepositorio pessoaRepositorio;

    // Endpoint para cadastrar uma pessoa
    @PostMapping
    public ResponseEntity<Pessoa> cadastrarPessoa(@RequestBody Pessoa pessoa) {
        Pessoa novaPessoa = pessoaRepositorio.save(pessoa);
        return ResponseEntity.ok(novaPessoa);
    }

    // Endpoint para listar todas as pessoas
    @GetMapping
    public ResponseEntity<?> listarPessoas() {
        return ResponseEntity.ok(pessoaRepositorio.findAll());
    }

    @PostMapping("/login")
    public ResponseEntity<?> login(@RequestBody Login loginRequest) {
        // Buscar a pessoa pelo CPF e senha
        Pessoa pessoa = pessoaRepositorio.findByCpfAndSenha(loginRequest.getCpf(), loginRequest.getSenha());

        if (pessoa != null) {
            return ResponseEntity.ok(pessoa);
        } else {
            return ResponseEntity.status(401).body("CPF ou senha inválidos.");
        }
    }

    @GetMapping("/{cpf}")
    public ResponseEntity<?> buscarPessoaPorCpf(@PathVariable String cpf) {
        Pessoa pessoa = pessoaRepositorio.findByCpf(cpf);

        if (pessoa == null) {
            return ResponseEntity.status(404).body("Usuário não encontrado.");
        }

        return ResponseEntity.ok(pessoa);
    }


    @PutMapping("/alterar-saldo")
    public ResponseEntity<?> alterarSaldo(@RequestBody Saldo alterarSaldoRequest) {
        // Buscar a pessoa pelo CPF
        Pessoa pessoa = pessoaRepositorio.findByCpf(alterarSaldoRequest.getCpf());

        if (pessoa == null) {
            return ResponseEntity.status(404).body("Usuário não encontrado.");
        }

        // Atualizar o saldo
        pessoa.setSaldo(alterarSaldoRequest.getNovoSaldo());
        pessoaRepositorio.save(pessoa);

        return ResponseEntity.ok(pessoa);
    }



}


