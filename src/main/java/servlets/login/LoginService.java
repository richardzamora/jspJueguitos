package servlets.login;

import server.server.controlador.UsuarioControlador;
import server.server.dao.UsuarioDao;
import server.server.dto.UsuarioDto;

public class LoginService {

    public boolean isUserValid(String user, String password){
        UsuarioControlador usuarioControlador = new UsuarioControlador();
        if(usuarioControlador.autentication(user, password)){
            return true;
        }
        return false;
    }

}
