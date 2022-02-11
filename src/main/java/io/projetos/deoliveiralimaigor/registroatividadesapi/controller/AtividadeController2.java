package io.projetos.deoliveiralimaigor.registroatividadesapi.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import io.projetos.deoliveiralimaigor.registroatividadesapi.entity.AtividadeEntity;
import io.projetos.deoliveiralimaigor.registroatividadesapi.repository.AtividadeRepository;
import io.projetos.deoliveiralimaigor.registroatividadesapi.request.AtividadeRequest;
import io.projetos.deoliveiralimaigor.registroatividadesapi.response.AtividadeResponse;
import io.projetos.deoliveiralimaigor.registroatividadesapi.service.AtividadeService;

@RestController
@RequestMapping("teste")
public class AtividadeController2 {

    @Autowired
    AtividadeService atividadeService;

    @Autowired 
    AtividadeRepository atividadeRepository;

    @PostMapping
    public @ResponseBody AtividadeEntity salvaAtividade(@RequestBody AtividadeEntity atividade){

        System.out.println(atividade);
        atividadeRepository.save(atividade);

         
        return atividade;
    }

    @GetMapping("/{id}")
    public AtividadeResponse obtemAtividade(@PathVariable Long id){
        
        return atividadeService.obterAtividade(id);
    }
    
    @GetMapping
    public List<AtividadeResponse> listaAtividades(){

        return atividadeService.listaAtividade();

    }

    @PutMapping("/{id}")
    public AtividadeResponse atualizaAtividade(AtividadeRequest atividadeRequest ,@PathVariable Long id){


        return atividadeService.AtualizaAtividade(atividadeRequest, id);

    }

    @DeleteMapping("/{id}")
    public AtividadeResponse ExcluiAtividade(@PathVariable Long id){

        return atividadeService.ExcluiAtividade(id);
        

    }

}
