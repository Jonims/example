package com.projeto.projetorestaurante.controller;

import com.projeto.projetorestaurante.model.ReservaModel;
import com.projeto.projetorestaurante.repository.ReservasRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class GreetingsController {

    @Autowired// injeção de dependências
    private ReservasRepository reservasRepository;
    @RequestMapping(value = "/{name}", method = RequestMethod.GET)
    @ResponseStatus(HttpStatus.OK)
    public String greetingController(@PathVariable String name){
        return "Hello " + name + "!";
    }
    @GetMapping(value = "/mostrarnome/{nome}")
    @ResponseStatus(HttpStatus.OK)
    public String mostrarNome(@PathVariable String nome){
        return "Ola " + nome;
    }
    @RequestMapping(value = "/reserva/{cliente}", method = RequestMethod.GET) // end point para salvar/cadastrar
    @ResponseStatus(HttpStatus.OK)
    public String salvar(@PathVariable String cliente){

        ReservaModel reserva = new ReservaModel();
        reserva.setNome(cliente);
        reservasRepository.save(reserva); // grava informações do cliente no banco de dados

        return "Reserva " + cliente + " registrado com sucesso!";
    }

    @GetMapping(value = "/reservas")
    @ResponseBody // retorna os dados no corpo da resposta
    public ResponseEntity<List<ReservaModel>> listarReservas(){

        List<ReservaModel> reservas =  reservasRepository.findAll(); // consulta no banco de dados todas as reservas

        return new ResponseEntity<List<ReservaModel>>(reservas, HttpStatus.OK); // retorna a lista em json

    }

    @PostMapping(value = "/reserva/salvar") // mapeia a url
    @ResponseBody // Descreve a resposta informando que o retorno será no corpo da requisição
    public ResponseEntity<ReservaModel> salvar(@RequestBody ReservaModel reserva){ // recebe os dados para salvar

        ReservaModel res =  reservasRepository.save(reserva);
        return new ResponseEntity<ReservaModel>(res, HttpStatus.CREATED);

    }

    @PutMapping(value = "/reserva/atualizar")
    public ResponseEntity<ReservaModel> atualizar(@RequestBody ReservaModel reserva){

        ReservaModel res = reservasRepository.save(reserva);
        return new ResponseEntity<ReservaModel>(res, HttpStatus.OK);
    }

    @DeleteMapping(value = "/reserva/deletar") // mapeia a url
    @ResponseBody // Descrição da resposta
    public ResponseEntity<String> deletar(@RequestParam Long id){ // Recebe da requisição o parâmetro

        reservasRepository.deleteById(id);

        return new ResponseEntity<String>("Reserva excluída com sucesso!", HttpStatus.OK);
    }

}
