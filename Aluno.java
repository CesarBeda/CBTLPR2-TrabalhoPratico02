import java.util.UUID;

public class Aluno {
    private String nome;
    private int idade;
    private String endereco;
    private UUID uuid;
    
    // Construtor
    public Aluno(String nome, int idade, String endereco) {
        this.nome = nome;
        this.idade = idade;
        this.endereco = endereco;
        this.uuid = UUID.randomUUID(); // Gera um UUID único para o aluno
    }

    // Getter para nome
    public String getNome() {
        return nome;
    }

    // Setter para nome
    public void setNome(String nome) {
        this.nome = nome;
    }

    // Getter para idade
    public int getIdade() {
        return idade;
    }

    // Setter para idade
    public void setIdade(int idade) {
        this.idade = idade;
    }

    // Getter para endereço
    public String getEndereco() {
        return endereco;
    }

    // Setter para endereço
    public void setEndereco(String endereco) {
        this.endereco = endereco;
    }

    // Getter para idade
    public UUID getUuid() {
        return uuid;
    }

    // Setter para idade
    public void setUuid(UUID uuid) {
        this.uuid = uuid;
    }
}
