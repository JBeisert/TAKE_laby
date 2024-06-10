package lab.services;

import jakarta.enterprise.context.ApplicationScoped;
import jakarta.enterprise.context.Dependent;
import jakarta.enterprise.inject.Produces;
import org.modelmapper.ModelMapper;

@Dependent
public class ModelMapperProducer {
    @ApplicationScoped
    @Produces
    public ModelMapper getModelMapper() {
        return new ModelMapper();
    }
}
