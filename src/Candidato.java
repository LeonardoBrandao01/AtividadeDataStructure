
import java.time.LocalDate;

public class Candidato implements Comparable<Candidato> {
    private String id;
    private String nome;
    private LocalDate dataNascimento;
    private double nota;

    public Candidato(String id, String nome, LocalDate dataNascimento, double nota) {
        this.id = id;
        this.nome = nome;
        this.dataNascimento = dataNascimento;
        this.nota = nota;
    }

    public String getId() {
        return id;
    }

    public String getNome() {
        return nome;
    }

    public LocalDate getDataNascimento() {
        return dataNascimento;
    }

    public double getNota() {
        return nota;
    }

    @Override
    public int compareTo(Candidato outroCandidato) {
        // Comparar pela nota, em ordem decrescente
        if (this.nota > outroCandidato.nota) {
            return -1;
        } else if (this.nota < outroCandidato.nota) {
            return 1;
        } else {
            // Em caso de empate na nota, comparar pela data de nascimento (mais velho primeiro)
            return this.dataNascimento.compareTo(outroCandidato.getDataNascimento());
        }
    }

    @Override
    public String toString() {
        return "Candidato{" +
                "id='" + id + '\'' +
                ", nome='" + nome + '\'' +
                ", dataNascimento=" + dataNascimento +
                ", nota=" + nota +
                '}';
    }
}