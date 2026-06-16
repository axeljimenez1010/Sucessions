package ec.edu.unl.cc.succession.model;

/**
 * @author vXeL
 */
public interface Successionable {

    /**
     * Setter the limit to successions
     * @param limit
     */
    void setLimit(Number limit);

    /**
     * Calculate the result. The main method in the succession
     * @return Number of the result calculate
     */
    Number calculate();

    /**
     * Generate the next term in the succession from current term
     * @param current
     * @return Number the next term
     */
    Number nextTerm(Number current);

}
