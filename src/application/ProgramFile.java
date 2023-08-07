package application;

import javax.sound.midi.Soundbank;
import java.io.File;
import java.io.IOException;
import java.util.Scanner;

public class ProgramFile {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.print("Digite o caminho da pasta: ");
        String strPath = sc.nextLine();

        File path = new File(strPath);

        //Somente o nome do arquivo, sem o caminho
        System.out.println("getName: " + path.getName());
        //Somente o caminho do arquivo, sem o nome
        System.out.println("getParent: " + path.getParent());
        //Completo, com caminho e nome do arquivo
        System.out.println("getPath: " + path.getPath());

        sc.close();
    }
}
