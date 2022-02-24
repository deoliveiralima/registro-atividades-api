package io.projetos.deoliveiralimaigor.registroatividadesapi.controller;

import java.net.URI;
import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
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
@CrossOrigin("http://localhost:3000")
public class CategoriaAtividadeController {

    @Autowired
    private CategoriaAtividadeService categoriaAtividadeService;

    // @PostMapping
    // @ResponseBody
    // public CategoriaAtividadeResponse salvaCategoriaAtividade(@RequestBody CategoriaAtividadeRequest categoriaAtividadeRequest){

    //     return categoriaAtividadeService.salvaCategoriaAtividade(categoriaAtividadeRequest);

    // }

    @PostMapping
    @ResponseBody
    @CrossOrigin("http://localhost:3000")
    public ResponseEntity<CategoriaAtividadeResponse> salvaCategoriaAtividade(@RequestBody CategoriaAtividadeRequest categoriaAtividadeRequest){
        CategoriaAtividadeResponse categoriaAtividadeResponse = new CategoriaAtividadeResponse();
        
        categoriaAtividadeResponse = categoriaAtividadeService.salvaCategoriaAtividade(categoriaAtividadeRequest);
 
       return ResponseEntity.status(HttpStatus.CREATED).body(categoriaAtividadeResponse);

    }


    @ResponseBody
    @GetMapping
    public List<CategoriaAtividadeResponse> listaCategoriaAtividade(){
        System.out.println("obter lista");
        return  categoriaAtividadeService.listaCategoriaAtividade();

    }

    @ResponseBody
    @GetMapping("/{id}")
    public CategoriaAtividadeResponse obtemCategoriaAtividade(@PathVariable Long id){

        System.out.println(5);
        return null;
        // return categoriaAtividadeService.obtemCategoriaAtividade(id);

    }

    @ResponseBody
    @PutMapping("/{id}")
    public CategoriaAtividadeResponse atualizaCategoriaAtividade(@PathVariable Long id, @RequestBody CategoriaAtividadeRequest categoriaAtividadeRequest){

        return categoriaAtividadeService.atualizaCategoriaAtividade( categoriaAtividadeRequest,id);

    }

   
    @DeleteMapping("/{id}")
    public void excluiCategoriaAtividade(@PathVariable Long id){

         categoriaAtividadeService.excluiCategoriaAtividade(id);

    }


    
}
