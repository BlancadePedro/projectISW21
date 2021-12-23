package icai.dtc.isw.controler;

import icai.dtc.isw.dao.BarriosDAO;
import icai.dtc.isw.dao.CustomerDAO;
import icai.dtc.isw.domain.Customer;

import java.util.ArrayList;

public class BarriosControler {
    //Relacionado con barrios
    public void getAustrias(ArrayList<Object> lista){
        BarriosDAO.getAustrias(lista);}
    public void getChueca(ArrayList<Object> lista){BarriosDAO.getChueca(lista);}
    public void getCondeDuque(ArrayList<Object> lista){BarriosDAO.getCondeDuque(lista);}
    public void getLatina(ArrayList<Object> lista){BarriosDAO.getLatina(lista);}
    public void getLavapies(ArrayList<Object> lista){BarriosDAO.getLavapies(lista);}
    public void getLetras(ArrayList<Object> lista){BarriosDAO.getLetras(lista);}
    public void getMalasana(ArrayList<Object> lista){BarriosDAO.getMoncloa(lista);}
    public void getMoncloa(ArrayList<Object> lista){BarriosDAO.getMoncloa(lista);}
    public void getPaseoArte(ArrayList<Object> lista){BarriosDAO.getPaseoArte(lista);}
    public void getRetiro(ArrayList<Object> lista){BarriosDAO.getRetiro(lista);}
    public void getSalamanca(ArrayList<Object> lista){BarriosDAO.getSalamanca(lista);}
    public void getSalesas(ArrayList<Object> lista){BarriosDAO.getSalesas(lista);}
    public void getSol(ArrayList<Object> lista){BarriosDAO.getSol(lista);}
    public void addFavorito(Object lugar, Customer perfil){BarriosDAO.addFavorito(lugar, perfil);
        System.out.println("ENTRO EN Controler /addFavorito");}
}
