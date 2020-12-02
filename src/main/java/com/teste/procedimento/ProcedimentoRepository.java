package com.teste.procedimento;


import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProcedimentoRepository extends CrudRepository<Procedimento, Integer> {

    @Query("select p from Procedimento p where p.cdProcedimento = ?1 and p.idade =?2 and p.sexo =?3 and p.permitido =?4 ")
    Procedimento autorizado(Integer cdProcedimento, Integer idade, String sexo, String permitido);

    @Query("select p from Procedimento p where p.cdProcedimento = ?1 and p.idade =?2 and p.sexo =?3")
    Procedimento autoriza(Integer cdProcedimento, Integer idade, String sexo);
}

