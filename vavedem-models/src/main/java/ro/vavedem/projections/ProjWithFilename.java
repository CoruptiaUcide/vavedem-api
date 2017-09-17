package ro.vavedem.projections;

/**
 * This interface is used with Spring Data to retrieve from the DB only the 'filename' attribute of an object
 * Link from docs: http://docs.spring.io/spring-data/jpa/docs/current/reference/html/#projections
 */
public interface ProjWithFilename {

    String getFilename();
}
