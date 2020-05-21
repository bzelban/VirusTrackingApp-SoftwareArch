import java.util.ArrayList;


class patient_db {

    String NAME;
    String SURNAME;
    int AGE;
    String ADDRESS;
    boolean FEWER;
    boolean M_ACHE;
    boolean R_NOSE;


    public patient_db() {

    }

    public patient_db(String NAME, String SURNAME, int AGE, String ADDRESS, Boolean FEWER, Boolean m_ACHE, Boolean r_NOSE) {
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

    public ArrayList<patient_db> _createPatientTable() {

        ArrayList<patient_db> patientDbList = new ArrayList<>();
        patientDbList.add(new patient_db("TEST", "TEST", 99, "x city, y street, z condo", false, false, false));

        return patientDbList;
    }


    public String toString(patient_db x) {
        String print = x.getNAME() + "  " + x.getSURNAME() + " Age: " + x.getAGE() +  " Address: " + x.getADDRESS() +  " Fewer?: " + x.getFEWER() + " Muscle Ache?: " + x.getM_ACHE() + " Runny Nose?:" + x.getR_NOSE();
        return print;
    }



    public void print(ArrayList<patient_db> patientDbTable) {

        for (int i = 0; i < patientDbTable.size(); i++) {
            System.out.println(toString(patientDbTable.get(i)));
        }
    }

    public static void updateStatus(ArrayList<patient_db> patientDb, String NAME, String SURNAME, boolean fewer, boolean M_ACHE, boolean R_NOSE)
    {
        for(int i = 0; i < patientDb.size(); i++)
        {
            if(patientDb.get(i).getNAME().equalsIgnoreCase(patientDb.get(i).getNAME()))
            {
                if(patientDb.get(i).getNAME().equalsIgnoreCase(patientDb.get(i).getSURNAME()))
                {
                    patientDb.get(i).setFEWER(fewer);
                    patientDb.get(i).setM_ACHE(M_ACHE);
                    patientDb.get(i).setR_NOSE(R_NOSE);
                }
            }
            else
            {
                System.out.println("No Patient found!");
            }
        }


        //TO-DO
        //  Need notify for update patient

    }

    public static void addNewPatient(ArrayList<patient_db> patientDb, String NAME, String SURNAME, int AGE, String ADDRESS, boolean fewer, boolean M_ACHE, boolean R_NOSE)
    {
        patientDb.add(new patient_db(NAME, SURNAME, AGE, ADDRESS, fewer, M_ACHE, R_NOSE));
        //TO-DO
        // notify for New Patient
    }


    public static ArrayList<patient_db> _createDummyTable()
    {
        ArrayList<patient_db> patients = new ArrayList<>();
        patients.add(new patient_db("testNAME", "testSURNAME", 99, "testADDRESS", false, false, false));
        patients.add(new patient_db("BERK","YILMAZ",23,"ADRESS",false,false,false));
        patients.add(new patient_db("BEDIRHAN ZIRAN","ELBAN",26,"KARABAGLAR",true,false,false));
        patients.add(new patient_db("MERT","DOYURGAN",23,"BALCOVA",false,false,true));
        patients.add(new patient_db("ERDEM","OKUR",29,"BALCOVA asd sokak",false,true,false));
        patients.add(new patient_db("TUGGUN","ASRAK",24,"KARSIYAKA",false,false,false));
        patients.add(new patient_db("ali", "uzun", 40, "konak", false, false, false));
        patients.add(new patient_db("Murat","Kısrak",55,"Bostanli",false,true,true));
        patients.add(new patient_db("Belma","Simsek",50,"Gaziemir",true,false,false));
        return patients;
    }
}


