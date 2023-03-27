package Tests;

import dao.BDD.DaoFactory;

public class TestDao {
    public static void main(String[] args) {
        DaoFactory Dao = new DaoFactory("localhost:3306/tennis", "root", "");
        Dao.getConnection();
    }
}
