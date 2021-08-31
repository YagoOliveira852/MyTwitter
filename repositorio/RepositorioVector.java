package repositorio;

import java.util.Vector;

import Perfis.Perfil;
import repositorio.Exceptions.UJCException;
import repositorio.Exceptions.UNCException;

public class RepositorioVector  implements IRepositorioUsuario{
    private Vector<Perfil> contas;

    public RepositorioVector() {
        contas = new Vector<Perfil>();
    }

    public void cadastrar(Perfil usuario) throws UJCException {
        if(buscar(usuario.getUsuario()) == null){
            contas.add(usuario);
        }
        else{
            throw new UJCException(usuario);
        }
        
    }

    public Perfil buscar(String usuario) {
        for(int i=0 ; i<=contas.size() ; i++){
            if(this.contas.get(i).getUsuario().equals(usuario)){
                return contas.get(i);
            }
        }
        return null;
    }

    public void atualizar(Perfil usuario) throws UNCException {
        Perfil usuarioAntigo = buscar(usuario.getUsuario());
        if(usuarioAntigo == null){
            throw new UNCException(usuario);
        }
        else{
            int indice = contas.indexOf(usuarioAntigo);
            usuarioAntigo = usuario;
            contas.set(indice, usuarioAntigo);

        }
        
    }
    
}
