import java.util.Comparator;
import java.util.LinkedList;
import java.util.Collections;


class Yazdir {  
    LinkedList linkedList;

    Yazdir(LinkedList list) {
        linkedList = list;
    }

    public void yazdir() {
        System.out.println("Liste:\n" + linkedList); 
    }
}

class IsmeGore implements Comparator<daglar> {  //comparator interface'i implement ederek compare methodu ile sıralamamızı gerçekleştirdik.

    public int compare(daglar dag1, daglar dag2) {  
        return dag1.name.toLowerCase().compareTo(dag2.name.toLowerCase());
    }

}

class Yukseklige_Gore implements Comparator<daglar> { //comparator interface'i implement ederek compare methodu ile sıralamamızı gerçekleştirdik.


    public int compare(daglar dag1, daglar dag2) { 
        return (dag2.height - dag1.height);
    }
}

class daglar { 
    
    String name;
    int height;

    daglar(String name, int yukseklik) {
    
        this.name = name;
        this.height = yukseklik;
    
    }

    public String toString() {
        
        return name + " " + height;   
    
    }
}


public class But2 {

    public static void main(String[] args) {
        LinkedList<daglar> daglar = new LinkedList<daglar>();  
        daglar.add(new daglar("Maroon", 14156));
        daglar.add(new daglar("Castle", 14265));
        daglar.add(new daglar("Beydagi", 5000));
        daglar.add(new daglar("Longs", 14255));
        daglar.add(new daglar("Elbert", 14433));
        
        
        new Yazdir(daglar).yazdir();
        Collections.sort(daglar, new IsmeGore());
        System.out.println("isme göre sıralama\n" + daglar);
        
        Collections.sort(daglar, new Yukseklige_Gore());
        System.out.println("yuksekliğe göre sıralama\n" + daglar);
        
             
    }
}