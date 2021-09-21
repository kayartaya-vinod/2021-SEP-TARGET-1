package co.vinod.training.programs;

import co.vinod.training.utils.KeyboardUtil;
import lombok.extern.slf4j.Slf4j;

@Slf4j
public class SqlInjectionSimulation {
    public static void main(String[] args) {
        String username;
        String password;

        username = KeyboardUtil.getString("Enter username: "); // vinod' or 'a'='a' --
        password = KeyboardUtil.getString("Enter password: ");

        String sql = String.format("select * from users where username='%s' and password='%s'", username, password);

        log.debug(sql);
    }
}
