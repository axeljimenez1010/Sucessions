package ec.edu.unl.cc.succession.business;

import ec.edu.unl.cc.succession.model.Printable;
import ec.edu.unl.cc.succession.model.Successionable;

/**
 * @author vXel
 * Representa el cálculo de la Serie de primos elevados al cubo hasta un Limite N
 * S = 1^3 + 3^3 + 5^3 + 7^3 + 11^3 + ... + N^3
 */
public class PrimeCubedCalculatorUpToLimit implements Successionable, Printable {

    private Integer limit;
    private Integer currentTerm;
    private StringBuilder printableTerms;

    public PrimeCubedCalculatorUpToLimit(Integer limit) {
        this(1, limit);
    }

    public PrimeCubedCalculatorUpToLimit(Integer start, Integer limit) {
        start = validateLimit(start, "Down limit");
        setLimit(limit);
        this.currentTerm = nextTerm(start - 1).intValue();
        printableTerms = new StringBuilder("S = ");
    }

    private Integer validateLimit(Number value, String label) {
        if (value == null) {
            throw new IllegalArgumentException(label + " cannot be null");
        }
        if (value instanceof Integer) {
            if (value.intValue() < 0) {
                throw new IllegalArgumentException(label + " cannot be negative");
            }
            return value.intValue();
        } else {
            throw new IllegalArgumentException(label + " must be an integer");
        }
    }

    @Override
    public void setLimit(Number limit) {
        this.limit = validateLimit(limit, "Upper limit");
    }

    @Override
    public String print() {
        return this.printableTerms.toString();
    }

    @Override
    public Number calculate() {
        long result = 0;
        while (currentTerm <= limit) {
            this.printableTerms.append(String.valueOf(currentTerm)).append("^3 + ");
            // Elevamos el término actual al cubo antes de sumarlo
            result = result + (long) Math.pow(currentTerm, 3);
            currentTerm = this.nextTerm(currentTerm).intValue();
        }
        return result;
    }

    @Override
    public Number nextTerm(Number current) {
        current = current.intValue() + 1;
        boolean isPrime = false;

        while (!isPrime) {
            // Omitimos el 2 para respetar el salto del 1 al 3 de la serie
            if (current.intValue() == 2) {
                current = current.intValue() + 1;
            }

            isPrime = isPrime(current.intValue());
            if (!isPrime) {
                current = current.intValue() + 1;
            }
        }
        return current;
    }

    private boolean isPrime(Integer number) {
        for (int i = 2; i < number; i++) {
            if (number % i == 0) {
                return false;
            }
        }
        return true;
    }
}