package br.com.senai.controller;

import br.com.senai.entity.Pessoa;
import br.com.senai.service.PessoaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@Controller
@RestController
@RequestMapping("/pessoa")
public class PessoaController {

    @Autowired
    private PessoaService pessoaService;

    @GetMapping
    public List<String> listarNome(){
        List<String> nomes = new ArrayList<String>();
        nomes.add("Johnatan");
        nomes.add("Mayara");
        nomes.add("Livia");

        return nomes;
    }

    @PostMapping
    public Pessoa cadastrarPessoa(@RequestBody Pessoa pessoa) {
        return pessoaService.cadastrarPessoa(pessoa);
    }

    @GetMapping("/listar")
    public List<Pessoa> listarPessoa() {
        return pessoaService.listarPessoa();
    }

    @GetMapping("/buscar/{idPessoa}")
    public Pessoa buscarPessoaPorId(@PathVariable Long idPessoa) {
        return pessoaService.buscarPessoaPorId(idPessoa);
    }

    @GetMapping("listar-nome/{nomePessoa}")
    public List<Pessoa> buscarPessoaPorNome(@PathVariable String nomePessoa) {
        return pessoaService.buscarPessoaPorNome(nomePessoa);
    }

    @DeleteMapping("/{idPessoa}")
    public void excluirPessoa(@PathVariable Long idPessoa) {
        pessoaService.excluirPessoa(idPessoa);
    }
}
