package co.vinod.training.programs;

import co.vinod.training.utils.DbUtil;
import co.vinod.training.utils.KeyboardUtil;
import lombok.extern.slf4j.Slf4j;

import java.sql.Connection;
import java.sql.Statement;

@Slf4j
public class AddProductRecords {

    public static void main(String[] args) {
        String choice;
        int id;
        String name;
        double price;

        try (Connection conn = DbUtil.createConnection();
             Statement stmt = conn.createStatement();) {

            do {
                try {
                    id = KeyboardUtil.getInt("Enter id    : ");
                    name = KeyboardUtil.getString("Enter name  : ");
                    price = KeyboardUtil.getDouble("Enter price : ");

                    String sql = String.format("insert into products values (%d, '%s', %f)", id, name, price);

                    stmt.execute(sql);
                } catch (Exception e) {
                    log.warn("There wan error - {}", e.getMessage() );
                }

                choice = KeyboardUtil.getString("Want to add another (yes/no): [yes]");
                if (choice.trim().equals("")) {
                    choice = "yes";
                }

            } while (choice.equalsIgnoreCase("yes"));

        } catch (Exception e) {
            log.error("Error while acquiring db resources", e);
        }
    }
}
