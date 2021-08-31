package twitter;

public class Tweet {
    public String usuario;
    public String mensagem;

    public Tweet(String usuario, String mensagem) {
        this.usuario = usuario;
        this.mensagem = mensagem;
    }

    public void setMensagem(String mensagem){
        this.mensagem = mensagem;
    }

    public void setUsario(String usuario){
        this.usuario = usuario;
    }

    public String getUsario(){
        return usuario;
    }
    
    public String getMensagem(){
        return mensagem;
    }
}
