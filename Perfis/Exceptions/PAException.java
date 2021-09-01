package Perfis.Exceptions;

import Perfis.Perfil;

public class PAException extends Exception {
    private Perfil usuario;

    public PAException(Perfil usuario) {
        super("Perfil Ativado");
        this.setUsuario(usuario);
    }

    public Perfil getUsuario() {
        return usuario;
    }

    public void setUsuario(Perfil usuario) {
        this.usuario = usuario;
    }

    public String GetMessage(){
        return "Erro!! O perfil já está ativado, tente outra opção.";
    }
}
