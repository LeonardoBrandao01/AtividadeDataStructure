


import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

public class ConcursoApp {
    public static void main(String[] args) {
        String filePath = "/Users/leonardobrandao/IdeaProjects/AtividadeEstruturaDeDadosConcurso/dadosConcurso.csv";
        List<Candidato> candidatos = new ArrayList<>();

        try {
            List<String> linhas = Files.readAllLines(Paths.get(filePath));

            // Ajuste para o formato de data 'dd/MM/yyyy'
            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");

            // Ignora a primeira linha (cabeçalho)
            for (int i = 1; i < linhas.size(); i++) {
                String linha = linhas.get(i).trim();  // Remove espaços em branco

                // Verifica se a linha não está em branco e contém exatamente 4 campos
                if (!linha.isEmpty()) {
                    String[] campos = linha.split(",");

                    if (campos.length == 4) {
                        String id = campos[0].trim();
                        String nome = campos[1].trim();
                        // Parsing da data com o novo formato
                        LocalDate dataNascimento = LocalDate.parse(campos[2].trim(), formatter);
                        double nota = Double.parseDouble(campos[3].trim());

                        Candidato candidato = new Candidato(id, nome, dataNascimento, nota);
                        candidatos.add(candidato);
                    } else {
                        System.out.println("Linha com formato incorreto: " + linha);
                    }
                }
            }
        } catch (IOException e) {
            e.printStackTrace(); // Imprime o erro completo
        }

        // Convertendo a lista para um array para ser usado no SelectionSort
        Candidato[] arrayCandidatos = new Candidato[candidatos.size()];
        candidatos.toArray(arrayCandidatos);

        // Ordenando os candidatos
        SelectionSort<Candidato> selectionSort = new SelectionSort<>();
        selectionSort.sort(arrayCandidatos);

        // Exibindo os candidatos ordenados
        for (Candidato candidato : arrayCandidatos) {
            System.out.println(candidato);
        }
    }
}