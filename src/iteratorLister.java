import java.util.ArrayList;
import java.util.Scanner;

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

//////////////////////////////////////////////////////
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
        System.out.println("Listing All Patients: ");
        printAll(databaseIterator);
    }

    private void printAll(DatabaseIterator iterator)
    {
        while (iterator.hasNext())
        {
            PatientClass patientsList = (PatientClass)iterator.next();
            System.out.println("Name: " + patientsList.getNAME() + ", Surname: " + patientsList.getSURNAME() + ", Age: " + patientsList.getAGE() + ", Address: " + patientsList.getADDRESS() + ", Fewer: " + patientsList.getFEWER() + ", Muscle Ache:  " + patientsList.getM_ACHE() + ", Runny Nose: " + patientsList.getR_NOSE());

        }
    }

    public void printBetweenAge()
    {
        DatabaseIterator databaseIterator = patientDB.createIterator();
        System.out.println("Listing Ages between 25-60 Patients: ");
        printBetweenAge(databaseIterator);
    }

    private void printBetweenAge(DatabaseIterator iterator)
    {
        while(iterator.hasNext())
        {
            PatientClass patientsList = (PatientClass)iterator.next();
            if(patientsList.getAGE() > 25 && patientsList.getAGE() < 60)
            {
                System.out.println("Name: " + patientsList.getNAME() + ", Surname: " + patientsList.getSURNAME() + ", Age: " + patientsList.getAGE() + ", Address: " + patientsList.getADDRESS() + ", Fewer: " + patientsList.getFEWER() + ", Muscle Ache:  " + patientsList.getM_ACHE() + ", Runny Nose: " + patientsList.getR_NOSE());
            }

        }
    }

    public void printAllAddress()
    {
        DatabaseIterator databaseIterator = patientDB.createIterator();
        System.out.println("Listing all patient addresses: ");
        printAllAddress(databaseIterator);
    }

    private void printAllAddress(DatabaseIterator iterator)
    {
        while(iterator.hasNext())
        {
            PatientClass patientsList = (PatientClass)iterator.next();
            System.out.println(patientsList.getADDRESS());
        }
    }

    public void printTotalPatients()
    {
        DatabaseIterator databaseIterator = patientDB.createIterator();
        System.out.println("Total patient number: ");
        printTotalPatients(databaseIterator);
    }

    private void printTotalPatients(DatabaseIterator iterator)
    {
        int patientCount = 0;

        while(iterator.hasNext())
        {
            patientCount = patientCount + 1;
        }
        System.out.println(patientCount);
    }


    public void printMultipleQueries()
    {
        int queryTemp = 2;
        boolean queryAge = false;
        boolean queryAddress = false;
        boolean queryCount = false;

        DatabaseIterator databaseIterator = patientDB.createIterator();
        Scanner sc = new Scanner(System.in);

        System.out.println("Do you want Age interval between 25-60? To yes press 1, to no press 2");
        queryTemp = sc.nextInt();
        if(queryTemp == 1)
        {
            queryAge = true;
        }
        else if (queryTemp == 2)
        {
            queryAge = false;
        }
        else
        {
            System.out.println("wrong choice, default NO");
        }

        System.out.println("Do you want addresses of the patients? to yes press 1, to no press 2");
        queryTemp = sc.nextInt();
        if(queryTemp == 1)
        {
            queryAddress = true;
        }
        else if (queryTemp == 2)
        {
            queryAddress = false;
        }
        else
        {
            System.out.println("wrong choice, default NO");
        }

        System.out.println("Do you want to count patients? to yes press 1, to yess press 2");
        queryTemp = sc.nextInt();
        if(queryTemp == 1)
        {
            queryCount = true;
        }
        else if (queryTemp == 2)
        {
            queryCount = false;
        }
        else
        {
            System.out.println("wrong choice, default NO");
        }
        printMultipleQueries(databaseIterator, queryAge, queryAddress, queryCount);
    }

    private void printMultipleQueries(DatabaseIterator iterator, boolean age_, boolean address_, boolean count_)
    {
        int patientCount = 0;

        while(iterator.hasNext())
        {
            PatientClass patientsList = (PatientClass)iterator.next();

            if(age_ && address_ && count_)
            {
                System.out.println(patientsList.getAGE() + " " + patientsList.getADDRESS());
                patientCount = patientCount + 1;
            }
            else if (age_ && address_ && !count_)
            {
                System.out.println(patientsList.getAGE() + " " + patientsList.getADDRESS());
            }
            else if (age_ && !address_ && count_)
            {
                System.out.println(patientsList.getAGE());
                patientCount = patientCount + 1;
            }
            else if (age_ && !address_ && !count_)
            {
                System.out.println(patientsList.getAGE());
            }
            else if (!age_ && !address_ && !count_)
            {
                System.out.println("Nothing to show");
            }
            else if (!age_ && address_ && count_)
            {
                System.out.println(patientsList.getADDRESS());
                patientCount = patientCount + 1;
            }
            else if (!age_ && address_ && !count_)
            {
                System.out.println(patientsList.getADDRESS());
            }
            else if (!age_ && !address_ && count_)
            {
                patientCount = patientCount + 1;
            }

            if(patientCount != 0)
            {
                System.out.println("Number of Listed patients " + patientCount);
            }
        }
    }


    public void updatePatient(String NAME, String SURNAME, boolean FEWER, boolean M_ACHE, boolean R_NOSE)
    {
        DatabaseIterator databaseIterator = patientDB.createIterator();
        updatePatient(databaseIterator, NAME, SURNAME, FEWER, M_ACHE, R_NOSE);
    }
    private void updatePatient(DatabaseIterator iterator, String NAME, String SURNAME, boolean FEWER, boolean M_ACHE, boolean R_NOSE)
    {
        while(iterator.hasNext())
        {
            PatientClass patientsList = (PatientClass)iterator.next();

            if(patientsList.getNAME().equalsIgnoreCase(NAME))
            {
                if(patientsList.getSURNAME().equalsIgnoreCase(SURNAME))
                {
                    patientsList.setFEWER(FEWER);
                    patientsList.setM_ACHE(M_ACHE);
                    patientsList.setR_NOSE(R_NOSE);
                }
            }
        }
        System.out.println("Status Updated");
    }

    public void addPatient()
    {
        DatabaseIterator databaseIterator = patientDB.createIterator();
        System.out.println("Adding new patient");
        printTotalPatients(databaseIterator);

    }
    private void addPatient(DatabaseIterator iterator)
    {
        PatientClass patientsList = (PatientClass)iterator.next();
        Scanner sc = new Scanner(System.in);
        while(iterator.hasNext())
        {
            if(!iterator.hasNext())
            {
                System.out.println("Name of the Patient");
                patientsList.setNAME(sc.next());
                System.out.println("Surname of the Patient");
                patientsList.setSURNAME(sc.next());
                System.out.println("Address of the Patient");
                patientsList.setADDRESS(sc.next());
                System.out.println("Age of the Patient");
                patientsList.setAGE(sc.nextInt());

                System.out.println("Fewer? 1 for True, 2 for False");
                int tempSendMenu = sc.nextInt();
                if(tempSendMenu == 1 )
                {
                    patientsList.setFEWER(true);
                }
                else if(tempSendMenu == 2)
                {
                    patientsList.setFEWER(false);
                }
                else
                {
                    System.out.println("Wrong input, DEFAULT FALSE");
                    patientsList.setFEWER(false);
                }

                System.out.println("Muscle Ache? 1 for True, 2 for False");
                tempSendMenu = sc.nextInt();
                if(tempSendMenu == 1)
                {

                    patientsList.setM_ACHE(true);
                }
                else if(tempSendMenu == 2)
                {

                    patientsList.setM_ACHE(false);
                }
                else
                {
                    System.out.println("Wrong input, DEFAULT FALSE");
                    patientsList.setM_ACHE(false);
                }

                System.out.println("Runny Nose? 1 for True, 2 for False");
                tempSendMenu = sc.nextInt();
                if(tempSendMenu == 1)
                {
                    patientsList.setR_NOSE(true);
                }
                else if (tempSendMenu == 2)
                {
                    patientsList.setR_NOSE(false);

                }
                else
                {
                    patientsList.setR_NOSE(false);
                    System.out.println("Wrong input, DEFAULT FALSE");
                }
            }
        }

    }

}

public class iteratorLister {

}
