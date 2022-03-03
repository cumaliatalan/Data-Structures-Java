import java.util.Collections;
import java.util.Comparator;
import java.util.LinkedList;

interface methods {   //run sınıfının kullanacağı metotları barındıran arayüz.
    void console(LinkedList list);

    void forname(LinkedList list);

    void forheight(LinkedList list);
}

class Console {   //listeyi ekrana yazma sınıfı
    LinkedList linkedList;

    Console(LinkedList list) {
        linkedList = list;
    }

    public void console() {
        System.out.println("Liste:\n" + linkedList); //gönderilen listeyi ekrana yazdık.
    }
}

class Forname implements Comparator<Mounth> {  //isme göre sıralama yapan sınıf

    public int compare(Mounth first, Mounth second) {  //aynı şekilde comparator arayüzünden aldığımız metot. Nesnelerin isimlerini karşılaştırdık.
        return first.name.toLowerCase().compareTo(second.name.toLowerCase());
    }

}

class Forheight implements Comparator<Mounth> {  //yüksekliğe göre sıralama yapan fonksiyon.


    public int compare(Mounth first, Mounth second) { //Comparator interface sinden hazır olarak implements alldığımız metot. Nesnelerin yükseklikleri farkını bulup döndürdük.
        return (second.height - first.height);
    }
}

class Run implements methods {  //main de sadece run sınıfı ile işlem yapıyoruz.


    @Override
    public void console(LinkedList list) {  //console sınıfına bağlanıp gelen listeyi ekrana yazdırdık.
        Console console = new Console(list);
        console.console();
    }

    @Override
    public void forname(LinkedList list) {  // forname sınıfına bağlanıp isme göre sıraladık.
        Forname forname = new Forname();
        Collections.sort(list, forname); //collections sınıfının sort metodu ile istenilen formata göre sıralama gerçekleştirdik.
        System.out.println("İsme göre sıralama:\n" + list);
    }

    @Override
    public void forheight(LinkedList list) {  //forheight sınıfına bağlanıp yüksekliğe göre sıraladık
        Forheight forheight = new Forheight();
        Collections.sort(list, forheight);  //collections sınıfının sort metodu ile istenilen formata göre sıralama gerçekleştirdik.
        System.out.println("Yüksekliğe göre sıralama:\n" + list);
    }
}

class Mounth {  //Sıralamayı rahat yapmak için LinkedList elemanlarını nesnede tutacağız.
    String name;
    int height;

    Mounth(String name, int height) {
        this.name = name;
        this.height = height;
    }

    public String toString() {
        return name + " " + height;   //en son değerleri yazırmak için toString metodunu çağırdık.
    }
}


public class Soru2 {

    public static void main(String[] args) {
        LinkedList<Mounth> mounth = new LinkedList<Mounth>();  //nesne tabanlı LinkedList oluşturup elemanları yerleştirdik.
        mounth.add(new Mounth("Longs", 14255));
        mounth.add(new Mounth("Elbert", 14433));
        mounth.add(new Mounth("Maroon", 14156));
        mounth.add(new Mounth("Castle", 14265));
        mounth.add(new Mounth("ağrı", 5680));

        Run run = new Run();  //run sınıfına bağlanıp istenilen metotları çalıştırdık.
        run.console(mounth);
        run.forname(mounth);
        run.forheight(mounth);
    }
}