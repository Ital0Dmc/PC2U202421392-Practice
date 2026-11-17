package pe.com.aseguramed.platform.u202421392.shared.domain.model.valueobjects;

import java.math.BigDecimal;

/**
 * Composite value object that groups the amounts of a {{aggregate}} and validates their business rules.
 *
 * @param monthlyFee        the first amount
 * @param registrationFee   the second amount
 * @param totalFirstPayment the third amount
 * @author Italo Gianfranco Damacen Galindo
 */
public record FeeSummary(BigDecimal monthlyFee, BigDecimal registrationFee,
                         BigDecimal totalFirstPayment) {
    public FeeSummary {
        if(monthlyFee == null || registrationFee == null || totalFirstPayment == null){
            throw new IllegalArgumentException("fee.summary.error.required");
        }
        if(registrationFee.compareTo(monthlyFee) > 0) {
            throw new IllegalArgumentException("fee.summary.error.registration.fee.is.gt.monthly.fee");
        }
        if(totalFirstPayment.compareTo(monthlyFee.add(registrationFee)) != 0) {
            throw new IllegalArgumentException("fee.summary.error.first.payment.not.equivalent");
        }
    }
}
