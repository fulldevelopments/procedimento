package com.teste.procedimento;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
public class ProcedimentoController {

    @Autowired
    private ProcedimentoRepository repo;

    public ProcedimentoController(ProcedimentoRepository repo) {
        this.repo = repo;

        if (!repo.findAll().iterator().hasNext()) {
            Procedimento p1 = new Procedimento(1234, 10, "M", "SIM");
            repo.save(p1);
            Procedimento p2 = new Procedimento(4567, 20, "M", "SIM");
            repo.save(p2);
            Procedimento p3 = new Procedimento(6788, 10, "F", "SIM");
            repo.save(p3);
            Procedimento p4 = new Procedimento(6789, 10, "M", "SIM");
            repo.save(p4);
            Procedimento p5 = new Procedimento(1235, 20, "M", "SIM");
            repo.save(p5);
            Procedimento p6 = new Procedimento(4568, 30, "F", "SIM");
            repo.save(p6);
        }
    }

    @GetMapping("/procedimentos")
    public Iterable<Procedimento> list() {
        return repo.findAll();
    }

    @PostMapping("/cadastro")
    public String cadastro(@Valid @RequestBody Procedimento procedimento) {
        repo.save(procedimento);
        return "Procedimento Adicionado!";
    }

    @RequestMapping(value = "autorizador/cadastro/procedimento/{cdProcedimento}/idade/{idade}/sexo/{sexo}")
    public ResponseEntity<String> autoriza(
            @PathVariable("cdProcedimento") Integer cdProcedimento,
            @PathVariable("idade") Integer idade,
            @PathVariable("sexo") String sexo) {

        Procedimento procedimentoReponse = repo.autoriza(cdProcedimento, idade, sexo);

        if (procedimentoReponse == null) {
            return new ResponseEntity<>("Procedimento não encontrado!", HttpStatus.NOT_FOUND);
        }

        return new ResponseEntity<>(procedimentoReponse.getPermitido(), HttpStatus.OK);
    }

    @RequestMapping(value = "autorizador/cadastro/procedimento/{cdProcedimento}/idade/{idade}/sexo/{sexo}/autoriza/{autoriza}")
    public ResponseEntity<Procedimento> permissao(
            @PathVariable("cdProcedimento") Integer cdProcedimento,
            @PathVariable("idade") Integer idade,
            @PathVariable("sexo") String sexo,
            @PathVariable("autoriza") String autoriza) {

        Procedimento procedimentoReponse = repo.autorizado(cdProcedimento, idade, sexo, autoriza);

        if (procedimentoReponse == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }

        return new ResponseEntity<>(procedimentoReponse, HttpStatus.OK);

    }
}

