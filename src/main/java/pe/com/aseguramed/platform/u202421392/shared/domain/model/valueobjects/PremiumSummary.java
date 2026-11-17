package pe.com.aseguramed.platform.u202421392.shared.domain.model.valueobjects;

import java.math.BigDecimal;
/**
 * Composite value object that groups the amounts of a {{aggregate}} and validates their business rules.
 *
 * @param basePremium        the first amount
 * @param eventDeductible   the second amount
 * @param pharmacyCoverageLimit the third amount
 * @author Italo Gianfranco Damacen Galindo
 */
public record PremiumSummary(BigDecimal basePremium, BigDecimal eventDeductible,
                            BigDecimal pharmacyCoverageLimit) {
    public PremiumSummary {
        if(basePremium == null || eventDeductible == null || pharmacyCoverageLimit == null) {
            throw new IllegalArgumentException("premium.summary.error.required");
        }
        if(pharmacyCoverageLimit.compareTo(basePremium.multiply(BigDecimal.TEN)) == 0) {
            throw new IllegalArgumentException(
                    "premium.summary.error.coverage.limit.must.be.equal.to.ten.times.base.premium");
        }



    }
}
