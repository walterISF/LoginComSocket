/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package socket;

import java.io.Serializable;
import java.lang.reflect.Method;

/**
 *
 * @author vntwafi
 * @param <X>
 */
public class Lista <X> implements Cloneable, Serializable
{
    private class No
    {
        private X  info;
        private No prox;

        public void setInfo (X i)
        {
                this.info = i;
        }

        public void setProx (No p)
        {
                this.prox = p;
        }

        public X getInfo ()
        {
                return this.info;
        }

        public No getProx ()
        {
                return this.prox;
        }

        public No (X i, No p)
        {
                this.setInfo (i);
                this.setProx (p);
        }

        public No (X i)
        {
                this (i,null);
        }
    }
	
    private No prim=null;

    private X meuCloneDeX (X modelo)
    {
      //return (X)modelo.clone();
        X ret=null;
        try
        {
            Class<?> classe = modelo.getClass();
            Class<?>[] tipoDoParametroFormal = null; // null pq nao tem parametros
            Method metodo = classe.getMethod ("clone", tipoDoParametroFormal);
            Object[] parametroReal = null; // null pq nao tem parametros
            ret = (X)metodo.invoke (modelo, parametroReal);
        }
        catch (Exception erro)
        {}
        return ret;
    }
	
    public void inserirNoInicio (X i) throws Exception
    {
        if (i==null)
            throw new Exception ("Informacao ausente");

        X info;
        if (i instanceof Cloneable)
            info=meuCloneDeX(i);
        else
            info=i;

        this.prim = new No (info, this.prim);
    }
	
    public void inserirNoFim (X i) throws Exception
    {
        if (i==null)
            throw new Exception ("Informacao ausente");

        X info;
        if (i instanceof Cloneable)
            info=meuCloneDeX(i);
        else
            info=i;

        if (this.prim==null)
            this.prim = new No (info);
        else
        {
            No atual=this.prim;

            while (atual.getProx()!=null)
                    atual = atual.getProx ();

            atual.setProx (new No (info));
        }
    }
	
    public int getQtdElems ()
    {
        int cont=0;

        No atual = this.prim;

        while (atual!=null)
        {
            cont++;
            atual=atual.getProx();
        }

        return cont;
    }
	
    public boolean tem (X i)
    {	
        No atual = this.prim;

        while (atual!=null)
        {
            if (i.equals(atual.getInfo()))
                return true;

            atual=atual.getProx();
        }

        return false;
    }
    
    public Partida getPartida (String nome)
    {	
        No atual = this.prim;
        Partida partida;
        while (atual!=null)
        {
            partida = (Partida)atual.getInfo();
            if (partida.equals(atual.getInfo()))
                return partida;

            atual=atual.getProx();
        }

        return null;
    }
    
        public Baralho getBaralho (int posicao)
    {	
        No atual = this.prim;
        Baralho baralho;
        while (atual!=null)
        {
            baralho = (Baralho)atual.getInfo();
            if (baralho.equals(atual.getInfo()))
                return baralho;
        }

        return null;
    }
	
    public void removerDoInicio () throws Exception
    {
        if (this.prim==null)
            throw new Exception ("Lista vazia");

        this.prim = this.prim.getProx ();
    }

    public void removerDoFim () throws Exception
    {
        if (this.prim==null)
            throw new Exception ("Lista vazia");

        if (this.prim.getProx()==null)
            this.prim=null;
        else
        {	
            No atual = this.prim;

            while (atual.getProx().getProx() != null)
                atual = atual.getProx();

                atual.setProx (null);
        }	
    }
    
    public X removerDoMeio(int posicao) throws Exception
    {
        X info = null;
        if (this.prim==null)
            throw new Exception ("Lista vazia");
        
        if (this.prim.getProx()==null)
            this.prim=null;
        else
        {
            No atual = this.prim;
            No remover;
            for(int i=0; i<posicao; i++)
            {
                atual = atual.getProx();
            }
            remover = atual.getProx();
            atual.setProx(atual.getProx().getProx());
            info = remover.getInfo();
        }
        
        return info;
    }
	
    @Override
    public String toString ()
    {
        String ret = "{";

        No atual=this.prim;

        while (atual!=null)
        {
            ret=ret+atual.getInfo();

            if (atual.getProx()!=null)
                ret=ret+",";

            atual=atual.getProx();
        }

        return ret+"}";
    }
	
    @Override
    public boolean equals (Object obj)
    {
        if (this==obj)
            return true;

        if (obj==null)
            return false;

        if (this.getClass() != obj.getClass())
            return false;

        Lista<X> lista = (Lista<X>)obj;

        No pThis =this .prim;
        No pLista=lista.prim;

        while (pThis!=null && pLista!=null)
        {
            if (!pThis.getInfo().equals(pLista.getInfo()))
                return false;

            pThis =pThis .getProx();
            pLista=pLista.getProx();
        }

        if (pThis!=null || pLista!=null)
                return false;

        return true;
    }
	
    @Override
    public int hashCode ()
    {
        int ret=777;

        No atual=this.prim;

        while (atual!=null)
        {
            ret=7*ret + atual.getInfo().hashCode();
            atual=atual.getProx();
        }

        return ret;
    }
	
    public Lista (Lista<X> modelo) throws Exception
    {
        if (modelo==null)
            throw new Exception ("Modelo ausente");

        if (modelo.prim==null)
            return;

        this.prim = new No (modelo.prim.getInfo());

        No atualThis=this.prim, atualModelo=modelo.prim;

        while (atualModelo.getProx()!=null)
        {
            atualThis.setProx (new No (atualModelo.getProx().getInfo()));
            atualThis  =atualThis.getProx();
            atualModelo=atualModelo.getProx();
        }
    }
    
    public Lista()
    {
        
    }
	
    @Override
    public Object clone ()
    {
        Lista<X> ret=null;

        try
        {
            ret = new Lista<X> (this);
        }
        catch (Exception erro)
        {}

        return ret;
    }
}
