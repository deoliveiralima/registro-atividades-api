package io.projetos.deoliveiralimaigor.registroatividadesapi.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import io.projetos.deoliveiralimaigor.registroatividadesapi.request.CategoriaAtividadeRequest;
import io.projetos.deoliveiralimaigor.registroatividadesapi.response.CategoriaAtividadeResponse;
import io.projetos.deoliveiralimaigor.registroatividadesapi.service.CategoriaAtividadeService;

@RestController
@RequestMapping("categoria-atividade")
public class CategoriaAtividadeController {

    @Autowired
    private CategoriaAtividadeService categoriaAtividadeService;

    @PostMapping
    @ResponseBody
    public CategoriaAtividadeResponse salvaCategoriaAtividade(@RequestBody CategoriaAtividadeRequest categoriaAtividadeRequest){

        return categoriaAtividadeService.salvaCategoriaAtividade(categoriaAtividadeRequest);

    }

    @ResponseBody
    @GetMapping
    public <Set>CategoriaAtividadeResponse listaCategoriaAtividade(){

        return (CategoriaAtividadeResponse) categoriaAtividadeService.listaCategoriaAtividade();

    }

    @ResponseBody
    @GetMapping("/{id}")
    public CategoriaAtividadeResponse obtemCategoriaAtividade(@RequestParam Long id){

        return categoriaAtividadeService.obtemCategoriaAtividade(id);

    }

    @ResponseBody
    @PutMapping("/{id}")
    public CategoriaAtividadeResponse atualizaCategoriaAtividade(@RequestParam Long id, @RequestBody CategoriaAtividadeRequest categoriaAtividadeRequest){

        return categoriaAtividadeService.atualizaCategoriaAtividade( categoriaAtividadeRequest,id);

    }

   
    @DeleteMapping("/{id}")
    public void excluiCategoriaAtividade(@RequestParam Long id){

         categoriaAtividadeService.excluiCategoriaAtividade(id);

    }


    
}