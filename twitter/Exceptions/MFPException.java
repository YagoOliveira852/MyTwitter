package twitter.Exceptions;

public class MFPException extends Exception {
    private String mensagem;

    public MFPException(String mensagem) {
        super("Mensagem Fora do Padão");
        this.setMensagem(mensagem);
    }


    public String getMensagem() {
        return mensagem;
    }


    public void setMensagem(String mensagem) {
        this.mensagem = mensagem;
    }


    public String GetMessage(){
        if(mensagem.length()<1){
            return "Erro!! A mensagem não tem o mínimo de caracteres, tente outra opção.";
        }
        else{
            return "Erro!! A mensagem ultrapassou o limite de 140 caracteres, tente outra opção.";
        }
    }
}
