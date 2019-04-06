/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Utils;


import java.util.List;
import ejb.UsuarioFacade;
import Entities.Usuario;
/**
 *
 * @author oscar
 */
public class AccountUtil {
    public static boolean usuarioDisponible(UsuarioFacade facade, String username){
        List<Usuario> lista = facade.findAll();
        int i = 0;
        while(i < lista.size() && lista.get(i).getUsername() != username){
            i++;
        }
        return i != lista.size();
    }
    
    public static boolean correoEnUso(UsuarioFacade facade, String email){
        List<Usuario> lista = facade.findAll();
        int i = 0;
        while(i < lista.size() && lista.get(i).getEmail() != email){
            i++;
        }
        return i != lista.size();
    }
}
