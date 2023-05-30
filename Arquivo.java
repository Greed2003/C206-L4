import java.io.*;
import java.util.ArrayList;

public class Arquivo {

    public void escrever(Livro livro) {
        // Importando as classes que nos permitirão escrever no Arquivo
        OutputStream os = null;
        OutputStreamWriter osw = null;
        BufferedWriter bw = null;


        try {
            // Recebe o nome do meu arquivo
            os = new FileOutputStream("Livros.txt",true);

            // Mostra em qual arquivo estaremos escrevendo
            osw = new OutputStreamWriter(os);

            // Permite que escrevamos no arquivo
            bw = new BufferedWriter(osw);

            // Efetivamente escrevendo no arquivo
            bw.write("++ LIVRO ++\n");
            bw.write(livro.getNome()+"\n");
            bw.write(livro.getAutor()+"\n");
            bw.write(livro.getEditora()+"\n");
            bw.write(livro.getQntPaginas()+"\n");


        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        } finally {
            try {
                bw.close();
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }


    }

    public ArrayList<Livro> ler() {
        ArrayList<Livro> livroEn = new ArrayList<>();
        // Estruturas que servirão para a leitura dos dados
        InputStream is = null;
        InputStreamReader isr = null;
        BufferedReader br = null;

        String linhaLer; // Auxiliar que servirá como ponteiro para ler o arquivo

        try{
            is = new FileInputStream("Livros.txt");
            isr = new InputStreamReader(is);
            br = new BufferedReader(isr);


            // Posiciando o cursor no inicio do Arquivo
            linhaLer = br.readLine();

            // Verificando e rodando o código enquanto tiver informações no txt
            while(linhaLer!=null){
                // Verificando se já estamos na estrutura de um funcionário
                if(linhaLer.contains("++ LIVRO ++")){
                    Livro livro = new Livro();
                    livro.setNome(br.readLine());
                    livro.setAutor(br.readLine());
                    livro.setEditora(br.readLine());
                    livro.setQntPaginas(Integer.parseInt(br.readLine()));
                    // Preenchendo as informações do funcionário


                    // Adicionando o funcionário ao arrayList, para informar que encontrei o funcionário
                    livroEn.add(livro);
                }
                // Passando para a próxima linha
                linhaLer = br.readLine();
            }
        }catch (Exception e){

        }
         return livroEn;
    }
}
