package br.senai.rn.agenda.database.converter;

import androidx.room.TypeConverter;
import br.senai.rn.agenda.model.TipoTelefone;

public class ConversorTipoTelefone {
    @TypeConverter
    public String paraString(TipoTelefone value){return value.name();}

    @TypeConverter
    public TipoTelefone paraTipoTelefone(String value){
        if (value != null){
            return TipoTelefone.valueOf(value);
        }
        return TipoTelefone.FIXO;
    }
}
