package br.senai.rn.agenda.database.dao;

import androidx.room.Dao;
import androidx.room.Query;
import br.senai.rn.agenda.model.Telefone;

@Dao
public interface TelefoneDAO {
    @Query("SELECT * FROM Telefone t " +
            "JOIN Aluno a" +
            " ON t.alunoId = a.id " +
            "WHERE t.alunoId = :alunoId LIMIT 1")
    Telefone buscaPrimeiroTelefoneDoAluno(int alunoId);
}
