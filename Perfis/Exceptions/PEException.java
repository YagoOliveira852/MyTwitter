package Perfis.Exceptions;

import Perfis.Perfil;

public class PEException extends Exception{
    private Perfil usuario;

    public PEException(Perfil usuario) {
        super("Perfil Existente");
        this.usuario = usuario;
    }

    public String GetMessage(){
        return "Erro!! O perfil" + this.usuario + "já existe, tente outra opção.";
    }
    
    public Perfil getUsuario() {
        return usuario;
    }

    public void setUsuario(Perfil usuario) {
        this.usuario = usuario;
    }
}
