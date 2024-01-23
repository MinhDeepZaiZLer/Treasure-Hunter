package DTB;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Vector;
import javax.swing.*;
import java.awt.*;

public class Database extends JFrame {
	private static final String JDBC_URL = "jdbc:sqlserver://LAPTOP-7DJBJC71\\ASUS;databaseName=OOP;integratedSecurity=true";


    public Database() {
        super("Bảng Xếp Hạng");

        Vector<String> columnNames = new Vector<>();
        columnNames.add("Tên");
        columnNames.add("Điểm");

        Vector<Vector<Object>> data = getDataFromDatabase();

        if (data != null) {
            JTable table = new JTable(data, columnNames);
            JScrollPane scrollPane = new JScrollPane(table);

            getContentPane().add(scrollPane, BorderLayout.CENTER);
        } else {
            JOptionPane.showMessageDialog(this, "Không thể lấy dữ liệu từ cơ sở dữ liệu.", "Lỗi", JOptionPane.ERROR_MESSAGE);
        }

        setSize(400, 300);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);  // Hiển thị cửa sổ ở giữa màn hình
    }

    private Vector<Vector<Object>> getDataFromDatabase() {
        Vector<Vector<Object>> data = new Vector<>();

        try {
            Connection connection = DriverManager.getConnection(JDBC_URL);

            String sql = "SELECT name, score FROM BXH ORDER BY score DESC";

            try (PreparedStatement preparedStatement = connection.prepareStatement(sql);
                 ResultSet resultSet = preparedStatement.executeQuery()) {

                while (resultSet.next()) {
                    Vector<Object> row = new Vector<>();
                    row.add(resultSet.getString("name"));
                    row.add(resultSet.getInt("score"));
                    data.add(row);
                }
            }

            connection.close();
        } catch (SQLException e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(this, "Lỗi khi lấy dữ liệu từ cơ sở dữ liệu: " + e.getMessage(), "Lỗi", JOptionPane.ERROR_MESSAGE);
            return null;
        }

        return data;
    }

    public static void main() {
        SwingUtilities.invokeLater(() -> {
        	Database frame = new Database();
            frame.setVisible(true);
        });
    }
}
