package ifpb.edu.br.app_bandas.infra.persistence;

import ifpb.edu.br.app_bandas.domain.Banda;
import ifpb.edu.br.app_bandas.domain.CPF;
import ifpb.edu.br.app_bandas.domain.Integrante;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
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

//    public String test(){
//        try {
//            Connection con = ConnectionFactory.getConnection();
//            return "Deu certo";
//        } catch (ClassNotFoundException e) {
//            e.printStackTrace();
//        } catch (SQLException throwables) {
//            throwables.printStackTrace();
//        }
//        return "falhou";
//    }

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

    }
    public void inserirIntegrantes (List<Integrante> integrantes, int bandaId) throws Exception {
        this.jdcbConnection.conectar();
        String query = "INSERT INTO integrante_banda (id_banda, id_integrante)" + "VALUES (?, ?)";
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
    public List<Integrante> recuperaIntegranes(int idBanda) throws Exception {
        List<Integrante> integrantesBanda = new ArrayList<>();
        Integrante integrante = null;
        this.jdcbConnection.conectar();
        String query = "SELECT i.id, i.nome, i.dataDeNascimento, i.CPF  FROM integrante_banda ib, integrante i WHERE ib.id_integrante = i.id AND ib.id_banda = ?";
        PreparedStatement statement = this.jdcbConnection.getConexao().prepareStatement(query);
        statement.setInt(1, idBanda);
        ResultSet rs = statement.executeQuery();
        while (rs.next()){
            integrante = new Integrante();
            integrante.setId(rs.getInt("id"));
            integrante.setNome(rs.getString("nome"));
            integrante.setCpf(new CPF(rs.getString("CPF")));

            Date nascimento = rs.getDate("dataDeNascimento");
            String data = new SimpleDateFormat("dd/MM/yyyy").format(nascimento);
            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
            LocalDate date = LocalDate.parse(data,formatter);

            integrante.setDataDeNascimento(date);

            integrantesBanda.add(integrante);
        }
        this.jdcbConnection.desconectar();

        return integrantesBanda;
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
            banda.setNomeFantasia(result.getString("nomeFantasia"));
            banda.setIntegrantes(recuperaIntegranes(result.getInt("id")));
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

        statement.setInt(3, banda.getId());

        statement.executeUpdate();

        this.jdcbConnection.desconectar();
    }

    public void excluir(int bandaId) throws Exception {
        this.jdcbConnection.conectar();
        String sql = "DELETE FROM banda WHERE id = ?";
        PreparedStatement statement = this.jdcbConnection.getConexao().prepareStatement(sql);
        statement.setInt(1, bandaId);
        statement.executeUpdate();
        this.jdcbConnection.desconectar();
    }

    public Banda localizarPorID(int id) throws Exception {

        this.jdcbConnection.conectar();
        String sql = "SELECT * FROM banda WHERE id = ?";
        PreparedStatement statement = this.jdcbConnection.getConexao().prepareStatement(sql);
        statement.setInt(1, id);
        ResultSet result = statement.executeQuery();
        Banda banda = null;
        while (result.next()) {
            banda = new Banda();
            banda.setId(result.getInt("id"));
            banda.setLocalDeOrigem(result.getString("localDeOrigem"));
            banda.setNomeFantasia("nomeFantasia");
            banda.setIntegrantes(recuperaIntegranes(result.getInt("id")));
        }
        this.jdcbConnection.desconectar();

        return banda;
    }
    public Banda localizarPorLocalDeOrigem(String localOrigem) throws Exception {

        this.jdcbConnection.conectar();
        String sql = "SELECT * FROM banda WHERE localDeOrigem = ?";
        PreparedStatement statement = this.jdcbConnection.getConexao().prepareStatement(sql);
        statement.setString(1, localOrigem);
        ResultSet result = statement.executeQuery();
        Banda banda = null;
        while (result.next()) {
            banda = new Banda();
            banda.setId(result.getInt("id"));
            banda.setLocalDeOrigem(result.getString("localDeOrigem"));
            banda.setNomeFantasia("nomeFantasia");
            banda.setIntegrantes(recuperaIntegranes(result.getInt("id")));
        }
        this.jdcbConnection.desconectar();

        return banda;
    }
}
