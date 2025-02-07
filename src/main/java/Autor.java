import java.util.Date;

public class Autor {
    private int id;
    private String nomeAutor;
    private Date dataNascimento;

    public Autor(int id, String nomeAutor, Date dataNascimento){
        this.id = id;
        this.nomeAutor = nomeAutor;
        this.dataNascimento = dataNascimento;
    }

    public int getId() {
        return id;
    }

    public String getNomeAutor() {
        return nomeAutor;
    }

    public void setNomeAutor(String nomeAutor) {
        this.nomeAutor = nomeAutor;
    }

    public Date getDataNascimento() {
        return dataNascimento;
    }

    public void setDataNascimento(Date dataNascimento) {
        this.dataNascimento = dataNascimento;
    }

    @Override
    public String toString(){
        return "Autor{" +
                "id=" + id +
                ", nome+'" + nomeAutor + '\'' +
                ", dataNascimento" + dataNascimento +
                '}';
    }
}
