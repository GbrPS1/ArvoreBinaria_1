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
public class No {
    private String e;
    private No subEsq;
    private No subDir;
    public No (){ 
        this( "", null, null); 
    } 
    public No (String e, No subEsq, No subDir){ 
        this.e = e;
        this.subEsq = subEsq; 
        this.subDir = subDir; 
    }
    public String getElement(){ 
        return e; 
    }
    public No getSubEsq(){ 
        return subEsq; 
    }
    public No getSubDir(){ 
        return subDir; 
    }
    public void setElement(String e){ 
        this.e = e; 
    }
    public void setSubEsq(No subEsq) { 
        this.subEsq = subEsq; 
    }
    public void setSubDir(No subDir) { 
        this.subDir = subDir; 
    }
}
