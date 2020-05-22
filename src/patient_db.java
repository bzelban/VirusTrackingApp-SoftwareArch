import java.util.ArrayList;


//Here is our collections.
//This part simulates a database of Patients.

class patient_db{

    public ArrayList<PatientClass> patientDB;

    public patient_db()
    {
        patientDB = new ArrayList<>();

        //Adding Some patients
        addPatient("BERK","YILMAZ",23,"ADRESS",false,false,false);
        addPatient("BEDIRHAN ZIRAN","ELBAN",28,"BOSTANLI",true,false,false);
        addPatient("MERT","DOYURGAN",23,"BALCOVA",false,false,true);
        addPatient("ERDEM","OKUR",28,"BALCOVA asd sokak",false,true,false);
        addPatient("TUGGUN","ASRAK",24,"KARSIYAKA",false,false,false);
        addPatient("ali", "uzun", 40, "konak", false, false, false);
        addPatient("Murat","Kısrak",55,"Bostanli",false,true,true);
        addPatient("Belma","Simsek",50,"Gaziemir",true,false,false);

    }

    public void addPatient(String NAME, String SURNAME, int AGE, String testADDRESS, boolean FEWER, boolean M_ACHE, boolean R_NOSE)
    {
        PatientClass patient = new PatientClass(NAME, SURNAME, AGE, testADDRESS, FEWER, M_ACHE, R_NOSE);
        patientDB.add(patient);
    }

    public ArrayList<PatientClass> getPatientList()
    {
        return patientDB;
    }

    public static void updateStatus(ArrayList<PatientClass> patientDb, String NAME, String SURNAME, boolean fewer, boolean M_ACHE, boolean R_NOSE)
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


    }


    public DatabaseIterator createIterator()
    {
        return new DatabaseIterator(patientDB);
    }
}


