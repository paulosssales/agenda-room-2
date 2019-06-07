package br.senai.rn.agenda.asynctask;

import android.os.AsyncTask;

import java.util.List;

import br.senai.rn.agenda.database.dao.AlunoDAO;
import br.senai.rn.agenda.model.Aluno;
import br.senai.rn.agenda.ui.adapter.ListaAlunosAdapter;

public class BuscaAlunoTask extends AsyncTask<Void, Void,List<Aluno>> {
    private final AlunoDAO dao;
    private final ListaAlunosAdapter adapter;

    public BuscaAlunoTask(AlunoDAO dao, ListaAlunosAdapter adapter) {
        this.dao = dao;
        this.adapter = adapter;
    }

    @Override
    protected List<Aluno> doInBackground(Void... objects) {
        List<Aluno> todosAlunos = dao.todos();
        return todosAlunos;
    }

    @Override
    protected void onPostExecute(List<Aluno> todosAlunos) {
        super.onPostExecute(todosAlunos);
        adapter.atualiza(todosAlunos);
    }
}
