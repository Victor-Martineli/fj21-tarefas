package edu.undf.fj21tarefas.controller;

import edu.undf.fj21tarefas.model.Tarefa;
import edu.undf.fj21tarefas.repository.TarefaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.time.LocalDate;
import java.util.Random;

@Controller
public class TarefaController {

    @Autowired
    private TarefaRepository tarefaRepository;


    @RequestMapping("/teste")
    public String teste(Model model){
        Tarefa tarefa = new Tarefa();
        tarefa.setDescricao("tarefa numero "+ new Random().nextInt());
        tarefa.setFinalizado(false);
        tarefa.setDataFinalizacao(LocalDate.now());


        tarefaRepository.save(tarefa);

        model.addAttribute("tarefas", tarefaRepository.findAll());
        return "tarefas";
    }

}
