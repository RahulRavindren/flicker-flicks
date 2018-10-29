package com.flickerflics.repository;

import com.flickerflics.common.entity.PageEntity;
import com.flickerflics.interfaces.FlickerRepoListeners;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;

/**
 * @Author rahulravindran
 */
@RunWith(MockitoJUnitRunner.class)
public class FlickerRepositoryTest {

    @Mock
    FlickerRepoListeners listeners;

    FlickerRepository repository;

    @Before
    public void setUp() throws Exception {

        repository = new FlickerRepository(listeners);
    }

    @Test
    public void testForRemoteResponse() {
        PageEntity entity = PageEntity.Companion.getINITIAL();
        repository.searchForImage(entity);
    }


}
