package repositorio.Exceptions;

import Perfis.Perfil;

public class UNCException extends Exception {
    private Perfil usuario;

    public UNCException(Perfil usuario) {
        super("Usuário Não Cadastrado");
        this.setUsuario(usuario);
    }
    
    public String GetMessage(){
        return "Erro!! O usuário não foi cadastrado, tente outra opção.";
    }
    
    public Perfil getUsuario() {
        return usuario;
    }

    public void setUsuario(Perfil usuario) {
        this.usuario = usuario;
    }
    
}
