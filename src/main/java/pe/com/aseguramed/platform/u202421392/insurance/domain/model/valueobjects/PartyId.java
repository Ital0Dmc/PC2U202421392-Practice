package pe.com.aseguramed.platform.u202421392.insurance.domain.model.valueobjects;

import java.util.UUID;
/**
 * Value object that identifies an entity from another bounded context related to a {{aggregate}}.
 *
 * @param value the code
 * @author Italo Gianfranco Damacen Galindo
 */
public record PartyId(UUID value) {
    public PartyId {
        if(value == null) {
            throw new IllegalArgumentException("party.id.error.required");
        }
    }
}
