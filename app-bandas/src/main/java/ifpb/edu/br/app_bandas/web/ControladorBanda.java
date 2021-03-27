package ifpb.edu.br.app_bandas.web;

import ifpb.edu.br.app_bandas.domain.Banda;
import ifpb.edu.br.app_bandas.domain.Integrante;
import ifpb.edu.br.app_bandas.infra.persistence.BandaJDBC;

import javax.enterprise.context.SessionScoped;
import javax.inject.Named;
import java.io.Serializable;

@Named
@SessionScoped
public class ControladorBanda implements Serializable {
    private Banda banda = new Banda();
    private BandaJDBC bandaJDBC = new BandaJDBC();
}