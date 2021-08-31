package Perfis;

public class PessoaFisica extends Perfil {
    private long cpf;

    public PessoaFisica(String usuario, long cpf) {
        super(usuario);
        this.setCpf(cpf);
    }

    public long getCpf() {
        return cpf;
    }

    public void setCpf(long cpf) {
        this.cpf = cpf;
    }

}
