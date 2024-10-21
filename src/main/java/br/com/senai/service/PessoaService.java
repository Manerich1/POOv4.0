package br.com.senai.service;

import br.com.senai.entity.Pessoa;
import br.com.senai.exception.EntidadeException;
import br.com.senai.repository.PessoaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
// Aula top começamos arrumando o PessoaService

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
//        Pessoa pessoa = pessoaRepository.findById(idPessoa)
//                .orElseThrow(() ->
//                        new RuntimeException("Cadastro não encontrado. ID: " + idPessoa + " i.nválido"));
        Pessoa pessoa = pessoaRepository.findById(idPessoa)
                .orElseThrow(() ->
                        new EntidadeException("Cadastro não encontrado. ID: " + idPessoa + " inválido"));
        return pessoa;
    }

    public List<Pessoa> buscarPessoaPorNome(String nomePessoa) {
        List<Pessoa> pessoas = new ArrayList<>();
        try {
            pessoas = pessoaRepository.buscarPessoaPorNome(nomePessoa);

            System.out.println(pessoas.get(1).getNome());

        } catch (EntidadeException entidade) {
            System.out.println(entidade.getMessage());
        }

        return pessoas;
    }

    public void excluirPessoa(Long idPessoa) {
        pessoaRepository.deleteById(idPessoa);
    }
}
