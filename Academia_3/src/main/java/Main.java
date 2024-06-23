import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

public class Main {

    private static final String URL = "jdbc:sqlite:academia.db";

    public static void main(String[] args) {
        
        try (Connection conn = DriverManager.getConnection(URL)) {
            System.out.println("Conexão com SQLite estabelecida.");

            
            criarTabela(conn);

            
            exibirMenu(conn);

        } catch (SQLException e) {
            System.out.println("Erro ao conectar ao banco de dados SQLite: " + e.getMessage());
        }
    }

    
    private static void criarTabela(Connection conn) throws SQLException {
        String sql = "CREATE TABLE IF NOT EXISTS pessoa (" +
                     "id INTEGER PRIMARY KEY AUTOINCREMENT," +
                     "nome TEXT NOT NULL," +
                     "idade INTEGER NOT NULL," +
                     "genero TEXT NOT NULL)";

        try (PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.executeUpdate();
        }
    }

    
    private static void exibirMenu(Connection conn) {
        Scanner scanner = new Scanner(System.in);
        int opcao;

        do {
            System.out.println("\nSelecione a opção desejada:");
            System.out.println("1 - Cadastrar Pessoa");
            System.out.println("2 - Consultar Pessoas");
            System.out.println("3 - Atualizar Pessoa");
            System.out.println("4 - Excluir Pessoa");
            System.out.println("0 - Sair");

            opcao = scanner.nextInt();
            scanner.nextLine();

            switch (opcao) {
                case 1:
                    cadastrarPessoa(conn, scanner);
                    break;
                case 2:
                    consultarPessoas(conn);
                    break;
                case 3:
                    atualizarPessoa(conn, scanner);
                    break;
                case 4:
                    excluirPessoa(conn, scanner);
                    break;
                case 0:
                    System.out.println("Saindo...");
                    break;
                default:
                    System.out.println("Opção inválida. Por favor, escolha uma opção válida.");
            }
        } while (opcao != 0);

        scanner.close();
    }

    
    private static void cadastrarPessoa(Connection conn, Scanner scanner) {
        try {
            System.out.println("Digite o nome da pessoa:");
            String nome = scanner.nextLine();
            System.out.println("Digite a idade da pessoa:");
            int idade = scanner.nextInt();
            scanner.nextLine(); 
            System.out.println("Digite o gênero da pessoa (M/F):");
            String genero = scanner.nextLine().toUpperCase();

            
            String sql = "INSERT INTO pessoa (nome, idade, genero) VALUES (?, ?, ?)";
            try (PreparedStatement stmt = conn.prepareStatement(sql)) {
                stmt.setString(1, nome);
                stmt.setInt(2, idade);
                stmt.setString(3, genero);
                stmt.executeUpdate();
                System.out.println("Pessoa cadastrada com sucesso!");
            }
        } catch (SQLException e) {
            System.out.println("Erro ao cadastrar pessoa: " + e.getMessage());
        }
    }

    
    private static void consultarPessoas(Connection conn) {
        try {
            String sql = "SELECT * FROM pessoa";
            try (PreparedStatement stmt = conn.prepareStatement(sql);
                 ResultSet rs = stmt.executeQuery()) {

                while (rs.next()) {
                    int id = rs.getInt("id");
                    String nome = rs.getString("nome");
                    int idade = rs.getInt("idade");
                    String genero = rs.getString("genero");

                    System.out.printf("ID: %d, Nome: %s, Idade: %d, Gênero: %s\n", id, nome, idade, genero);
                }
            }
        } catch (SQLException e) {
            System.out.println("Erro ao consultar pessoas: " + e.getMessage());
        }
    }

    
    private static void atualizarPessoa(Connection conn, Scanner scanner) {
        try {
            System.out.println("Digite o ID da pessoa que deseja atualizar:");
            int id = scanner.nextInt();
            scanner.nextLine(); 

            System.out.println("Digite o novo nome da pessoa:");
            String nome = scanner.nextLine();
            System.out.println("Digite a nova idade da pessoa:");
            int idade = scanner.nextInt();
            scanner.nextLine(); 
            System.out.println("Digite o novo gênero da pessoa (M/F):");
            String genero = scanner.nextLine().toUpperCase();

            
            String sql = "UPDATE pessoa SET nome = ?, idade = ?, genero = ? WHERE id = ?";
            try (PreparedStatement stmt = conn.prepareStatement(sql)) {
                stmt.setString(1, nome);
                stmt.setInt(2, idade);
                stmt.setString(3, genero);
                stmt.setInt(4, id);
                int rowsUpdated = stmt.executeUpdate();
                if (rowsUpdated > 0) {
                    System.out.println("Pessoa atualizada com sucesso!");
                } else {
                    System.out.println("Nenhuma pessoa encontrada com o ID informado.");
                }
            }
        } catch (SQLException e) {
            System.out.println("Erro ao atualizar pessoa: " + e.getMessage());
        }
    }

    
    private static void excluirPessoa(Connection conn, Scanner scanner) {
        try {
            System.out.println("Digite o ID da pessoa que deseja excluir:");
            int id = scanner.nextInt();
            scanner.nextLine(); 

            
            String sql = "DELETE FROM pessoa WHERE id = ?";
            try (PreparedStatement stmt = conn.prepareStatement(sql)) {
                stmt.setInt(1, id);
                int rowsDeleted = stmt.executeUpdate();
                if (rowsDeleted > 0) {
                    System.out.println("Pessoa excluída com sucesso!");
                } else {
                    System.out.println("Nenhuma pessoa encontrada com o ID informado.");
                }
            }
        } catch (SQLException e) {
            System.out.println("Erro ao excluir pessoa: " + e.getMessage());
        }
    }
}
