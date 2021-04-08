package ifpb.edu.br.app_bandas.infra.persistence;

import ifpb.edu.br.app_bandas.domain.Banda;
import ifpb.edu.br.app_bandas.domain.Integrante;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class BandaJDBC {

    public BandaJDBC() {
    }

    public String test(){
        try {
            Connection con = ConnectionFactory.getConnection();
            return "Deu certo";
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return "falhou";
    }

    public void nova(Banda banda){

    }

    public List<Banda> todas(){
        return new ArrayList<Banda>();
    }

    public void atualizar(Banda banda){

    }

    public void excluir(Banda banda){

    }

    public Banda localizarPorID(int id){
        return new Banda();
    }
}
