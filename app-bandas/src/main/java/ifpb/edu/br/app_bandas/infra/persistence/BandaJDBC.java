package ifpb.edu.br.app_bandas.infra.persistence;

import ifpb.edu.br.app_bandas.domain.Banda;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.text.SimpleDateFormat;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Optional;

public class BandaJDBC {
    private ConnectionFactory jdcbConnection;

    public BandaJDBC() {
        this.jdcbConnection = new ConnectionFactory();
    }

    public void nova(Banda banda) throws Exception {
        this.jdcbConnection.conectar();
        String query = "INSERT INTO banda (localDeOrigem, nomeFantasia)" + "VALUES (?, ?,)";
        try {
            PreparedStatement statement = this.jdcbConnection.getConexao().prepareStatement(query);
            statement.setString(1, banda.getLocalDeOrigem());
            statement.setString(2, banda.getNomeFantasia());

            statement.executeUpdate();
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            this.jdcbConnection.desconectar();
        }

    }

    public List<Banda> buscarTodos() throws Exception {
        this.jdcbConnection.conectar();
        String query = "SELECT * FROM usuario";
        PreparedStatement statement = this.jdcbConnection.getConexao().prepareStatement(query);
        ResultSet result = statement.executeQuery();
        List<Banda> users = new ArrayList<>();
        while (result.next()) {
            Banda banda = new Banda();
            banda.setId(result.getInt("id"));
            banda.setLocalDeOrigem(result.getString("localDeOrigem"));
            banda.setNomeFantasia("nomeFantasia");
            users.add(banda);
        }
        this.jdcbConnection.desconectar();

        return users;
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
