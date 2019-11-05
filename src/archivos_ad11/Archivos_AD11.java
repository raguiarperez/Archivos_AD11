/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package archivos_ad11;

import java.io.IOException;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.io.RandomAccessFile;

/**
 *
 * @author dam2
 */
public class Archivos_AD11 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws FileNotFoundException {
        
         
        try {
        String[] codes={"p1","p2","p3"};
        String[] descricion ={"parafusos","cravos","tachas"};
        int[] prices ={3,4,5};
        File fichero1=new File("textorandom.txt");
        fichero1.createNewFile();
        RandomAccessFile escritura=new RandomAccessFile(fichero1,"rwd");
        RandomAccessFile lectura=new RandomAccessFile(fichero1,"rwd");
        String codigo,descripcion;
        int precio;
        for(int i=0;i<=2;i++){  // 
            codigo=codes[i]; //Se copia en el String un codigo de cada vez
            codigo = String.format("%"+3+"s", codigo); //damos formato a la cadena, con un ancho de 3 a la cadena codigo
            descripcion=descricion[i]; 
            descripcion = String.format("%"+10+"s", descripcion); //Como maximo 10 caracteres el % llena con blancos la izquierda
            escritura.writeChars(codigo);
            escritura.writeChars(descripcion);
            escritura.writeInt(prices[i]);
        }
        escritura.close();
        lectura.seek(30);
        String cod="",des="";
        for(int i=0;i<3;i++){  //Se meten los caracteres en texto y se quitan los espacios
            char texto=lectura.readChar();
            if(texto!=' '){
            cod=cod+texto;
            }
        }
        for(int i=0;i<10;i++){
            char texto=lectura.readChar();
            if(texto!=' '){
            des=des+texto;
            }
        }
        System.out.println(cod);
        System.out.println(des);
        System.out.println(lectura.readInt());
        lectura.close();
        }catch (IOException e) {
            System.out.println(e.getMessage());
        } 
    }
}