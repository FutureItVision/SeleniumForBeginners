package dbTest;

import db.DbConnection;
import db.Queries_Class;
import org.testng.annotations.Test;

import java.sql.SQLException;

public class DbTest {

    @Test
    public void verifyWorkerInfoTableInfo() throws SQLException, ClassNotFoundException {
        DbConnection.dbConection(Queries_Class.workerInfo());

    }

    @Test
    public void verifyWorkerInfoTableInfoById() throws SQLException, ClassNotFoundException {

        DbConnection.dbConection(Queries_Class.workerInfoById());

    }
}
