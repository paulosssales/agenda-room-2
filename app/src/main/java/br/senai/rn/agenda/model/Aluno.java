package br.senai.rn.agenda.model;

import androidx.room.Entity;
import androidx.room.ForeignKey;
import androidx.room.PrimaryKey;
import androidx.annotation.NonNull;

import java.io.Serializable;
import java.util.Calendar;

import static androidx.room.ForeignKey.CASCADE;

@Entity
public class Aluno implements Serializable {

    @PrimaryKey(autoGenerate = true)
    private int id = 0;
    private String nome;
    //    private String telefoneFixo;
//    private String telefoneCelular;
    private String email;
    private Calendar momentoDeCadastro = Calendar.getInstance();

    public Calendar getMomentoDeCadastro() {
        return momentoDeCadastro;
    }

    public void setMomentoDeCadastro(Calendar momentoDeCadastro) {
        this.momentoDeCadastro = momentoDeCadastro;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

//    public void setTelefoneFixo(String telefoneFixo) {
//        this.telefoneFixo = telefoneFixo;
//    }
//
//    public void setTelefoneCelular(String telefoneCelular) { this.telefoneCelular = telefoneCelular; }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getNome() {
        return nome;
    }

//    public String getTelefoneFixo() {
//        return telefoneFixo;
//    }
//
//    public String getTelefoneCelular() { return telefoneCelular; }

    public String getEmail() {
        return email;
    }

    @NonNull
    @Override
    public String toString() {
        return nome;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getId() {
        return id;
    }

    public boolean temIdValido() {
        return id > 0;
    }

}