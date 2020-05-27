package servlets.login;

import server.server.dao.UsuarioDao;
import server.server.dto.UsuarioDto;

public class LoginService {

    public boolean isUserValid(String user, String password){
        UsuarioDao usuarioDao = new UsuarioDao();
        UsuarioDto usuario = new UsuarioDto();
        usuario.setMail(user);
        usuario.setPassword(password);
        if(usuarioDao.getAutentication(usuario)){
            return true;
        }
        return false;
    }

}
