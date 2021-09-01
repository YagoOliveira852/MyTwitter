package twitter;
import java.util.Vector;

import Perfis.Perfil;
import Perfis.Exceptions.PAException;
import Perfis.Exceptions.PDException;
import Perfis.Exceptions.PEException;
import Perfis.Exceptions.PIException;
import Perfis.Exceptions.SIException;
import twitter.Exceptions.MFPException;

public interface ITwitter {
    
    public void criarPerfil(Perfil usuario) throws PEException;
    public void cancelarPerfil(String usuario) throws PIException, PDException;
    public void reativarPerfil(String usuario) throws PIException, PAException;
    public void tweetar(String usuario, String mensagem) throws PIException, PDException, MFPException;
    public Vector<Tweet> timeline(String usuario) throws PIException, PDException;
    public Vector<Tweet> tweets(String usuario) throws PIException, PDException;
    public void seguir(String seguidor, String seguido) throws PIException, PDException, SIException;
    public int numeroSeguidores(String usuario) throws PIException, PDException;
    public Vector<Perfil> seguidores(String usuario) throws PIException, PDException;
    public Vector<Perfil> seguidos(String usuario) throws PIException, PDException;

}
