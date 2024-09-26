import db.DB;
import menu.Menu;

import java.sql.SQLException;

public class Main {
    public static void main(String[] args) throws InterruptedException, SQLException {

        Menu menu = new Menu();
        menu.menuChoice();
    }
}