package sk.erni.codingbeer;

import gudusoft.gsqlparser.EDbVendor;
import gudusoft.gsqlparser.sql2jooq.SQL2jOOQ;
import gudusoft.gsqlparser.sql2jooq.db.DatabaseMetaData;
import gudusoft.gsqlparser.sql2jooq.tool.DatabaseMetaUtil;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

/**
 * @author Pavol Rajzak, www.rapasoft.eu
 */
public class Sql2JooqTest {

    DatabaseMetaData databaseMetaData;

    @Before
    public void init() {
        databaseMetaData = DatabaseMetaUtil
                .getDataBaseMetaData(Connection.INSTANCE.getConnection(), "codingbeer");
    }

    @Test
    public void testConvertSql() throws Exception {
        SQL2jOOQ convert = new SQL2jOOQ(databaseMetaData, EDbVendor.dbvmysql,
                "SELECT name FROM city;");

        convert.convert();

        if (convert.getErrorMessage() != null) {
            Assert.fail();
        }

        String expected =
                "DSLContext create = DSL.using(conn, SQLDialect.MYSQL);\n" +
                        "\n" +
                        "Result<Record1<Object>> result = create.select( City.CITY.NAME )\n" +
                        "\t.from( City.CITY ).fetch( );\n";

        Assert.assertEquals(expected, convert.getConvertResult());
    }

}
