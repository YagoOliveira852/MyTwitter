package Perfis;

import java.util.Vector;
import Perfis.Exceptions.SIException;
import twitter.Tweet;

public abstract class Perfil {
    private String usuario;
    private Vector<Perfil> seguidos;
    private Vector<Perfil> seguidores;
    private Vector<Tweet> timeline;
    private boolean ativo;
    
    public Perfil (String usuario){
        this.setUsuario(usuario);
        this.setAtivo(true);
        this.timeline = new Vector<Tweet>();
        this.seguidos = new Vector<Perfil>();
        this.seguidores = new Vector<Perfil>();
        
    } 

    public void addSeguido(Perfil usuario)throws SIException{
        if(!this.usuario.equals(usuario.getUsuario())){
            seguidos.add(usuario);
        }
        else{
            throw new SIException(usuario);
        }
    }

    public void addSeguidor(Perfil usuario) throws SIException{
        if(!this.usuario.equals(usuario.getUsuario())){
            seguidores.add(usuario);
        }
        else{
            throw new SIException(usuario);
        }
    }
    
    public void addTweet(Tweet tweet){
        timeline.add(tweet);
    }

    public void setUsuario(String usuario){
        this.usuario = usuario;
    }

    public String getUsuario() {
        return usuario;
    }

    public Vector<Perfil> getSeguidos() {
        return seguidos;
    }

    public Vector<Perfil> getSeguidores() {
        return seguidores;
    }

    public Vector<Tweet> getTimeline() {
        return timeline;
    }

    public void setAtivo(boolean ativo) {
        this.ativo = ativo;
    }

    public boolean isAtivo() {
        return ativo;
    }

  }