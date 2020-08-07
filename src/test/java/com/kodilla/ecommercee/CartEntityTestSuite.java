package com.kodilla.ecommercee;

import com.kodilla.ecommercee.domain.Cart;
import com.kodilla.ecommercee.repository.CartRepository;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.Assert.assertEquals;

@RunWith(SpringRunner.class)
@SpringBootTest
public class CartEntityTestSuite {

    @Autowired
    private CartRepository repository;
    private static final String DESCRIPTION = "sample description";
    private Cart cart1;
    private Cart cart2;

    @Before
    public void init() {
        cart1 = new Cart(DESCRIPTION);
        cart2 = new Cart();
    }

    @Test
    public void should_saveAllCartsToDatabase() {
        // given

        // when
        repository.save(cart1);
        repository.save(cart2);
        long expectedSize = repository.findAll().size();

        // then
        assertEquals(2, expectedSize);

        // cleanUp
        repository.deleteAll();
    }

    @Test
    public void should_returnDescriptionFromDatabase() {
        // given

        // when
        repository.save(cart1);
        String expectedDescription = repository.findAll().get(0).getDescription();

        // then
        assertEquals(DESCRIPTION, expectedDescription);

        // cleanUp
        repository.deleteById(cart1.getId());
    }

    @Test
    public void should_removeAllRecordsFromDatabase() {
        // given

        // when
        repository.save(cart1);
        repository.save(cart2);
        repository.deleteAll();
        long expectedSize = repository.findAll().size();

        // then
        assertEquals(0, expectedSize);
    }

    @Test
    public void should_removeRecordWithExpectedId() {
        // given

        // when
        repository.save(cart1);
        repository.save(cart2);
        long testedId = cart1.getId();
        repository.deleteById(testedId);
        long expectedSize = repository.findAll().size();

        // then
        assertEquals(1, expectedSize);

        // cleanUp
        repository.deleteAll();
    }
}
