package org.example;

import org.springframework.data.jpa.repository.JpaRepository;

public interface PessoaRepositorio extends JpaRepository<Pessoa, Long> {
    Pessoa findByCpfAndSenha(String cpf, String senha);
    Pessoa findByCpf(String cpf);
}
