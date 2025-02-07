import java.util.ArrayList;
import java.util.List;

public class Biblioteca {
    private List<Livro> livros = new ArrayList<>();
    private List<Autor> autores = new ArrayList<>();
    private List<Emprestimo> emprestimos = new ArrayList<>();


    //Metodos para gerenciamento do s livros
    public void adicionarLivro(Livro livro){
        livros.add(livro); //adiciona um novo livro no array "Livros"
    }

    public List<Livro> listarLivros(){
        return livros;
    }

    public List<Livro> listarLivrosDisponiveis(){
        List<Livro> livrosDisponiveis = new ArrayList<>();
        for (Livro livro : livros ){
            if (livro.isDisponivel()){
                livrosDisponiveis.add(livro);
            }
        }
        return livrosDisponiveis;
    }

    public Livro buscarLivrosPorId(int id){
        for(Livro livro : livros){
            if (livro.getId() == id){
                return livro;
            }
        }
        return null;
    }

    public void atualizarLivro(int id, String novoTitulo){
        for (Livro livro : livros){
            if (livro.getId() == id){
                livro.setTitulo(novoTitulo);
                break;
            }
        }
    }

    //remove diretamente do array "removeIf"
    public void removerLivro(int id){
        livros.removeIf(livro -> livro.getId() == id);
    }

    //metodos de gerenciamento dos autores
    public void adicionarAutor(Autor autor){
        autores.add(autor);
    }

    public List<Autor> listarAutores() {
        return autores;
    }

    public void atualizarAutor(int id, String novoNome){
        for(Autor autor : autores){
            if (autor.getId() == id){
                autor.setNomeAutor(novoNome);
            }
        }
    }

    public void removerAutor(int id){
        autores.removeIf(autor -> autor.getId() == id);
    }

    //Metodo para gerenciar emprestimos
    public void emprestarLivro(Livro livro, String nomeUsuario){
        if(livro.isDisponivel()) {
            Emprestimo emprestimo = new Emprestimo(livro, nomeUsuario);
            emprestimos.add(emprestimo);
            livro.setDisponivel(false);
        }else{
            System.out.println("Livro indisponivel para emprestimo");
        }
    }

    public void devolverLivro(int idEmprestimo){
        for (Emprestimo emprestimo : emprestimos){
            if (emprestimo.getId() == idEmprestimo && emprestimo.isAtivo()) {
                emprestimo.devolverLivro();
                break;
            }
        }
    }

    public List<Emprestimo> listarEmprestimos(){
        return emprestimos;
    }
}
