package ifpb.edu.br.app_bandas.infra.persistence;

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

public class IntegranteJDBC {

    //private ConnectionFactory jdcbConnection;

    public IntegranteJDBC() {
        //this.jdcbConnection = new ConnectionFactory();
    }

    public void novo(Integrante integrante) throws Exception {
        /*this.jdcbConnection.conectar();
        String query = "INSERT INTO integrante (nome, dataDeNascimento, CPF)" + "VALUES (?, ?, ?)";
        try {
            PreparedStatement statement = this.jdcbConnection.getConexao().prepareStatement(query);
            statement.setString(1, integrante.getNome());
            statement.setDate(2, java.sql.Date.valueOf(integrante.getDataDeNascimento()));
            statement.setString(3, integrante.getCpf().getNumero());

            statement.executeUpdate();
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            this.jdcbConnection.desconectar();
        }
        */
    }

    public void todos()throws Exception {
        /*this.jdcbConnection.conectar();
        String query = "SELECT * FROM integrante";
        PreparedStatement statement = this.jdcbConnection.getConexao().prepareStatement(query);
        ResultSet result = statement.executeQuery();
        List<Integrante> integrantes = new ArrayList<>();
        Integrante integrante = null;
        while (result.next()) {
            integrante = new Integrante();
            integrante.setId(result.getInt("id"));
            integrante.setNome(result.getString("nome"));
            integrante.setCpf(new CPF(result.getString("CPF")));

            Date nascimento = result.getDate("dataDeNascimento");
            String data = new SimpleDateFormat("dd/MM/yyyy").format(nascimento);
            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
            LocalDate date = LocalDate.parse(data,formatter);

            integrante.setDataDeNascimento(date);

            integrantes.add(integrante);
        }
        this.jdcbConnection.desconectar();

        return integrantes;*/
    }

    public void atualizar(Integrante integrante)throws Exception {
        /*this.jdcbConnection.conectar();
        String sql = "UPDATE integrante SET nome = ? , dataDeNascimento = ? WHERE id = ?";

        PreparedStatement statement = this.jdcbConnection.getConexao().prepareStatement(sql);
        statement.setString(1, integrante.getNome());
        statement.setDate(2, java.sql.Date.valueOf(integrante.getDataDeNascimento()));

        statement.setLong(3, integrante.getId());

        statement.executeUpdate();

        this.jdcbConnection.desconectar();*/
    }

    public void excluir(int integranteId)throws Exception {
        /*this.jdcbConnection.conectar();
        String sql = "DELETE FROM integrante WHERE id = ?";
        PreparedStatement statement = this.jdcbConnection.getConexao().prepareStatement(sql);
        statement.setLong(1, integranteId);
        statement.executeUpdate();
        this.jdcbConnection.desconectar();*/
    }

    public void localizarPorID(int integranteId) throws Exception {

        /*this.jdcbConnection.conectar();
        String sql = "SELECT * FROM integrante WHERE id = ?";
        PreparedStatement statement = this.jdcbConnection.getConexao().prepareStatement(sql);
        statement.setLong(1, integranteId);
        ResultSet result = statement.executeQuery();
        Integrante integrante = null;
        while (result.next()) {
            integrante = new Integrante();
            integrante.setId(result.getInt("id"));
            integrante.setNome(result.getString("nome"));
            integrante.setCpf(new CPF(result.getString("CPF")));

            Date nascimento = result.getDate("dataDeNascimento");
            String data = new SimpleDateFormat("dd/MM/yyyy").format(nascimento);
            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
            LocalDate date = LocalDate.parse(data,formatter);

            integrante.setDataDeNascimento(date);
        }
        this.jdcbConnection.desconectar();

        return Optional.ofNullable(integrante);*/
    }

}
