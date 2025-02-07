import java.util.Date;
import java.util.List;
import java.util.Scanner;

public class MainApp {
    public static void main(String[] args) {
        Biblioteca biblioteca = new Biblioteca();
        Scanner scanner = new Scanner(System.in);

        //Adicionando alguns autores
        Autor autor1 = new Autor(1, "David Goggins", new Date());
        Autor autor2 = new Autor(2, "James Clear", new Date());

        biblioteca.adicionarAutor(autor1);
        biblioteca.adicionarAutor(autor2);

        //Adicionando Livros

        Livro livro1 = new Livro(1, "Nada pode me parar", autor1);
        Livro livro2 = new Livro(2, "Nunca é hora de parar", autor1);
        Livro livro3 = new Livro(3, "Hábitos Atômicos", autor2);

        biblioteca.adicionarLivro(livro1);
        biblioteca.adicionarLivro(livro2);
        biblioteca.adicionarLivro(livro3);

        //Loop de interação com o usário
        while (true){
            System.out.println("****************** Olá, seja Bem-vindo a livraria! ********************");

            System.out.println("\nDeseja ver os livros disponiveis? (sim/nao)");
            String resposta = scanner.nextLine().toLowerCase();

            if(resposta.equals("sim")){
                List<Livro> livrosDisponiveis = biblioteca.listarLivrosDisponiveis();

                //metodo isEmpty verifica se há uma String vazia, no nosso caso, o array de livrosDisponiveis, caso esteja sem livro ou "vazio" executará o bloco a seguir.
                if(resposta.isEmpty()){
                    System.out.println("Não há livros disponíveis no momentos");
                } else {
                    System.out.println("\nLivros Disponiveis:");
                    for (Livro livro : livrosDisponiveis) {
                        System.out.println(livro.getId() + ": " + livro.getTitulo());
                    }

                    System.out.println("\nDigite o ID do livro que você deseja realizar o emprestimo: ");
                    int idLivro = scanner.nextInt();
                    scanner.nextLine();

                    Livro livroSelecionado = biblioteca.buscarLivrosPorId(idLivro);

                    if (livroSelecionado != null && livroSelecionado.isDisponivel()){
                        System.out.println("\nDigite seu nome: ");
                        String nomeUsuario = scanner.nextLine();

                        biblioteca.emprestarLivro(livroSelecionado, nomeUsuario);

                        System.out.println("O livro " + livroSelecionado.getTitulo() + " foi emprestado para: " + nomeUsuario + " com sucesso!");
                    }else{
                        System.out.println("Livro não encontrado ou não disponivel para empréstimo.");
                    }
                }
            } else if (resposta.equals("nao")) {
                System.out.println("Obrigado por utilizar o sistema da biblioteca!");
                break;
            }else{
                System.out.println("Resposta inválida. Por favor, responda com 'sim' ou 'nao'. ");
            }
        }

        scanner.close();
    }
}
