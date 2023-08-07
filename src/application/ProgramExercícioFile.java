package application;

import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.function.DoubleUnaryOperator;

public class ProgramExercícioFile {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        List<String[]> infos = new ArrayList<>();
        List<String[]> fim = new ArrayList<>();

        System.out.print("Digite o caminho da pasta do arquivo: ");
        String strPath1 = sc.nextLine();

        System.out.println("Digite o nome do arquivo: ");
        String strPath2 = sc.nextLine();
        String strPath = strPath1 + strPath2;

        boolean file = new File(strPath1 + "\\out").mkdir();
        System.out.println(file);

        String path = "c:\\temp\\out\\summary.csv";

        try (BufferedReader br = new BufferedReader(new FileReader(strPath))) {
            String line = br.readLine();

            while (line != null) {
                String[] vet = line.split(",");
                String n1 = vet[0];
                String n2 = vet[1];
                String n3 = vet[2];
                infos.add(vet);
                line = br.readLine();
            }
            for (String[] info : infos) {
                double valor = Double.valueOf(info[1]).doubleValue() * Double.valueOf(info[2]).doubleValue();
                String val = Double.toString(valor);
                String[] str = new String[] {info[0], val};
                fim.add(str);
            }
        }catch (IOException e) {
            e.printStackTrace();
        }
        try (BufferedWriter bw = new BufferedWriter(new FileWriter(path))) {
            for (String[] fn : fim) {
                bw.write(Arrays.toString(fn));
                bw.newLine();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
