package br.senai.rn.agenda.asynctask;

import android.os.AsyncTask;
import android.widget.TextView;

import br.senai.rn.agenda.database.dao.TelefoneDAO;
import br.senai.rn.agenda.model.Telefone;

public class BuscaPrimeiroTelefoneDoAluno extends AsyncTask<Void, Void, Telefone> {

    private final TelefoneDAO dao;
    private final TextView campoTelefone;
    private final int alunoId;

    public BuscaPrimeiroTelefoneDoAluno(TelefoneDAO dao, TextView campoTelefone, int alunoId) {
        this.dao = dao;
        this.campoTelefone = campoTelefone;
        this.alunoId = alunoId;
    }

    @Override
    protected Telefone doInBackground(Void... voids) {
        return dao.buscaPrimeiroTelefoneDoAluno(alunoId);
    }

    @Override
    protected void onPostExecute(Telefone telefone) {
        super.onPostExecute(telefone);
        campoTelefone.setText(telefone.getNumero());
    }
}
