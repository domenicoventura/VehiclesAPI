package com.domenicoventura.pricing.domain.price;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.math.BigDecimal;

import static org.assertj.core.api.Assertions.assertThat;

@RunWith(SpringRunner.class)
@DataJpaTest
public class PriceRepositoryTests {

    protected Price price;
    protected BigDecimal expectedValue = new BigDecimal(9999.99);
    protected String expectedCurrency = new String("USD");

    @Autowired
    PriceRepository priceRepository;

    @Before
    public void setup() {
        price = new Price("USD", expectedValue, 1L);
        priceRepository.save(price);
    }

    @Test
    public void testFindById() {
        Price retrievedPrice = priceRepository.findById(1L).get();
        assertThat(retrievedPrice.getPrice()).isEqualTo(expectedValue);
        assertThat(retrievedPrice.getCurrency()).isEqualTo(expectedCurrency);
    }
}
