package twitter;
import java.util.Vector;
import repositorio.IRepositorioUsuario;
import Perfis.Perfil;
import Perfis.Exceptions.PAException;
import Perfis.Exceptions.PDException;
import Perfis.Exceptions.PEException;
import Perfis.Exceptions.PIException;
import Perfis.Exceptions.SIException;
import repositorio.Exceptions.UJCException;
import twitter.Exceptions.MFPException;

public class MyTwitter implements ITwitter {
    private IRepositorioUsuario repositorio;

    public MyTwitter(IRepositorioUsuario repositorio){
        this.repositorio = repositorio;
    }

    public void criarPerfil(Perfil usuario)throws PEException{
        try {
            repositorio.cadastrar(usuario);
            System.out.println("Perfil Criado com Sucesso!!");
        } catch (UJCException ujce) {
            throw new PEException(usuario);
        }
        
    }

    public void cancelarPerfil(String usuario) throws PIException, PDException{
        
        Perfil conta = repositorio.buscar(usuario);
        if(conta != null){
            if(conta.isAtivo() == true){
                conta.setAtivo(false);
                System.out.println("Perfil Desativado com Sucesso!!");
            }
            else{
                throw new PDException(conta);
            }
        }
        else{
            throw new PIException(conta);
        }
    }

    public void reativarPerfil(String usuario) throws PIException, PAException{
        
        Perfil conta = repositorio.buscar(usuario);
        if(conta != null){
            if(conta.isAtivo() == false){
                conta.setAtivo(true);
                System.out.println("Perfil Reativado com Sucesso!!");
            }
            else{
                throw new PAException(conta);
            }
        }
        else{
            throw new PIException(conta);
        }
        
        
    }

    public void tweetar(String usuario, String mensagem) throws PIException, PDException, MFPException{
        Perfil conta = repositorio.buscar(usuario);
        if(mensagem.length()>=1 && mensagem.length()<=140){
        
            if(conta != null){
                if(conta.isAtivo() == true){
                    Tweet tweet = new Tweet(usuario, mensagem);
                    conta.addTweet(tweet);
                    Vector<Perfil> seguidores = conta.getSeguidores(); 
                    for(Perfil seguidor : seguidores){
                        seguidor.addTweet(tweet);
                    }
                    System.out.println("Tweet publicado com sucesso!!");
                }
                else{
                    throw new PDException(conta);
                }
            }
            else{
                throw new PIException(conta);
            }
        }
        else{
            throw new MFPException(usuario);
        }
        
    }

    public Vector<Tweet> timeline(String usuario) throws PIException, PDException{
        Perfil conta = repositorio.buscar(usuario);
        if(conta != null){
            if(conta.isAtivo() == true){
                return conta.getTimeline();
            }
            else{
                throw new PDException(conta);
            }
        }
        else{
            throw new PIException(conta);
        }
    }

    public Vector<Tweet> tweets(String usuario) throws PIException, PDException{
        Perfil conta = repositorio.buscar(usuario);
        Vector<Tweet> mytimeline = new Vector<Tweet>();
        if(conta != null){
            if(conta.isAtivo() == true){
                for(Tweet tweets : conta.getTimeline()){
                    if(tweets.getUsario().equals(usuario)){
                        mytimeline.add(tweets);
                    }
                }
                return mytimeline;
            }
            else{
                throw new PDException(conta);
            }
        }
        else{
            throw new PIException(conta);
        }
    }

    public void seguir(String seguidor, String seguido) throws PIException, PDException, SIException{
        Perfil contaSeguidor = repositorio.buscar(seguidor);
        Perfil contaSeguido = repositorio.buscar(seguido);
        if(contaSeguidor != null && contaSeguido != null){
            if(contaSeguido.isAtivo() == true && contaSeguidor.isAtivo() == true){
               contaSeguido.addSeguidor(contaSeguidor);
               contaSeguidor.addSeguido(contaSeguido);
            }
            else{  
                if(!contaSeguido.isAtivo()){
                    throw new PDException(contaSeguido);
                }
                else{
                    throw new PDException(contaSeguidor);
                }
                
            }
        }
        else{
            if(contaSeguido == null){
                throw new PIException(contaSeguido);
            }
            else{
                throw new PIException(contaSeguidor);
            }
        }
    }

    public int numeroSeguidores(String usuario) throws PDException, PIException{
        Perfil conta = repositorio.buscar(usuario);
        if(conta != null){
            if(conta.isAtivo() == true){
                return conta.getSeguidores().size();
            }
            else{
                throw new PDException(conta);
            }
        }
        else{
            throw new PIException(conta);
        }
        
    }

    public Vector<Perfil> seguidores(String usuario) throws PIException, PDException{
        Perfil conta = repositorio.buscar(usuario);
        if(conta != null){
            if(conta.isAtivo() == true){
                return conta.getSeguidores();
            }
            else{
                throw new PDException(conta);
            }
        }
        else{
            throw new PIException(conta);
        }
    }
    public Vector<Perfil> seguidos(String usuario) throws PIException, PDException{
        Perfil conta = repositorio.buscar(usuario);
        if(conta != null){
            if(conta.isAtivo() == true){
                return conta.getSeguidos();
            }
            else{
                throw new PDException(conta);
            }
        }
        else{
            throw new PIException(conta);
        }
    }
}
