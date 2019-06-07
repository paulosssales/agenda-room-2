package br.senai.rn.agenda.asynctask;

import android.os.AsyncTask;

import java.util.List;

import br.senai.rn.agenda.database.dao.TelefoneDAO;
import br.senai.rn.agenda.model.Aluno;
import br.senai.rn.agenda.model.Telefone;

public class BuscaTodosTelefonesDoAlunoTask extends AsyncTask<Void, Void, List<Telefone>> {

private final TelefoneDAO telefoneDAO;
private final Aluno aluno;
private final TelefonesDoAlunoEncontradosListener listener;

public BuscaTodosTelefonesDoAlunoTask(TelefoneDAO telefoneDAO,
        Aluno aluno,
        TelefonesDoAlunoEncontradosListener listener) {
        this.telefoneDAO = telefoneDAO;
        this.aluno = aluno;
        this.listener = listener;
        }

@Override
protected List<Telefone> doInBackground(Void... voids) {
        return telefoneDAO
        .buscaTodosTelefonesDoAluno(aluno.getId());
        }

@Override
protected void onPostExecute(List<Telefone> telefones) {
        super.onPostExecute(telefones);
        listener.quandoEncontrados(telefones);
        }

public interface TelefonesDoAlunoEncontradosListener {
    void quandoEncontrados(List<Telefone> telefones);
}
}
