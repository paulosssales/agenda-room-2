package br.senai.rn.agenda.database.converter;

import androidx.room.TypeConverter;
import br.senai.rn.agenda.model.TipoTelefone;

public class ConversorTipoTelefone {
    @TypeConverter
    public String paraString(TipoTelefone value){
        if (value != null) return String.valueOf(value);
        return null;
    }

    @TypeConverter
    public TipoTelefone paraTipoTelefone(TipoTelefone tipoTelefone){
        if (tipoTelefone.CELULAR != null){
            return tipoTelefone;
        }
        return TipoTelefone.FIXO;
    }
}
