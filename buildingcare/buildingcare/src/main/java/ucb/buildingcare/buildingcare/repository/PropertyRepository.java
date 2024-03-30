    package ucb.buildingcare.buildingcare.repository;

    import org.springframework.data.jpa.repository.JpaRepository;
    import org.springframework.data.jpa.repository.Query;
    import org.springframework.stereotype.Repository;
    import ucb.buildingcare.buildingcare.entity.Property;
    import ucb.buildingcare.buildingcare.entity.Section;
    import ucb.buildingcare.buildingcare.entity.TypeProperty;
    import ucb.buildingcare.buildingcare.entity.User;

    import java.math.BigDecimal;
    import java.util.List;

    @Repository
    public interface PropertyRepository extends JpaRepository<Property, Integer> {
        @Query("SELECT p FROM Property p ORDER BY p.id DESC")
        List<Property> findAllReverseOrder();
        Property findById(int id);

        @Query("SELECT p.id FROM Property p")
        List<Integer> findAllPropertyIds();

        List<Property> findByIdTypeProperty(TypeProperty idTypeProperty);

        List<Property> findByEnvironments(int environments);

        List<Property> findByDimensions(double dimensions);
        List<Property> findByDimensionsBetween(double dimensions1, double dimensions2); 

        List<Property> findByValue(BigDecimal value);
        List<Property> findByValue(double value);

        List<Property> findByIdUser(User idUser);

        List<Property> findByIdSection(Section idSection);

        List<Property> findByIdUserAndIdSection(User idUser, Section idSection);
        List<Property> findByIdTypePropertyAndIdSection(TypeProperty idTypeProperty, Section idSection);
    }
