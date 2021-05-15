import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;

public class CountChar {



        private final char toSerach;
        private FileReader myFile;

        {
            try {
                myFile = new FileReader("C:\\Users\\hesha\\IdeaProjects\\task2\\src\\textFile.txt");
            } catch (FileNotFoundException e) {
                e.printStackTrace();
            }
        }

        CountChar(FileReader file, char toSerach) throws IOException {
            this.myFile = file;
            this.toSerach = toSerach;

        }

        private String readFile() throws IOException {

            String everything;

            try (BufferedReader br = new BufferedReader(myFile)) {
                StringBuilder sb = new StringBuilder();
                String line = br.readLine();

                while (line != null) {
                    sb.append(line);
                    sb.append(System.lineSeparator());
                    line = br.readLine();

                }
                everything = sb.toString();
            }
            return everything;
        }

        private int count(String line) {
            int count = 0;

            for (int i = 0; i < line.length(); i++) {
                if (line.charAt(i) == toSerach) {
                    count++;
                }
            }

            return count;
        }

        public static void main(String[] args) throws IOException {
            FileReader myFile = new FileReader("C:\\Users\\hesha\\IdeaProjects\\task2\\src\\textFile.txt");
            CountChar cc = new CountChar(myFile, 'e');

//            Scanner input = new Scanner(System.in);
//            System.out.println("Enter the character to search for :");
//            char ch = input.nextLine().charAt(0);

            System.out.println(cc.count(cc.readFile()));
        }



}
