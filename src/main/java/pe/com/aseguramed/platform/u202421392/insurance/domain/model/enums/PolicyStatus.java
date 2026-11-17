package pe.com.aseguramed.platform.u202421392.insurance.domain.model.enums;
/**
 * Possible statuses of a {{aggregate}}.
 * INT is the default status when none is specified.
 *
 * @author Italo Gianfranco Damacen Galindo
 */
public enum PolicyStatus {
    INT, //default
    ACTIVE,
    SUSPENDED,
    TERMINATED
}
