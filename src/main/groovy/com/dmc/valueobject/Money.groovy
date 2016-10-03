package com.dmc.valueobject

/**
 *
 * Money model.
 *  From DDD:
 *
 *  'An object that contains attributes but has no conceptual identity. They should be treated as immutable.'
 */
class Money {

    static final Currency USD = Currency.getInstance("USD")
    static final Currency EUR = Currency.getInstance("EUR")
    static final Currency PESOS = Currency.getInstance("ARS") // Argentinian pesos

    BigDecimal amount = BigDecimal.ZERO
    Currency currency = USD

    public Money() {

    }

    static def Money euros(BigDecimal amount) {
        valueOf(amount, EUR)
    }

    static def Money dolars(BigDecimal amount) {
        valueOf(amount, USD)
    }

    static def Money pesos(BigDecimal amount) {
        valueOf(amount, PESOS)
    }

    static def Money valueOf(BigDecimal amount, Currency currency) {
        new Money(amount: amount, currency: currency)
    }

    String toString() {
        "$amount [${currency.currencyCode}]"
    }

    boolean equals(Money other) {
        return
        other != null &&
                currency.equals(other.currency) &&
                amount.equals(other.amount);
    }

    boolean equals(otherMoney) {
        if (this.is(otherMoney)) return true
        if (getClass() != otherMoney.class) return false

        Money money = (Money) otherMoney

        if (amount != money.amount) return false
        if (currency != money.currency) return false

        return true
    }

    int hashCode() {
        int result
        result = (amount != null ? amount.hashCode() : 0)
        result = 31 * result + (currency != null ? currency.hashCode() : 0)
        return result
    }

    BigDecimal plus(Money money) {
        assert this.currency == money.currency, "Cannot plus different currencies"
        // TODO: use Rounded results
        valueOf(this.amount.add(money.amount), this.currency)
    }

}
