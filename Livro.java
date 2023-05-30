public class Livro implements Comparable<Livro> {

    private String nome;
    private String autor;
    private String editora;
    private int qntPaginas;

    public String getNome() {
        return nome;
    }

    public String getAutor() {
        return autor;
    }

    public String getEditora() {
        return editora;
    }

    public int getQntPaginas() {
        return qntPaginas;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public void setAutor(String autor) {
        this.autor = autor;
    }

    public void setEditora(String editora) {
        this.editora = editora;
    }

    public void setQntPaginas(int qntPaginas) {
        this.qntPaginas = qntPaginas;
    }

    public void mostraInfo() {

        System.out.println("Nome: " + this.nome);
        System.out.println("Autor: " + this.autor);
        System.out.println("Editora: " + this.editora);
        System.out.println("Quantidade de paginas: " + this.qntPaginas);
    }

    @Override
    public int compareTo(Livro o) {

        return Integer.compare(this.qntPaginas, o.getQntPaginas());
    }
}
