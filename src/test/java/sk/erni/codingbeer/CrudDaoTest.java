package sk.erni.codingbeer;

import org.jooq.Configuration;
import org.jooq.impl.DataSourceConnectionProvider;
import org.jooq.impl.DefaultConfiguration;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import sk.erni.codingbeer.tables.daos.PersonDao;
import sk.erni.codingbeer.tables.pojos.Person;

/**
 * @author Pavol Rajzak, www.rapasoft.eu
 */
public class CrudDaoTest {

    private static final Integer ID = 1337;
    PersonDao personDao;

    @Before
    public void before() {
        Configuration configuration = new DefaultConfiguration().derive(new DataSourceConnectionProvider(Connection.INSTANCE.getDataSource()));
        personDao = new PersonDao(configuration);

        // Delete the shit out of it!
        personDao.deleteById(ID);
    }

    @After
    public void after() {
        // Delete the shit out of it!
        personDao.deleteById(ID);
    }

    @Test
    public void testCRUDPerson() {
        // Create
        Person person = new Person(ID, "John Doe", 42, 123);
        personDao.insert(person);

        // Read
        Person result = personDao.fetchOneById(ID);

        // Not working in jOOQ < 3.5, see: https://github.com/jOOQ/jOOQ/issues/1380
        // Assert.assertEquals(person, result);
        assertPersonEquals(person, result);

        // Update
        person.setName("Jane Doe");
        personDao.update(person);
        result = personDao.fetchOneById(ID);

        assertPersonEquals(person, result);

        // Delete
        personDao.deleteById(ID);

        Assert.assertEquals(0, personDao.fetchById(ID).size());

    }

    private void assertPersonEquals(Person person, Person result) {
        Assert.assertEquals(person.getName(), result.getName());
        Assert.assertEquals(person.getAge(), result.getAge());
        Assert.assertEquals(person.getCity(), result.getCity());
        Assert.assertEquals(person.getId(), result.getId());
    }

}
