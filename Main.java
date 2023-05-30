import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        ArrayList<Livro> livros;
        Arquivo arquivo = new Arquivo();

        int aux = 0;

        Scanner sc = new Scanner(System.in);

        boolean flag = true; // Controladora While
        int opcao = 0; // Opção do menu

        while (flag) {
            livros = arquivo.ler();

            System.out.println("BEM VINDO AO SISTEMA DE CONTROLE DE LIVROS");
            System.out.println("1- Adicionar Livros");
            System.out.println("2 - Mostrar informações dos livros no txt");
            System.out.println("3 - Ordenar em ordem crescete de paginas");
            System.out.println("4 - Ordenar em ordem decrescete de paginas");
            System.out.println("5 - Livros com a editora Leya");
            opcao = sc.nextInt();
            sc.nextLine(); // Limpando o buffer

            switch (opcao) {
                case 1:
                    // Criando Livro na Main
                    Livro livro = new Livro();
                    System.out.println("Titulo: ");
                    livro.setNome(sc.nextLine());
                    System.out.println("Autor: ");
                    livro.setAutor(sc.nextLine());
                    try{
                        System.out.println("Editora: ");
                        livro.setEditora(sc.nextLine());

                        if (!(livro.getEditora().equals("Leya") || livro.getEditora().equals("Arqueiro") || livro.getEditora().equals("Rocco") )){
                            throw new InfoInvalidaException("Editora errada!!");

                        }
                        System.out.println("Quantidade de páginas");
                        livro.setQntPaginas(sc.nextInt());

                        if(livro.getQntPaginas() < 0){

                            throw new InfoInvalidaException("A quantidade de pagina não pode ser menor que 0!!");
                        }
                    }catch (InfoInvalidaException e){
                        break;
                    }
                    sc.nextLine(); // Limpando o buffer

                    arquivo.escrever(livro);
                    break;
                case 2:
                    for (int i = 0; i < livros.size() ; i++) {

                        livros.get(i).mostraInfo();
                    }

                    break;
                case 3:

                    Collections.sort(livros);

                    for (int i = 0; i < livros.size() ; i++) {

                        livros.get(i).mostraInfo();
                    }

                    break;
                case 4:

                    Collections.sort(livros);
                    Collections.reverse(livros);

                    for (int i = 0; i < livros.size() ; i++) {

                        livros.get(i).mostraInfo();
                    }

                    break;

                case 5:

                    for (int i = 0; i < livros.size() ; i++) {
                         if (livros.get(i).getEditora().equals("Leya")){
                             aux++;
                         }
                    }

                    System.out.println("Quantidade de livros com a editora Leya: " + aux);

                    break;

                default:
                    flag = false; // Saindo do menu
                    break;
            }

        }
        sc.close(); // Fechando a entrada de dados

    }
}