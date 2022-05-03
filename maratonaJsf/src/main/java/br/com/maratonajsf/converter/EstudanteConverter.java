package br.com.maratonajsf.converter;

import br.com.maratonajsf.model.Estudante;
import java.util.List;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;

@FacesConverter(value="estudanteConverter")
public class EstudanteConverter implements Converter {

    List<Estudante> estudanteList = Estudante.estudanteList();

    @Override
    public Object getAsObject(FacesContext facesContext, UIComponent uIComponent, String value) {
        if (value == null || !value.matches("\\d+")) {
            return null;
        }
        Estudante estudante = new Estudante();
        estudante.setId(Integer.parseInt(value));
        int index = estudanteList.indexOf(estudante);
        return estudanteList.get(index);
    }

    @Override
    public String getAsString(FacesContext facesContext, UIComponent uIComponent, Object value) {
        if(value != null && !value.equals("")){
            Estudante estudante = (Estudante) value;
            if(estudante.getId() != null){
            return estudante.getId().toString();    
            }
        }
        return null;
    }

}
