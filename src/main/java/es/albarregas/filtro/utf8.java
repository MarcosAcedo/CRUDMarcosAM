/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package es.albarregas.filtro;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;

/**
 * Filtra las paginas para que los carácteres especiales se muestren correctamente
 * 
 */
@WebFilter(filterName = "UTF8", urlPatterns = {"/*"})
public class utf8 implements Filter {

    /**
     *
     * @param fConfig Parámetro inicial
     * @throws ServletException Excepción
     */
    @Override
    public void init(FilterConfig fConfig) throws ServletException {
    }

    /**
     *
     * @param request Petición
     * @param response Respuesta
     * @param chain Cambio
     * @throws IOException Excepción de entrada/salida
     * @throws ServletException Excepción
     */
    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
        request.setCharacterEncoding("UTF8");
        long antes = System.currentTimeMillis();
        chain.doFilter(request, response);
        long despues = System.currentTimeMillis();
        long espera = despues - antes;
        System.out.println("Tiempo de espera: " + espera + " milisegundos");
    }

    /**
     *
     */
    @Override
    public void destroy() {
    }
}
