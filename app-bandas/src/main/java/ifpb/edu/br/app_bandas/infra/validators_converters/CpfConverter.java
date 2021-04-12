package ifpb.edu.br.app_bandas.infra.validators_converters;

import ifpb.edu.br.app_bandas.domain.CPF;

import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;

@FacesConverter(value = "cpf.converter")
public class CpfConverter implements Converter {
    @Override
    public Object getAsObject(FacesContext facesContext, UIComponent uiComponent, String s) {
        if(s == null){
            return null;
        }
        CPF cpf = new CPF(s);
        return cpf;
    }

    @Override
    public String getAsString(FacesContext facesContext, UIComponent uiComponent, Object o) {
        if(o == null){
            return null;
        }
        CPF cpf = (CPF) o;
        return cpf.cpfFormatado();
    }
}
