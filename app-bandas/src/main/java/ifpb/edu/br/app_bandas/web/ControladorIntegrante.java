package ifpb.edu.br.app_bandas.web;

import ifpb.edu.br.app_bandas.domain.Integrante;
import ifpb.edu.br.app_bandas.infra.persistence.IntegranteJDBC;

import javax.enterprise.context.SessionScoped;
import javax.inject.Named;
import java.io.Serializable;
import java.util.List;

@Named
@SessionScoped
public class ControladorIntegrante implements Serializable {
    private Integrante integrante = new Integrante();
    private IntegranteJDBC integrantesJDBC = new IntegranteJDBC();

    public List<Integrante> todos() throws Exception {
        return integrantesJDBC.todos();
    }



    public Integrante getIntegrante() {
        return integrante;
    }

    public void setIntegrante(Integrante integrante) {
        this.integrante = integrante;
    }
}
