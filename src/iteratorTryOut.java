import java.util.ArrayList;

interface iterator
{
    boolean hasNext();
    Object next();
}

class DatabaseIterator implements iterator
{
    ArrayList<PatientClass> patientsList;
    int position = 0;

    public DatabaseIterator(ArrayList<PatientClass> patientsList) {
        this.patientsList = patientsList;
    }

    @Override
    public boolean hasNext() {
        if (position >= patientsList.size() || patientsList.get(position) == null)
        {
            return false;
        }
        else
        {
            return true;
        }
    }

    @Override
    public Object next() {
        PatientClass patient = patientsList.get(position);
        position = position + 1;

        return patient;
    }
}

class Lister //Patient Lister.
{
    patient_db patientDB;

    public Lister(patient_db patientDB)
    {
        this.patientDB = patientDB;
    }

    public void printAll()
    {
        DatabaseIterator databaseIterator = patientDB.createIterator();
        System.out.println("Printing All Patients: ");
        printAllPatients(databaseIterator);
    }

    private void printAllPatients(DatabaseIterator iterator)
    {
        while (iterator.hasNext())
        {
            PatientClass patient = (PatientClass)iterator.next();
            System.out.println("Name: " + patient.getNAME() + ", Surname: " + patient.getSURNAME() + ", Age: " + patient.getAGE() + ", Address: " + patient.getADDRESS() + ", Fewer: " + patient.getFEWER() + ", Muscle Ache:  " + patient.getM_ACHE() + ", Runny Nose: " + patient.getR_NOSE());

        }
    }



}

public class iteratorTryOut {

    public static void main(String[] args) {

        patient_db patientDB = new patient_db();
        ArrayList patientList = patientDB.getPatientList();

        Lister lister = new Lister(patientDB);
        lister.printAll();

    }
}
