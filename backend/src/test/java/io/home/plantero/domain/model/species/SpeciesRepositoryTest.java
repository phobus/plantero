package io.home.plantero.domain.model.species;

import io.home.plantero.application.util.SampleDataGenerator;
import io.home.plantero.config.SampleConfig;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.context.annotation.Import;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;

import static io.home.plantero.application.util.SampleDataGenerator.DefinedSpecies;

@RunWith(SpringRunner.class)
@DataJpaTest
@ContextConfiguration(classes = {SampleConfig.class})
@EntityScan
public class SpeciesRepositoryTest {

    //@Autowired
    private SpeciesRepository speciesRepository;

    //@Autowired
    private SampleDataGenerator sampleDataGenerator;

//    @Before
//    public void setUp() throws Exception {
//    }
//
//    @After
//    public void tearDown() throws Exception {
//    }

    //@Test
    public void when_() {
        sampleDataGenerator.generate();

        Species species = speciesRepository.findById(DefinedSpecies.CHERRY_TOMATO_ID).get();

        Assert.assertNotNull(species);
        Assert.assertEquals(DefinedSpecies.CHERRY_TOMATO_NAME, species.getName());
        Assert.assertEquals(DefinedSpecies.CHERRY_TOMATO_HTML, species.getUrl());
    }
}