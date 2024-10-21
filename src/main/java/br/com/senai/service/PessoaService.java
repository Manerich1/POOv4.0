package br.com.senai.service;

import br.com.senai.entity.Pessoa;
import br.com.senai.repository.PessoaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class PessoaService {

    @Autowired
    PessoaRepository pessoaRepository;

    public List<Pessoa> listarPessoa() {
        return pessoaRepository.findAll();
    }

    public Pessoa cadastrarPessoa(Pessoa pessoa) {
        return pessoaRepository.save(pessoa);
    }

    public Pessoa buscarPessoaPorId(Long idPessoa) {
        return pessoaRepository.findById(idPessoa).orElse(null);
    }

    public List<Pessoa> buscarPessoaPorNome(String nomePessoa) {
        return pessoaRepository.buscarPessoaPorNome(nomePessoa);
    }

    public void excluirPessoa(Long idPessoa) {
        pessoaRepository.deleteById(idPessoa);
    }
}
