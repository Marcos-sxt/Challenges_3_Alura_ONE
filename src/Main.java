import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Main {
    public static void main(String[] args) {
        
        try (Connection conexao = DriverManager.getConnection("jdbc:mysql://localhost:3306/db_hotel_alura", "root", "root")) {

            
            Reserva reserva = new Reserva(Date.valueOf("2023-10-01"), Date.valueOf("2023-10-05"), 200.0, "Cartão de Crédito");
            Hospede hospede = new Hospede("João", "Silva", Date.valueOf("1990-05-15"), "Brasileiro", "123456789");

            
            DatabaseManager dbManager = new DatabaseManager();
            dbManager.adicionarReserva(reserva);
            dbManager.adicionarHospede(hospede);

            
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
