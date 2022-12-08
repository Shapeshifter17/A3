import java.io.File;
import java.io.FileNotFoundException;
import java.util.Arrays;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {


        int fileLine = 0;
        String placeholder = "";
        String path = "/home/andrei/Desktop/352/A3/src/xaa";

        //THis first iteration will count the number of elements in the textfile
        try {
            File myObj = new File(path);
            Scanner myReader = new Scanner(myObj);

            while (myReader.hasNextLine()) {
                placeholder = myReader.nextLine();
                fileLine++;
            }

            myReader.close();
        } catch (FileNotFoundException e) {
            System.out.println("An error occurred. The file was not found, potentially invalid path : " + path);
            e.printStackTrace();
        }

        int []data = new int[fileLine];
        int i = 0;

        //This iteration will store the elements in the text file in a temporary array
        try {
            File myObj = new File(path);
            Scanner myReader = new Scanner(myObj);

            while (myReader.hasNextInt()) {
                data[i] = myReader.nextInt();
                i++;
            }

            myReader.close();
        } catch (FileNotFoundException e) {
            System.out.println("An error occurred. The file was not found, potentially invalid path : " + path);
            e.printStackTrace();
        }

        ElasticERL ERL = new ElasticERL(0);
        ERL.add(ERL,"1","diego");
        ERL.add(ERL,"2","pablo");
        ERL.add(ERL,"3","sanchez");
        ERL.add(ERL,"4","Homer");
        ERL.add(ERL,"5","Brev");
        ERL.add(ERL,"6","Tory");
       // ERL.remove(ERL,"1");
//        System.out.println(ERL.nextKey(ERL,"5"));
//        System.out.println(ERL.getValue(ERL,"3"));
//        System.out.println(ERL.prevKey(ERL,"3"));
        System.out.println(ERL.rangeKey("3","4"));

        System.out.println(Arrays.toString(ERL.allKeys(ERL)));
        Arrays.sort(data);
        System.out.println("The file that we have opened has "+ fileLine + " lines, hence we will use a data structure");

    }
}