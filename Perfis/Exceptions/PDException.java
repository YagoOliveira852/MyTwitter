package Perfis.Exceptions;

import Perfis.Perfil;

public class PDException extends Exception {
    private Perfil usuario;

    public PDException(Perfil usuario) {
        super("Perfil Desativado");
        this.setUsuario(usuario);
    }

    public Perfil getUsuario() {
        return usuario;
    }

    public void setUsuario(Perfil usuario) {
        this.usuario = usuario;
    }

    public String GetMessage(){
        return "Erro!! O perfil" + this.usuario + "está desativado, tente outra opção.";
    }

    
}
