package norman.example.design.adapter;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Enumeration;
import java.util.List;
import java.util.Properties;

import static org.junit.jupiter.api.Assertions.assertEquals;

class EnumerationAdapterTest {
    IteratorService<Object> service;

    @BeforeEach
    void setUp() {
        service = new IteratorService<>();
    }

    @Test
    void adapter() {
        Properties properties = System.getProperties();
        int expectedCount = properties.size();
        Enumeration<Object> elements = properties.elements();
        EnumerationAdapter<Object> adapter = new EnumerationAdapter<>(elements);

        List<Object> list = new ArrayList<>();
        int actualCount = service.iterateAndDoSomething(adapter, list::add);

        assertEquals(expectedCount, actualCount);
        assertEquals(expectedCount, list.size());
    }
}
