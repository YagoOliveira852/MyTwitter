package Perfis.Exceptions;

import Perfis.Perfil;

public class PIException extends Exception {
    private Perfil usuario;

    public PIException(Perfil usuario) {
        super("Perfil Inexistente");
        this.setUsuario(usuario);
    }

    public Perfil getUsuario() {
        return usuario;
    }

    public void setUsuario(Perfil usuario) {
        this.usuario = usuario;
    }

    public String GetMessage(){
        return "Erro!! O perfil" + this.usuario + "não existe, tente outra opção.";
    }
}
