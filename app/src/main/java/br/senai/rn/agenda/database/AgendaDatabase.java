package br.senai.rn.agenda.database;

import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;
import androidx.room.TypeConverters;

import android.content.Context;

import br.senai.rn.agenda.database.converter.ConversorCalendar;
import br.senai.rn.agenda.database.converter.ConversorTipoTelefone;
import br.senai.rn.agenda.database.dao.AlunoDAO;
import br.senai.rn.agenda.database.dao.TelefoneDAO;
import br.senai.rn.agenda.model.Aluno;
import br.senai.rn.agenda.model.Telefone;

import static br.senai.rn.agenda.database.AgendaMigrations.TODAS_MIGRATIONS;

@Database(entities = {Aluno.class, Telefone.class}, version = 6, exportSchema = false)
@TypeConverters({ConversorCalendar.class, ConversorTipoTelefone.class})
public abstract class AgendaDatabase extends RoomDatabase {

    private static final String NOME_BANCO_DE_DADOS = "agenda.db";
    public abstract AlunoDAO getAlunoDAO();

    public static AgendaDatabase getInstance(Context context) {
        return Room
                .databaseBuilder(context, AgendaDatabase.class, NOME_BANCO_DE_DADOS)
                .allowMainThreadQueries()
                .addMigrations(TODAS_MIGRATIONS)
                .build();
    }

    public abstract TelefoneDAO getTelefoneDAO();
}
