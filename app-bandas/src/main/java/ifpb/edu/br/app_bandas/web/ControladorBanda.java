package ifpb.edu.br.app_bandas.web;

import ifpb.edu.br.app_bandas.domain.Banda;
import ifpb.edu.br.app_bandas.domain.Integrante;
import ifpb.edu.br.app_bandas.infra.persistence.BandaJDBC;

import javax.enterprise.context.SessionScoped;
import javax.inject.Named;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@Named
@SessionScoped
public class ControladorBanda implements Serializable {
    private Banda banda = new Banda();
    private List <Banda> bandas = new ArrayList<>();
    private BandaJDBC bandaJDBC = new BandaJDBC();
    private String retorno = "";

//    public String test(){
//        retorno = bandaJDBC.test();
//        return null;
//    }

//    public String addIntegrante(Integrante integrante){
//        this.banda.getIntegrantes().add(integrante);
//        System.out.println(banda.getIntegrantes());
//        return retorno;
//    }
//    public List<Integrante> tdsIntegrantes(){
//        return banda.getIntegrantes();
//    }

    public String salvar() throws Exception {
            this.bandaJDBC.nova(banda);
            banda = new Banda();
            return retorno;
    }
    public String localizaPorId(Banda band) throws Exception {
        banda = bandaJDBC.localizarPorID(banda.getId());

        return retorno;
    }
    public String localizaPorLocalDeOrigem(String localDeOrigem) throws Exception {
        banda = bandaJDBC.localizarPorLocalDeOrigem(localDeOrigem);

        return retorno;
    }
    public List<Banda> todas() throws Exception {
        return bandaJDBC.buscarTodos();
    }
    public String editar(Banda band) throws Exception {
        this.banda = band;

        return "edit";
    }
    public String remover(Banda band) throws Exception {
        bandaJDBC.excluir(band.getId());

        return retorno;
    }


    public Banda getBanda() {
        return banda;
    }

    public void setBanda(Banda banda) {
        this.banda = banda;
    }
    public List<Banda> getBandas() {
        return bandas;
    }

    public void setBandas(List<Banda> bandas) {
        this.bandas = bandas;
    }
}
