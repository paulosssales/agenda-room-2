package br.senai.rn.agenda.asynctask;

import android.os.AsyncTask;

import br.senai.rn.agenda.database.dao.AlunoDAO;
import br.senai.rn.agenda.model.Aluno;
import br.senai.rn.agenda.ui.adapter.ListaAlunosAdapter;

public class RemoveAlunoTask extends AsyncTask<Void,Void,Void> {

    private AlunoDAO dao;
    private ListaAlunosAdapter adapter;
    private Aluno aluno;


    public RemoveAlunoTask(AlunoDAO dao,
                           ListaAlunosAdapter adapter,
                           Aluno aluno) {
        this.dao = dao;
        this.adapter = adapter;
        this.aluno = aluno;
    }

    @Override
    protected Void doInBackground(Void... voids) {
        dao.remove(aluno);
        return null;
    }

    @Override
    protected void onPostExecute(Void aVoid) {
        super.onPostExecute(aVoid);
        adapter.remove(aluno);
    }
}
