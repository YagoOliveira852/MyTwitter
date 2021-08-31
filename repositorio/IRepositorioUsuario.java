package repositorio;
import Perfis.Perfil;
import repositorio.Exceptions.UJCException;
import repositorio.Exceptions.UNCException;

public interface IRepositorioUsuario {

    public void cadastrar(Perfil usuario) throws UJCException;
    public Perfil buscar(String usuario);
    public void atualizar(Perfil usuario) throws UNCException;
}