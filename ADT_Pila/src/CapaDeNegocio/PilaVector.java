/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package CapaDeNegocio;

/**
 *
 * @author Fernandoo Ayudantia SB
 */
public class PilaVector {
    //atributos
    int p[];
    int cima;
    //constructor
    public PilaVector(int cant){
        cima=-1;
        p=new int[cant];
    }
     /* 3|____| 
        2|____|
        1|____|
        0|____|
        -1       <- cima
     */
    public boolean vacia(){
        return cima==-1;
    }
     /* 3|__5__|<- cima 
        2|__4__|
        1|__3__|
        0|__2__|
           P       solo aqui estara llena
            p.length - 1
     */
    
    public boolean llena(){
        return cima==p.length-1;
    }
    
    
    //meter
    public void push(int elemento){
        if (llena()) {
            System.out.println("pila llena");
            System.exit(1);
        }else{
          cima++;
          p[cima]=elemento;
        }
    }
    //sacar
    public int pop(){
       cima--;
       return p[cima+1];
    }
     //sacar
    public int get(){   
       return p[cima];
    }
    
    public void eliminarcima(){
        if (cima>-1) {
            cima--;
        }
    }
    
    
    public void Eliminar(int elemento){
        PilaVector Aux=new PilaVector(cima+1);
        while (!vacia()) {            
            int y=pop();
            if (y!=elemento) {
                Aux.push(y);
            }
        }
         while (!Aux.vacia()) { 
             int y=Aux.pop();
             push(y);
         }
    }
    
    
    public void eliminarRepetidos(){
        PilaVector pilaaux=new PilaVector(cima+1);
        int x,cont;
        int j=0;
        while (j<cima) {            
            cont=0;//nrovecesque tengo en la pila
            while (!vacia()) {              
               pilaaux.push(pop());
            }
            x=pilaaux.pop();
            while (!pilaaux.vacia()) {                
                if (x!=pilaaux.get()) {
                    push(pilaaux.pop());
                }else{
                    cont++;
                    pilaaux.pop();
                }
            }
            if (cont==0) {
                push(x);
            }
            j++;
        }
    }
    
    
    public void eliminarRepe1(){
        PilaVector pilaaux=new PilaVector(cima+1);
        int x;
        int j=0;
        while (j<cima) {            
            while (cima>j) {              
               pilaaux.push(pop());
                System.out.println("---------");
                System.out.println(pilaaux.toString());
            }
            x=get();//get
            while (!pilaaux.vacia()) {                
                if (x!=pilaaux.get()) {
                    push(pilaaux.pop());
                }else{
                   
                    pilaaux.pop();
                }
            }
            j++;
        }
    }
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    public String toString(){
        String S="";
        for (int i = cima; i >= 0; i--) {
            S=S+"|_"+Integer.toString(p[i])+"_|";
            S=S+"\n";
        }
        return S;
    }
    
    
    
    
    
    
    public static void main(String[] args) {
        PilaVector pilaDePrueba=new PilaVector(20);
       pilaDePrueba.push(1);
       pilaDePrueba.push(3);
        for (int i = 1; i <=4; i++) {
            pilaDePrueba.push(i);
        }
        System.out.println(pilaDePrueba.toString());
        pilaDePrueba.eliminarRepe1();
         System.out.println(pilaDePrueba.toString());
        
    }
    
    
}
