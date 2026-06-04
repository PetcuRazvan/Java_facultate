import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class ExercitiiStudenti {

    private static final String url = "jdbc:sqlite:date\\studenti.db";
    public static void main(String[] args) {
        try {
            //initializareTabela(url); nuuuu apelaaaa

            Scanner scanner = new Scanner(System.in);

            System.out.println("--- Exercițiul 2: Inserare ---");
            List<Student> studentiNoi = List.of(
                    new Student(1, "Popescu Ion"),
                    new Student(2, "Ionescu Maria"),
                    new Student(3, "Vasilescu Andrei"));
            inserareStudenti(studentiNoi);

//            System.out.println("--- Exercițiul 3: Filtrare ---");
//            String filtru = scanner.nextLine();
//
//            List<Student> studentiFiltrati = filtrareSTudenti(filtru);
//            for (var student : studentiFiltrati) {
//                System.out.println(student);
//            }

//            System.out.println("--- Exercițiul 4: Update ---");
//            System.out.printf("au fost afectate %d randuri\n", updateCod());

            System.out.println("--- Exercițiul 5: Stergere ---");
            int valoare = scanner.nextInt();
            System.out.printf("Au fost stersi %d studenti", stergeCodMic(valoare));

        } catch(SQLException e) {
            e.printStackTrace();
        }
    }

    private static void initializareTabela(String url) throws SQLException {
        try (Connection connection = DriverManager.getConnection(url);
                Statement statement = connection.createStatement()) {

            statement.execute("DROP TABLE IF EXISTS STUDENTI");
            statement.execute("CREATE TABLE STUDENTI (COD INTEGER, NUME TEXT)");
        }
    }

    private static void inserareStudenti(List<Student> studenti) throws SQLException {
        String sql = "INSERT INTO STUDENTI(COD, NUME) VALUES (?, ?)";

        try (Connection connection = DriverManager.getConnection(url); PreparedStatement statement = connection.prepareStatement(sql)) {
            for (var student : studenti) {
                statement.setInt(1, student.getCod());
                statement.setString(2, student.getNume());
                statement.executeUpdate();
            }

            System.out.println("Bismilah");
        }
    }

    private static List<Student> filtrareSTudenti(String filtru) throws SQLException {
        String sql = "SELECT * FROM STUDENTI WHERE NUME LIKE ?";

        try (Connection connection = DriverManager.getConnection(url); PreparedStatement statement = connection.prepareStatement(sql)) {
            statement.setString(1, filtru + "%");

            try (ResultSet result = statement.executeQuery()) {
                List<Student> studenti = new ArrayList<>();

                while (result.next()) {
                    studenti.add(new Student(result.getInt("COD"), result.getString("NUME")));
                }

                return studenti;
            }
        }
    }

    private static int updateCod() throws SQLException {
        String sql = "UPDATE STUDENTI SET COD = COD + 100";

        try (Connection connection = DriverManager.getConnection(url); Statement statement = connection.createStatement()) {
            int nr = statement.executeUpdate(sql);

            return nr;
        }
    }

    private static int stergeCodMic(int valoare) throws SQLException {
        String sql = "DELETE FROM STUDENTI WHERE COD < ?";

        try (Connection connection = DriverManager.getConnection(url); PreparedStatement statement = connection.prepareStatement(sql)) {
            statement.setInt(1, valoare);

            return statement.executeUpdate();
        }
    }
}
