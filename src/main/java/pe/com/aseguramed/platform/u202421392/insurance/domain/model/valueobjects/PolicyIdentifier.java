package pe.com.aseguramed.platform.u202421392.insurance.domain.model.valueobjects;

import java.util.UUID;
/**
 * Value object that represents the unique code of a {{aggregate}}.
 *
 * @param value the code
 * @author Italo Gianfranco Damacen Galindo
 */
public record PolicyIdentifier(UUID value) {
    public PolicyIdentifier {
        if(value == null) {
            throw new IllegalArgumentException("policy.identifier.error.required");
        }
    }
}
