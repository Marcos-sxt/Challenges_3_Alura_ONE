import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class DatabaseManager {
    private static final String URL = "jdbc:mysql://localhost:3306/db_hotel_alura";
    private static final String USUARIO = "root";
    private static final String SENHA = "root";

    
    public void adicionarReserva(Reserva reserva) {
        try (Connection conexao = DriverManager.getConnection(URL, USUARIO, SENHA)) {
            String sql = "INSERT INTO Reservas (DataEntrada, DataSaida, Valor, FormaPagamento) VALUES (?, ?, ?, ?)";
            PreparedStatement stmt = conexao.prepareStatement(sql);
            stmt.setDate(1, reserva.getDataEntrada());
            stmt.setDate(2, reserva.getDataSaida());
            stmt.setDouble(3, reserva.getValor());
            stmt.setString(4, reserva.getFormaPagamento());
            stmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    
    public void adicionarHospede(Hospede hospede) {
        try (Connection conexao = DriverManager.getConnection(URL, USUARIO, SENHA)) {
            String sql = "INSERT INTO Hospedes (Nome, Sobrenome, DataNascimento, Nacionalidade, Telefone) VALUES (?, ?, ?, ?, ?)";
            PreparedStatement stmt = conexao.prepareStatement(sql);
            stmt.setString(1, hospede.getNome());
            stmt.setString(2, hospede.getSobrenome());
            stmt.setDate(3, hospede.getDataNascimento());
            stmt.setString(4, hospede.getNacionalidade());
            stmt.setString(5, hospede.getTelefone());
            stmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    
}
