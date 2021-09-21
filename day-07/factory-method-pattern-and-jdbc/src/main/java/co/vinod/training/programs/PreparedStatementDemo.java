package co.vinod.training.programs;

import co.vinod.training.utils.DbUtil;
import co.vinod.training.utils.KeyboardUtil;
import lombok.extern.slf4j.Slf4j;

import java.sql.Connection;
import java.sql.PreparedStatement;

@Slf4j
public class PreparedStatementDemo {

    public static void main(String[] args) {
        String sql = "insert into products values (?, ?, ?)";
        String choice;
        int id;
        String name;
        double price;

        try (
                Connection conn = DbUtil.createConnection();
                PreparedStatement stmt = conn.prepareStatement(sql); // first visit to db server for compiling sql command
        ) {
            do {
                try {
                    id = KeyboardUtil.getInt("Enter id    : ");
                    name = KeyboardUtil.getString("Enter name  : ");
                    price = KeyboardUtil.getDouble("Enter price : ");

                    stmt.setInt(1, id);
                    stmt.setString(2, name);
                    stmt.setDouble(3, price);

                    stmt.execute(); // visit to db server carrying the values to be assigned to the precompiled sql command
                    log.debug("New product added with id={}, name={}, price={}", id, name, price);
                } catch (Exception e) {
                    log.warn("There wan error - {}", e.getMessage() );
                }

                choice = KeyboardUtil.getString("Want to add another (yes/no): [yes]");
                if (choice.trim().equals("")) {
                    choice = "yes";
                }

            } while (choice.equalsIgnoreCase("yes"));
        } catch (Exception e) {
            log.debug("There was an error - {}", e.getMessage());
        }
    }
}
