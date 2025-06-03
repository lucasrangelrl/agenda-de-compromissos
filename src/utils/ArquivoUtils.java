package utils;

import model.Compromisso;
import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class ArquivoUtils {
    private static final String PASTA = "data";
    private static final String NOME_ARQUIVO = PASTA + File.separator + "compromissos.txt";

    public static void salvar(List<Compromisso> lista) {
        try {
            File dir = new File(PASTA);
            if (!dir.exists()) {
                dir.mkdir();
            }

            try (BufferedWriter writer = new BufferedWriter(new FileWriter(NOME_ARQUIVO))) {
                for (Compromisso c : lista) {
                    writer.write(c.getTitulo() + ";" + c.getDescricao() + ";" + c.getData() + ";" + c.getHora());
                    writer.newLine();
                }
            }
        } catch (IOException e) {
            System.out.println("Erro ao salvar os compromissos: " + e.getMessage());
        }
    }

    public static List<Compromisso> carregar() {
        List<Compromisso> lista = new ArrayList<>();
        File arquivo = new File(NOME_ARQUIVO);

        if (!arquivo.exists()) return lista;

        try (BufferedReader reader = new BufferedReader(new FileReader(arquivo))) {
            String linha;
            while ((linha = reader.readLine()) != null) {
                String[] partes = linha.split(";");
                if (partes.length == 4) {
                    lista.add(new Compromisso(partes[0], partes[1], partes[2], partes[3]));
                }
            }
        } catch (IOException e) {
            System.out.println("Erro ao carregar os compromissos: " + e.getMessage());
        }

        return lista;
    }
}
