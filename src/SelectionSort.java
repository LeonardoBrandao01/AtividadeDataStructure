
import java.util.Comparator;

public class SelectionSort<T extends Comparable<T>> {
    private int indiceMenorValor(T[] v, int posicao) {
        int indiceMenor = posicao;
        for (int i = posicao + 1; i < v.length; i++) {
            if (v[i].compareTo(v[indiceMenor]) < 0) {
                indiceMenor = i;
            }
        }
        return indiceMenor;
    }

    void troca(T[] v, int i, int j) {
        T temp = v[i];
        v[i] = v[j];
        v[j] = temp;
    }

    public void sort(T[] v) {
        int n = v.length;
        for (int i = 0; i < n - 1; i++) {
            int indiceMenor = indiceMenorValor(v, i);
            troca(v, i, indiceMenor);
        }
    }
}
