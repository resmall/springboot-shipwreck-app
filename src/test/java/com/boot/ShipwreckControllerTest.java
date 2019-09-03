package com.boot;

import static org.junit.Assert.assertEquals;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;

import com.boot.controller.ShipwreckController;
import com.boot.model.Shipwreck;
import com.boot.repository.ShipwreckRepository;
import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

public class ShipwreckControllerTest {
    // Quando quero que as dependencias dessa classe sejam mockadas
    @InjectMocks
    private ShipwreckController sc;

    // Quando quero que o junit crie mocks das classes e não use as implementações
    @Mock
    private ShipwreckRepository shipwreckRepository;

    @Before
    public void init() {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    public void testShipwreckGet() {
        Shipwreck sw = new Shipwreck();
        sw.setId(1l);
        when(shipwreckRepository.getOne(1l)).thenReturn(sw);

        Shipwreck wreck = sc.get(1L);

        verify(shipwreckRepository).getOne(1l);

//        assertEquals(1l, wreck.getId().longValue());
        assertThat(wreck.getId(), is(1l));
    }
}
