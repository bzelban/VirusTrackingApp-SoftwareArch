

//Here is a type of Patient.
//We implemented here with necessary information's

public class PatientClass {

    String NAME;
    String SURNAME;
    int AGE;
    String ADDRESS;
    boolean FEWER;
    boolean M_ACHE;
    boolean R_NOSE;

    public PatientClass(String name, String surname, int age, boolean fewer, boolean m_ache, boolean r_nose) {
        this.NAME = NAME;
        this.SURNAME = SURNAME;
        this.AGE = AGE;
        this.ADDRESS = ADDRESS;
        this.FEWER = FEWER;
        this.M_ACHE = m_ache;
        this.R_NOSE = r_nose;
    }


    public String getNAME() {
        return NAME;
    }

    public void setNAME(String NAME) {
        this.NAME = NAME;
    }

    public String getSURNAME() {
        return SURNAME;
    }

    public void setSURNAME(String SURNAME) {
        this.SURNAME = SURNAME;
    }

    public int getAGE() {
        return AGE;
    }

    public void setAGE(int AGE) {
        this.AGE = AGE;
    }

    public Boolean getFEWER() {
        return FEWER;
    }

    public void setFEWER(Boolean FEWER) {
        this.FEWER = FEWER;
    }

    public Boolean getM_ACHE() {
        return M_ACHE;
    }

    public void setM_ACHE(Boolean m_ACHE) {
        M_ACHE = m_ACHE;
    }

    public Boolean getR_NOSE() {
        return R_NOSE;
    }

    public void setR_NOSE(Boolean r_NOSE) {
        R_NOSE = r_NOSE;
    }

    public String getADDRESS() {
        return ADDRESS;
    }

    public void setADDRESS(String ADDRESS) {
        this.ADDRESS = ADDRESS;
    }

}
