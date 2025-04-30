import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class StudentDAO {

    // Insert a student into the database
    public static void addStudent(String name, int age, String course) {
        String sql = "INSERT INTO students (name, age, course) VALUES (?, ?, ?)";
        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setString(1, name);
            stmt.setInt(2, age);
            stmt.setString(3, course);
            stmt.executeUpdate();
            System.out.println("✅ Student added successfully!");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    // Display all students
    public static void getAllStudents() {
        String sql = "SELECT * FROM students";
        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql);
             ResultSet rs = stmt.executeQuery()) {
            while (rs.next()) {
                System.out.println("ID: " + rs.getInt("id") +
                        ", Name: " + rs.getString("name") +
                        ", Age: " + rs.getInt("age") +
                        ", Course: " + rs.getString("course"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    // Update a student's record
    public static void updateStudent(int id, String name, int age, String course) {
        String sql = "UPDATE students SET name=?, age=?, course=? WHERE id=?";
        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setString(1, name);
            stmt.setInt(2, age);
            stmt.setString(3, course);
            stmt.setInt(4, id);
            stmt.executeUpdate();
            System.out.println("✅ Student updated successfully!");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    // Delete a student from the database
    public static void deleteStudent(int id) {
        String sql = "DELETE FROM students WHERE id=?";
        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setInt(1, id);
            stmt.executeUpdate();
            System.out.println("✅ Student deleted successfully!");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
