/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package arvorebinaria_1;

/**
 *
 * @author icalc
 */
public class ArvoreBinaria_1 {
    
    public No raiz = null;
    
    public No getRaiz(){
        return raiz;
    }
    public void setRaiz(String e){
        raiz.setElement(e);
    }
    public ArvoreBinaria_1(String e){ 
        raiz = new No(e, null, null);
    }

    private ArvoreBinaria_1() {
        raiz = null;
    }
    
    public void insertRaiz(String e){
        if (raiz == null){
            raiz = new No(e, null, null);
        }else{
           raiz.setElement(e);
        }
    }
    public boolean isEmpty(){
        return raiz == null;
    } 

    public void emOrdemSimetrica( No raiz ){
        if (raiz != null){
            emOrdemSimetrica( raiz.getSubEsq() );
            System.out.println( raiz.getElement() );
            emOrdemSimetrica( raiz.getSubDir() );
        }
    }
    
    public void preOrdem( No raiz ){
        if (raiz != null){
            System.out.println( raiz.getElement() );
            preOrdem( raiz.getSubEsq() );
            preOrdem( raiz.getSubDir() );
        }
    }
    
    public void posOrdem( No raiz ){
        if (raiz != null){
            posOrdem( raiz.getSubEsq() );
            posOrdem( raiz.getSubDir() );
            System.out.println( raiz.getElement() );
        }
    }
   
    public void emNivel(){
        No noAux;
        ArrayQueue f;
        if (raiz != null){
            f = new ArrayQueue(); 
            f.enQueue( raiz );
            while( !f.qIsEmpty() ){
                noAux = (No) f.deQueue ();
                if (noAux.getSubEsq() != null)
                    f.enQueue( noAux.getSubEsq() );
                if (noAux.getSubDir() != null) 
                    f.enQueue( noAux.getSubDir() );
                System.out.println( noAux.getElement() );
            } 
        } 
    }
    
    public No searchNo( No raiz, String dado ){
        No aux;
    
        if (raiz != null) {
            // Se elemento encontrado
            if (raiz.getElement().compareTo( dado ) == 0) 
                return raiz;
            else{ // Se não encontrado, busca primeiro do lado esquerdo 
                aux = searchNo( raiz.getSubEsq(), dado );
                if (aux == null)  // Procura do lado direito da árvore
                    aux = searchNo( raiz.getSubDir(), dado );
                return aux;
            }
        }
        else // Elemento “dado” não encontrado na árvore
            return null;
    }

    public boolean insertSubEsq( String e, String info) {
        No novo, pai;
    
        pai = searchNo( raiz, info );
        if ( pai != null ) { // encontrado o nó onde está a informação
           novo = new No ( e, null, null );
           if ( novo == null) return false; // Não há memória disponível
           else {
               // se nó alocado com sucesso
               if (pai.getSubEsq() == null)
                   pai.setSubEsq( novo );
               else { // como há nó intermediário insere o novo nó no meio
                   novo.setSubEsq( pai.getSubEsq() );
                   pai.setSubEsq( novo );
               } return true; // Inserção realizada com sucesso
            }
        } else
            return false; // O nó onde se encontra do dado não foi encontrado
    } 

    public boolean insertSubDir( String e, String info) {
        No novo, pai;
        pai = searchNo( raiz, info );
        if ( pai != null ) { // encontrado o nó onde está a informação
            novo = new No (e, null, null);
            if ( novo != null ) { // se nó alocado com sucesso
                if (pai.getSubDir() == null)
                    pai.setSubDir( novo );
                else { // como há nó intermediário insere o novo nó no meio
                    novo.setSubDir( pai.getSubDir() );
                    pai.setSubDir( novo );
                } return true; // Inserção realizada com sucesso
            } else
                return false; // Não há memória disponível
        } else
            return false; // O nó onde se encontra do dado não foi encontrado
    }

        
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        ArvoreBinaria_1 Ab1 = new ArvoreBinaria_1();
        Ab1.insertRaiz("A");
        Ab1.insertSubEsq("B", "A");
        Ab1.insertSubEsq("C", "B");
        Ab1.insertSubEsq("F", "C");
        Ab1.insertSubDir("D", "B");
        Ab1.insertSubDir("L", "D");
        Ab1.insertSubDir("E", "A");
        Ab1.insertSubEsq("G", "E");
        Ab1.insertSubEsq("I", "G");
        System.out.println("*********pre ordem");;
        Ab1.preOrdem(Ab1.getRaiz());
        System.out.println("********semetrica");;
        Ab1.insertRaiz("A");
        Ab1.emOrdemSimetrica(Ab1.getRaiz());
        System.out.println("*******nivel");;
        Ab1.emNivel();
        System.out.println("*******pos ordem");;
        Ab1.posOrdem(Ab1.getRaiz());
        
    }
    
}
