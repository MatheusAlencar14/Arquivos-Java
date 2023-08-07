package application;

import entities.Produto;

import java.io.*;
import java.sql.SQLOutput;
import java.util.*;
import java.util.function.DoubleUnaryOperator;

public class ProgramExercicioFile {

    public static void main(String[] args) {

        Locale.setDefault(Locale.US);
        Scanner sc = new Scanner(System.in);
        List<Produto> produtos = new ArrayList<>();

        System.out.print("Digite o local do arquivo: ");
        String strPath = sc.nextLine();

        File path = new File(strPath);
        String novaPasta = path.getParent();

        boolean subPasta = new File(novaPasta + "\\out").mkdir();

        String arquivoFinal = novaPasta + "\\out\\summary.csv";

        try (BufferedReader br = new BufferedReader(new FileReader(strPath))) {
            String item = br.readLine();

            while (item != null) {
                String[] linhas = item.split(",");
                String nome = linhas[0];
                double valor = Double.parseDouble(linhas[1]);
                int quantidade = Integer.parseInt(linhas[2]);
                produtos.add(new Produto(nome, valor, quantidade));

                item = br.readLine();
            }
            try (BufferedWriter bw = new BufferedWriter(new FileWriter(arquivoFinal))) {
                for (Produto p : produtos) {
                    bw.write(p.getNome() + ", " + String.format("%.2f", p.valorTotal()));
                    bw.newLine();
                }
            } catch (IOException e) {
                System.out.println("Erro: " + e.getMessage());
            }


        } catch (IOException e) {
            System.out.println("Erro: " + e.getMessage());
        }


        sc.close();
    }
}
