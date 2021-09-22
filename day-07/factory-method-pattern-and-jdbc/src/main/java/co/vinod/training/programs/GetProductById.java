package co.vinod.training.programs;

import co.vinod.training.utils.DbUtil;
import co.vinod.training.utils.KeyboardUtil;
import lombok.extern.slf4j.Slf4j;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

@Slf4j
public class GetProductById {

    public static void main(String[] args) {
        String sql = "select * from products where id=?";
        try (
                Connection conn = DbUtil.createConnection();
                PreparedStatement stmt = conn.prepareStatement(sql); // 1st round trip
        ) {
            int id = KeyboardUtil.getInt("Enter product id to search: ");
            stmt.setInt(1, id);
            stmt.execute(); // 2nd round trip

            try(ResultSet rs = stmt.getResultSet()){
                if(rs.next()){
                    log.debug("id={}, name=\"{}\", price={}",
                            rs.getInt("id"),
                            rs.getString("name"),
                            rs.getDouble("price"));
                }
                else {
                    log.warn("No product data found for id {}", id);
                }
            }


        } catch (Exception e) {
            log.error("Error while accessing data", e);
        }
    }
}
