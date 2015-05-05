/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.santecorps.relatorios.aniversariantes;

import java.util.List;

/**
 *
 * @author Wolverine
 */
@SuppressWarnings("unchecked")
public class AniversarianteFactory {
    
    private static List<AniversariantesBean> listaAniversariante;

    public static List<AniversariantesBean> getListaAniversariante() {
        return listaAniversariante;
    }

    public static void setListaAniversariante(List<AniversariantesBean> listaAniversariante) {
        AniversarianteFactory.listaAniversariante = listaAniversariante;
    }

    public static List<AniversariantesBean> gerarLista(){
        return listaAniversariante;
    }
    
}
