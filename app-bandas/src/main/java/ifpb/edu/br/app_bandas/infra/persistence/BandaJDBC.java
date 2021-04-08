package ifpb.edu.br.app_bandas.infra.persistence;

import ifpb.edu.br.app_bandas.domain.Banda;
import ifpb.edu.br.app_bandas.domain.Integrante;

<<<<<<< HEAD
import java.sql.Connection;
import java.sql.SQLException;
=======
import java.sql.PreparedStatement;
import java.sql.ResultSet;
>>>>>>> d8eb9f8c5942386e6868c85aa8c8112434a4a55c
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class BandaJDBC {
    private ConnectionFactory jdcbConnection;

    public BandaJDBC() {
        this.jdcbConnection = new ConnectionFactory();
    }

<<<<<<< HEAD
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
=======
    public void nova(Banda banda) throws Exception {
        this.jdcbConnection.conectar();
        String query = "INSERT INTO banda (localDeOrigem, nomeFantasia)" + "VALUES (?, ?,)";
        try {
            PreparedStatement statement = this.jdcbConnection.getConexao().prepareStatement(query);
            statement.setString(1, banda.getLocalDeOrigem());
            statement.setString(2, banda.getNomeFantasia());
            statement.executeUpdate();
            inserirIntegrantes(banda.getIntegrantes(), banda.getId());
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            this.jdcbConnection.desconectar();
        }
>>>>>>> d8eb9f8c5942386e6868c85aa8c8112434a4a55c

    }
    public void inserirIntegrantes (List<Integrante> integrantes, int bandaId) throws Exception {
        this.jdcbConnection.conectar();
        String query = "INSERT INTO integrante_banda (id_banda, id_integrante)" + "VALUES (?, ?,)";
        integrantes.forEach(integrante -> {
            try {
                PreparedStatement statement = this.jdcbConnection.getConexao().prepareStatement(query);
                statement.setInt(1, integrante.getId());
                statement.setInt(2, bandaId);

                statement.executeUpdate();
            }catch (Exception e){
                e.printStackTrace();
            }
        });
        jdcbConnection.desconectar();
    }

    public List<Banda> buscarTodos() throws Exception {
        this.jdcbConnection.conectar();
        String query = "SELECT * FROM banda";
        PreparedStatement statement = this.jdcbConnection.getConexao().prepareStatement(query);
        ResultSet result = statement.executeQuery();
        List<Banda> bandas = new ArrayList<>();
        Banda banda = null;
        while (result.next()) {
            banda = new Banda();
            banda.setId(result.getInt("id"));
            banda.setLocalDeOrigem(result.getString("localDeOrigem"));
            banda.setNomeFantasia("nomeFantasia");
            bandas.add(banda);
        }
        this.jdcbConnection.desconectar();

        return bandas;
    }
    public void atualizar(Banda banda) throws Exception {
        this.jdcbConnection.conectar();
        String sql = "UPDATE banda SET localDeOrigem = ? , nomeFantasia = ? WHERE id = ?";
        PreparedStatement statement = this.jdcbConnection.getConexao().prepareStatement(sql);
        statement.setString(1, banda.getLocalDeOrigem());
        statement.setString(2, banda.getNomeFantasia());

        statement.setLong(3, banda.getId());

        statement.executeUpdate();

        this.jdcbConnection.desconectar();
    }

    public void excluir(int bandaId) throws Exception {
        this.jdcbConnection.conectar();
        String sql = "DELETE FROM banda WHERE id = ?";
        PreparedStatement statement = this.jdcbConnection.getConexao().prepareStatement(sql);
        statement.setLong(1, bandaId);
        statement.executeUpdate();
        this.jdcbConnection.desconectar();
    }

    public Optional<Object> localizarPorID(int id) throws Exception {

        this.jdcbConnection.conectar();
        String sql = "SELECT * FROM banda WHERE id = ?";
        PreparedStatement statement = this.jdcbConnection.getConexao().prepareStatement(sql);
        statement.setLong(1, id);
        ResultSet result = statement.executeQuery();
        Banda banda = null;
        while (result.next()) {
            banda = new Banda();
            banda.setId(result.getInt("id"));
            banda.setLocalDeOrigem(result.getString("localDeOrigem"));
            banda.setNomeFantasia("nomeFantasia");
        }
        this.jdcbConnection.desconectar();

        return Optional.ofNullable(banda);
    }
}
