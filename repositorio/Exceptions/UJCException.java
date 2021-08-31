package repositorio.Exceptions;

import Perfis.Perfil;

public class UJCException extends Exception {
    private Perfil usuario;

    public UJCException(Perfil usuario) {
        super("Usuário Já Cadastrado");
        this.setUsuario(usuario);
    }

    public String GetMessage(){
        return "Erro!! O usuário já está cadastrado, tente outra opção.";
    }
    
    public Perfil getUsuario() {
        return usuario;
    }

    public void setUsuario(Perfil usuario) {
        this.usuario = usuario;
    }


    
}
