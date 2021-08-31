package Perfis.Exceptions;

import Perfis.Perfil;

public class SIException extends Exception {

    private Perfil usuario;

    public SIException(Perfil usuario) {
        super("Seguidor Inválido");
        this.setUsuario(usuario);
    }

    public String GetMessage(){
        return "Erro!! O nome de usuário do seguidor é o mesmo do seguido, tente outra opção.";
    }

    public Perfil getUsuario() {
        return usuario;
    }

    public void setUsuario(Perfil usuario) {
        this.usuario = usuario;
    }
}
