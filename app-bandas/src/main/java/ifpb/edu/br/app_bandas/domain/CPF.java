package ifpb.edu.br.app_bandas.domain;

import java.util.Objects;

public class CPF {
    private static final int TAMANHO = 11;
    private String numero;

    public CPF() {
    }

    public CPF(String numero) {
        this.numero = numero;
    }

    public boolean isValido() {
        return this.numero.length() == TAMANHO;
    }

    public String cpfFormatado() {
        return String.format(
                "%s.%s.%s-%s",
                this.numero.substring(0,3),
                this.numero.substring(3,6),
                this.numero.substring(6,9),
                this.numero.substring(9,11)
        );
    }

    public String getNumero() {
        return this.numero;
    }

    public void setNumero(String numero) {
        this.numero = numero;
    }

    public static int getTAMANHO() {
        return TAMANHO;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        CPF cpf = (CPF) o;
        return Objects.equals(getNumero(), cpf.getNumero());
    }

    @Override
    public int hashCode() {
        return Objects.hash(numero);
    }

    @Override
    public String toString() {
        return "CPF{" +
                "numero='" + numero + '\'' +
                '}';
    }
}
