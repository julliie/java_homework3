package dz_lesson13;

import java.io.*;
import java.util.Scanner;

public class StudentsList {
    public static void main(String[] args) throws IOException {
        File fileStudentList = new File("fileStudentList.txt");
        if (!fileStudentList.exists()){
            fileStudentList.createNewFile();
            }


        /* ввести имя студента */
        Scanner newStudent = new Scanner(System.in);
        System.out.print("Введите ФИО: ");
        String studentName = newStudent.nextLine();
        newStudent.close();

        /* открыть файл на чтение и проверить в цикле есть ли имя в файле */
        FileReader fr = new FileReader(fileStudentList);
        BufferedReader reader = new BufferedReader(fr);
        String line;
        int k = 0;
        while ((line = reader.readLine()) != null) {
            if (line.equals(studentName)){
                k++;
                System.out.print("Такое имя уже есть");
                break;
            }
        }
        reader.close();
        if (k == 0) {
            /* добавить имя в файл */
            FileWriter fw = new FileWriter("fileStudentList.txt", true);
            BufferedWriter bw = new BufferedWriter(fw);
            PrintWriter pw = new PrintWriter(bw);
            pw.append(studentName + "\n");
            pw.close();
        }
    }
}
