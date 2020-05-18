import java.util.ArrayList;


class patient {

    String NAME;
    String SURNAME;
    int AGE;
    String ADDRESS;
    Boolean FEWER;
    Boolean M_ACHE;
    Boolean R_NOSE;


    public patient() {

    }

    public patient(String NAME, String SURNAME, int AGE, String ADDRESS, Boolean FEWER, Boolean m_ACHE, Boolean r_NOSE) {
        this.NAME = NAME;
        this.SURNAME = SURNAME;
        this.AGE = AGE;
        this.ADDRESS = ADDRESS;
        this.FEWER = FEWER;
        M_ACHE = m_ACHE;
        R_NOSE = r_NOSE;

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

    private ArrayList<patient> _createPatientTable() {

        ArrayList<patient> patientList = new ArrayList<>();
        patientList.add(new patient("TEST", "TEST", 99, "x city, y street, z condo", false, false, false));


        return patientList;
    }


    public String toString(patient x) {
        String print = x.getNAME() + "  " + x.getSURNAME() + " Age: " + x.getAGE() + + " Adress: " + x.getADDRESS() +  " Fewer?: " + x.getFEWER() + " Muscle Ache?: " + x.getM_ACHE() + " Runny Nose?:" + x.getR_NOSE();
        return print;
    }

    public void print(ArrayList<patient> patientTable) {

        for (int i = 0; i < patientTable.size(); i++) {
            System.out.println(toString(patientTable.get(i)));
        }
    }
}


